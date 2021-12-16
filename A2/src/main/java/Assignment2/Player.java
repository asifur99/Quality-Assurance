package Assignment2;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * Client for GameServer
 *
 * @author Sebastian Gadzinski
 */
public class Player implements Serializable, Runnable {
    private String name;
    //These all are used by the game server player object
    private List<String> tiles;
    private Map<Character, Integer> map;
    private LinkedList<String> inputs;

    //Used for JSON purposes
    public Player(){
        this.map = new HashMap();
        map.put('R', 1);
        map.put('B', 2);
        map.put('G', 3);
        map.put('O', 4);
        inputs = new LinkedList<>();
    }

    /**
     * @author Yahio
     */
    public Player(String name) {
        this.name = name;
        this.tiles = new ArrayList<>();
        this.map = new HashMap();
        map.put('R', 1);
        map.put('B', 2);
        map.put('G', 3);
        map.put('O', 4);
        inputs = new LinkedList<>();
    }

    /**
     * ================================================_GS_================================================
     */

    public String getName() {
        return name;
    }

    public List<String> getTiles() {
        return tiles;
    }

    public String getTilesString() {
        StringBuilder sb = new StringBuilder();
        if (tiles.size() == 0) return "{}";
        sb.append("{");
        for (int i = 0; i < tiles.size(); i++) {
            sb.append(tiles.get(i));
            if (i != tiles.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * ================================================_CLASS_RELATED_================================================
     */

    /**
     * Set the players tiles USED FOR GAME SERVER PLAYER OBJECT (CLIENT DOES NOT USE THE TILES)
     *
     * @param tiles - tiles to be set
     */
    public void setTiles(List<String> tiles) {
        this.tiles = tiles;
        Game.sortTiles(this.tiles);
    }

    /**
     * Adds a tile to the current tiles USED FOR GAME SERVER PLAYER OBJECT (CLIENT DOES NOT USE THE TILES)
     *
     * @param tile - tiles to be set
     */
    public void addToTiles(String tile) {
        this.tiles.add(tile);
        Game.sortTiles(tiles);
    }

    /**
     * Calculates players current score
     *
     */
    public int score(){
        int total = 0;
        for (String s : tiles){
            if(s.substring(1).length() == 0){
                //TODO: if wildcard do something
            }
            else{
                total -= Integer.parseInt(s.substring(1));
            }
        }
        return total;
    }

    /**
     * See sif user needs to draw because of insufficient points from hand
     *
     * @return if user has to draw or not
     */
    public boolean hasToDraw() {
        List<String> currTile1 = new ArrayList<>(tiles);
        List<String> currTile2 = new ArrayList<>(tiles);
        int sum1 = calculateSet(currTile1) + calculateRun(currTile1);
        int sum2 = calculateRun(currTile2) + calculateSet(currTile2);
        return Math.max(sum1, sum2) <= 30;
    }

    public List<String> runningSet(List<String> currTiles){

        //R6 R7 * R9 -> R6 R7 R8 R9
        StringBuilder sb = new StringBuilder();
        int location = currTiles.indexOf("*");
        int score;
        char c;

        if(location >= currTiles.size()-1){
            score = Integer.parseInt(currTiles.get(location-1).substring(1)) + 1;
            c = currTiles.get(location - 1).charAt(0);
        }
        else{
            score = Integer.parseInt(currTiles.get(location+1).substring(1)) - 1;
            c = currTiles.get(location + 1).charAt(0);
        }

        sb.append(c).append(score);
        currTiles.set(location, sb.toString());

        return currTiles;
    }

    public List<String> convertJoker(List<String> arr){
        List<String> copy = new ArrayList<String>(arr);

        final String colors = "RGBO";

        if(arr.contains("*")){
            int location = arr.indexOf("*");

            //R9, G9, *, O9 -> R9 G9 O9
            arr.remove("*");

            Set<Integer> num = new HashSet<>();
            List<Character> rank = new ArrayList<>();

            //R10 -> 10
            for(String items : arr){
                num.add(Integer.parseInt(items.substring(1)));
            }

            //if same number
            if(num.size() == 1){

                //R10 -> R
                for(String items : arr) {
                    rank.add(items.charAt(0));
                }

                //Make the string of existing colors
                StringBuilder tempStr = new StringBuilder();
                for(int j = 0; j < rank.size(); j++){
                    String tempRank = rank.get(j).toString();
                    if(colors.contains(tempRank)){
                        tempStr.append(tempRank);
                    }
                }

                //get the color doesn't exist in the meld
                String temp = tempStr.toString();

                StringBuilder colToAdd = new StringBuilder();
                for(int i = 0; i < colors.length(); i++) {
                    if (!temp.contains(Character.toString(colors.charAt(i)))) {
                        colToAdd.append(colors.charAt(i));
                    }
                }

                if(colToAdd.toString().length() > 1){
                    colToAdd =  new StringBuilder().append(colToAdd.charAt(0));
                }

                //value of the joker
                String jokerVal = String.valueOf(colToAdd) + num.toArray()[0];
                arr.add(location, jokerVal);
            }
            //when not same number
            else{
                arr = runningSet(copy);
            }
        }

        return arr;
    }

    /**
     * See sif user needs to draw because of insufficient points from hand
     *
     * @author Yahio
     * @return points from a run
     */
    public int calculateRun(List<String> currTiles) {
        int sum = 0;
        int temp = 0;
        int count = 1;
        while (currTiles.size() != 0) {
            for (int i = 0; i < currTiles.size(); i++) {
                String tile = currTiles.get(i);
                if (tile.substring(1).equals("1")) {
                    sum += runFor1(currTiles, tile);
                    currTiles.remove(tile);
                    --i;
                    continue;
                }

                if(currTiles.contains("*")){
                    currTiles = convertJoker(currTiles);

                    //if the joker is in the starting of the array we make ammends
                    if(tile.equals("*")){
                        tile = currTiles.get(i);
                    }
                }

                temp += Integer.parseInt(tile.substring(1));
                currTiles.remove(tile);
                String nextTile = findNext(tile);
                while (currTiles.contains(nextTile)) {
                    temp += Integer.parseInt(nextTile.substring(1));
                    currTiles.remove(nextTile);
                    nextTile = findNext(nextTile);
                    count++;
                }
                if (count >= 3) {
                    sum += temp;
                }
                temp = 0;
                count = 1;
                --i;
            }

            count++;
        }
        return sum;
    }

    /**
     * Points from one run
     *
     * @author Yahio
     * @return points from a run
     */
    private int runFor1(List<String> currTiles, String tile) {
        String nextTile = findNext(tile);
        int count = 0;
        int sum = 1;
        while (currTiles.contains(nextTile)) {
            sum += Integer.parseInt(nextTile.substring(1));
            currTiles.remove(nextTile);
            nextTile = findNext(nextTile);
            count++;
        }
        String prevTile = findPrev(tile);
        while (currTiles.contains(prevTile)) {
            sum += Integer.parseInt(prevTile.substring(1));
            currTiles.remove(prevTile);
            prevTile = findPrev(prevTile);
            count++;
        }
        if (count >= 3) {
            return sum;
        }

        return 0;
    }

    /**
     * Find the previous tile related to the tile for a run
     *
     * @author Yahio
     * @param tile - tile to use to find a previous tile in a possible run
     * @return points from a run
     */
    public String findPrev(String tile) {
        // Since tile can only be R1
        String prev;
        if (tile.substring(1).equals("1")) {
            prev = tile.charAt(0) + "13";
        } else {
            int p = Integer.parseInt(tile.substring(1)) - 1;
            prev = tile.charAt(0) + Integer.toString(p);
        }
        return prev;
    }

    /**
     * Find the next tile related to the tile for a run
     *
     * @author Yahio
     * @param tile - tile to use to find a next tile in a possible run
     * @return points from a run
     */
    public String findNext(String tile) {
        int next = Integer.parseInt(tile.substring(1)) + 1;
        return tile.charAt(0) + Integer.toString(next);
    }

    /**
     * Calculates the points in a set
     *
     * @author Yahio
     * @param tiles - set
     * @return points from a set
     */
    public int calculateSet(List<String> tiles) {
        Map<Integer, HashSet<Character>> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (String tile: tiles) {
            if(tile.charAt(0) == '*' && tile.substring(1).length() == 0){
                continue;
            }

            else{
                int target = Integer.parseInt(tile.substring(1));
                if (!map.containsKey(target)) {
                    map.put(target, new HashSet<>());
                }
                map.get(target).add(tile.charAt(0));
            }
            count++;
        }

        for (int i = 1; i < 14; i++) {
            if(tiles.contains("*") && map.containsKey(i) && map.get(i).size() >= 2){
                List<String> converted = new ArrayList<>();
                for(int j = 0; j < map.get(i).size(); j++){
                    converted.add(map.get(i).toArray()[j] + Integer.toString(i));
                }

                converted.add("*");

                sum += calculateSet(convertJoker(converted));
            }

            else if (map.containsKey(i) && (map.get(i).size() >= 3)) {
                sum += i * map.get(i).size();
            }
        }
        return sum;
    }

    /**
     * Resets the players tiles
     *
     */
    public void reset() {
        this.tiles = new ArrayList<>();
    }

    /*
     * ================================================_NETWORKING_================================================
     */

    /**
     * Runs the Rummikub game by contacting the server through a socket
     *
     * @param socket - socket to connect to server
     */
    private void run(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str;
                while ((str = reader.readLine()) != null && str.length() != 0) {
                    if (!str.equals("END") && !str.equals("EDIT")) {
                        System.out.println(str);
                    } else {
                        break;
                    }
                }
                if (str.equals("END")) {
                    break;
                }

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Scanner s = new Scanner(System.in);
                if (str.equals("EDIT")) {
                    String table, hand;
                    System.out.println("Type end to kill the game OR, ");
                    System.out.println("Enter your updated hand without the tiles you want to use: ");
                    String rearangedHand = (inputs.isEmpty() ? s.nextLine() : inputs.removeFirst());
                    if(rearangedHand.equals("end")) {
                        writer.write(rearangedHand);
                        writer.write("\n");
                        writer.flush();
                    }
                    else{
                        System.out.println("Enter the updated table: ");
                        String rearangedTable = (inputs.isEmpty() ? s.nextLine() : inputs.removeFirst());
                        writer.write(rearangedHand);
                        writer.write("\n");
                        writer.write(rearangedTable);
                        writer.write("\n");
                        writer.flush();
                    }
                }else{
                    if(Config.TESTING_MODE){
                        while(s.hasNext()){
                            inputs.addLast(s.nextLine());
                        }
                    }else{
                        inputs.addLast(s.nextLine());
                    }
                    writer.write(inputs.removeFirst());
                    writer.write("\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Fail to receive message from server");
            e.printStackTrace();
        }
    }

    /**
     * Runs the Rummikub game by contacting the server through a socket
     *
     * @param strings - all strings wanting to be in System.in
     */
    public void writeToConsole(String[] strings){
        StringBuilder inString = new StringBuilder();
        for (String s : strings){
            inString.append(s + System.lineSeparator());
        }
        ByteArrayInputStream in = new ByteArrayInputStream((inString.toString()).getBytes());
        System.setIn(in);
        System.out.println(inString);
    }

    /**
     * Starts game process and connects to the GameServer
     *
     */
    public void startGame() {
        try {
            Socket socket = new Socket("localhost", Config.GAME_SERVER_PORT_NUMBER);
            ObjectOutputStream dOut = new ObjectOutputStream(socket.getOutputStream());
            dOut.writeObject(this);
            dOut.flush();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println((String) in.readObject());
            run(socket);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fail to join the server");
        }
    }

    /*
     * ================================================_RUNNERS_================================================
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = s.next();
        Player p = new Player(name);
        p.startGame();
        System.out.println("Game Over");
    }

    @Override
    public void run() {
        startGame();
    }

}