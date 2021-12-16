import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Deck deck;
    public Scanner userInput = new Scanner(System.in);
    public boolean testMode = false;
    public HashMap<Integer, Player[]> scoreSheet = new HashMap<Integer, Player[]>();

    private ArrayList<ArrayList<Tile>> table;
    public int round;
    private int maxRounds;
    private int currentPlayer;

    public Player[] players = new Player[3];

    public Game(int rounds){
        deck = new Deck();
        table = new ArrayList<ArrayList<Tile>>();
        round = 0;
        maxRounds = rounds;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Deck getDeck(){ return deck; }

    public Tile pullTile(){
        return deck.pullTile();
    }

    public ArrayList<ArrayList<Tile>> getTable() {
        return table;
    }

    public void resetGame(){
        deck.reset();
        table = new ArrayList<ArrayList<Tile>>();

        round++;
    }

    public boolean addToTable(ArrayList<Tile> tile){
        if(tile.size() >= 3){
            if (isRunning(tile)){
                table.add(table.size(), tile);
                return true;
            }
            else if (isSameNumber(tile)){
                table.add(table.size(), tile);
                return true;
            }
        }
        return false;
    }

    public boolean isRunning(ArrayList<Tile> arr){
        boolean ifTrue = false;
        int count = 0;
        while (count < arr.size() - 1){
            if(arr.get(count).getColor() == arr.get(count+1).getColor()){
                if (arr.get(count + 1).getRank() == (arr.get(count).getRank() + 1)){
                    ifTrue = true;
                }
                else {
                    ifTrue = false;
                }
            }
            else {
                ifTrue = false;
            }
            count++;
        }
        return ifTrue;
    }

    public boolean isSameNumber(ArrayList<Tile> arr){
        boolean ifTrue = false;

        int count = 0;
        while (count < arr.size() - 1){
            if(arr.get(count).getColor() != arr.get(count+1).getColor()){
                if (arr.get(count + 1).getRank() == arr.get(count).getRank()){
                    ifTrue = true;
                }
                else {
                    ifTrue = false;
                }
            }
            else {
                ifTrue = false;
            }
            count++;
        }

        return ifTrue;
    }

    public void updateJustPlayed(){
        for (int i = 0; i < table.size(); i++) {;
            for (int j = 0; j < table.get(i).size(); j++) {
                table.get(i).get(j).setJustPlayed(false);
            }
        }
    }

    public void updateJustMoved(int turns){
        for (int i = 0; i < table.size(); i++) {;
            for (int j = 0; j < table.get(i).size(); j++) {
                if(table.get(i).get(j).moved()){
                    if (turns == 0){
                        table.get(i).get(j).setJustMoved(false);
                    }
                }
            }
        }
    }

    public void manipulateTable(Tile tile){
        System.out.println("??: [1] Replace from Table or [2] Add to Table");
        int choice = userInput.nextInt();

        if (choice == 1){
            System.out.println("??: Which Meld to Swap from?");
            int meldRemove = userInput.nextInt();

            System.out.println("??: Which element you want to replace in the selected Meld?");
            int replace = userInput.nextInt();

            System.out.println("??: Which Meld to add the removed Tile to");
            int meldAdd = userInput.nextInt();

            System.out.println("??: After which element you want to add the removed Tile in the selected Meld?");
            int toAdd = userInput.nextInt();

            Tile looseTile;

            looseTile = table.get(meldRemove).get(replace);
            looseTile.setJustMoved(true);
            looseTile.setJustPlayed(false);

            tile.setJustMoved(true);
            tile.setJustPlayed(false);
            table.get(meldRemove).set(replace, tile);

            table.get(meldAdd).add(toAdd+1, tile);
        }
        else if(choice == 2){
            System.out.println("??: Which Meld you want to add to?");
            int meld = userInput.nextInt();

            System.out.println("??: After which element you want to add the removed Tile in the selected Meld?");
            int toAdd = userInput.nextInt();

            table.get(meld).add(toAdd+1, tile);
        }
    }

    public void showTable(){
        System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------|");
        for (int i = 0; i < table.size(); i++) {
            if(i % 2 == 0 && i > 0){
                System.out.println();
            }

            if (i % 2 != 0){
                System.out.print("               [" + i + "]:" + "{");
            }
            else{
                System.out.print(" [" + i + "]:" + "{");
            }
            for (int j = 0; j < table.get(i).size(); j++) {
                if (table.get(i).get(j).played()){
                    System.out.print(" [" + j +"]:" + table.get(i).get(j).getColor() + "" + table.get(i).get(j).getRank() + "* ");
                }
                else if (table.get(i).get(j).moved()){
                    System.out.print(" [" + j +"]:" + table.get(i).get(j).getColor() + "" + table.get(i).get(j).getRank() + "! ");
                }
                else {
                    System.out.print(" [" + j +"]:"+ table.get(i).get(j).getColor() + "" + table.get(i).get(j).getRank() + " ");
                }
            }
            System.out.print("}  ");
        }
        System.out.println("\n|----------------------------------------------------------------------------------------------------------------------------------------------------------|");
    }

    public void initPlayers(){
        for(int i = 0; i < 3; i++){
            System.out.println("Enter Player [" + i + "] Name: ");
            String name = userInput.nextLine();
            players[i] = new Player(name, this);
        }
    }

    public void showMenu(){
        System.out.println("Select Options Below: ");
        System.out.println("Press [1] Draw a Tile");
        System.out.println("Press [2] Make Melds and Add Them To the Table");
        System.out.println("Press [3] Next Player");
    }

    public int nextPlayer(int player){
        updateJustPlayed();
        updateJustMoved(players[player].turns);

        Tile tile = pullTile();

        if (tile != null && !testMode){
            players[player].hand.put(players[player].hand.size(), tile);
            players[player].sortHand();
        }
        else if (tile != null && testMode){
            players[player].hand.put(players[player].hand.size(), tile);
        }
        else {
            System.out.println("No more tiles left in Deck!");
        }

        if (player == 0){
            return 1;
        }
        else if (player == 1){
            return 2;
        }
        else {
            return 0;
        }
    }

    public int nextPlayer(int player, Tile tile){
        updateJustPlayed();
        updateJustMoved(players[player].turns);

        if (tile != null && !testMode){
            players[player].hand.put(players[player].hand.size(), tile);
            players[player].sortHand();
        }
        else if (tile != null && testMode){
            players[player].hand.put(players[player].hand.size(), tile);
        }
        else {
            System.out.println("No more tiles left in Deck!");
        }

        if (player == 0){
            return 1;
        }
        else if (player == 1){
            return 2;
        }
        else {
            return 0;
        }
    }

    public boolean isGame(int pNum){
        return players[pNum].hand.isEmpty();
    }

    public int calculateTileScore(int currentPlayer, ArrayList<ArrayList<Integer>> arraySet){
        int tileScore = 0;
        for (ArrayList<Integer> arr : arraySet){
            for (int option : arr){
                Tile temp = players[currentPlayer].hand.get(option);

                if (temp.getRank() > 10){
                    tileScore += 10;
                }
                else{
                    tileScore += temp.getRank();
                }
            }
        }

        return tileScore;
    }

    public void sendSelection(int currentPlayer){
        int n, sets;

        System.out.print("??: How many melds (sets) you want to put on the table: ");
        sets = userInput.nextInt();

        ArrayList<Integer> array = new ArrayList<>();

        if (sets > 1 && players[currentPlayer].turns == 0){
            int cSet = 0;
            ArrayList<ArrayList<Integer>> arraySet = new ArrayList<>();

            while (cSet < sets){
                System.out.print("??: How many tiles you want to put in meld " + (cSet + 1) + ": ");
                n = userInput.nextInt();

                if (n < 3){
                    System.out.println("!!: Tile must be more than 3.");
                    return;
                }

                array = new ArrayList<>();
                for(int i=0; i<n; i++){
                    System.out.println("??: Number of the tile to Add to meld " + (cSet+1));
                    array.add(userInput.nextInt());
                }

                arraySet.add(cSet, array);

                cSet++;
            }

            int tileScore = calculateTileScore(currentPlayer, arraySet);

            ArrayList<Tile> toAdd = new ArrayList<>();
            for (ArrayList<Integer> arr : arraySet){
                //gets the set
                toAdd = new ArrayList<>();

                for (int option : arr){
                    Tile add = players[currentPlayer].hand.get(option);
                    add.setJustPlayed(true);
                    toAdd.add(add);
                }

                if(tileScore >= 30 && addToTable(toAdd)){
                    for (Integer integer : arr) {
                        players[currentPlayer].hand.remove(integer);
                    }
                }
                else if(tileScore < 30){
                    System.out.println("!!: Total Score of the meld is less than 30, current score is: " + tileScore);
                    return;
                }
                else {
                    System.out.println("!!: Invalid Meld");
                    return;
                }
            }

            players[currentPlayer].turns++;
        }
        else if (sets > 1 && players[currentPlayer].turns > 0){
            int cSet = 0;
            ArrayList<ArrayList<Integer>> arraySet = new ArrayList<>();

            while (cSet < sets){
                System.out.print("??: How many tiles you want to put in meld " + (cSet + 1) + ": ");
                n = userInput.nextInt();

                if (n < 3){
                    System.out.println("!!: Tile must be more than 3.");
                    return;
                }

                array = new ArrayList<>();
                for(int i=0; i<n; i++){
                    System.out.println("??: Number of the tile to Add to meld " + (cSet+1));
                    array.add(userInput.nextInt());
                }

                arraySet.add(cSet, array);

                cSet++;
            }

            ArrayList<Tile> toAdd = new ArrayList<>();
            for (ArrayList<Integer> arr : arraySet){
                //gets the set
                for (int option : arr){
                    Tile add = players[currentPlayer].hand.get(option);
                    add.setJustPlayed(true);
                    toAdd.add(add);
                }

                if(addToTable(toAdd)){
                    for (Integer integer : arr) {
                        players[currentPlayer].hand.remove(integer);
                    }
                    toAdd = new ArrayList<>();
                }
                else {
                    System.out.println("!!: Invalid Meld");
                    return;
                }
            }
        }
        else if (players[currentPlayer].turns == 0){
            System.out.print("??: How many tiles you want to put on the table: ");
            n = userInput.nextInt();

            if (n < 3){
                System.out.println("!!: Not a proper meld and cannot add to the Table!");
                return;
            }

            for(int i=0; i<n; i++){
                System.out.println("??: Number of the tile to Add to form the meld");
                array.add(userInput.nextInt());
            }

            ArrayList<Tile> toAdd = new ArrayList<>();
            for (int i=0; i < array.size(); i++){
                toAdd.add(players[currentPlayer].hand.get(array.get(i)));
                toAdd.get(i).setJustPlayed(true);
            }

            int tileScore = 0;
            for (Tile tile : toAdd){
                if (tile.getRank() > 10){
                    tileScore += 10;
                }
                else {
                    tileScore += tile.getRank();
                }
            }

            if(tileScore >= 30 && addToTable(toAdd)){
                for (Integer integer : array) {
                    players[currentPlayer].hand.remove(integer);
                }
            }
            else if(tileScore < 30){
                System.out.println("!!: Total Score of the meld is less than 30");
                return;
            }
            else {
                System.out.println("!!: Invalid Meld");
                return;
            }

            players[currentPlayer].turns++;
        }
        else {
            System.out.print("??: How many tiles you want to put on the table: ");
            n = userInput.nextInt();

            if (n < 3){
                System.out.println("??: Which Tile from hand you want to use?");
                int tileNo = userInput.nextInt();
                Tile t = players[currentPlayer].hand.get(tileNo);
                manipulateTable(t);
            }

            for(int i=0; i<n; i++){
                System.out.println("??: Number of the tile to Add to form the meld");
                array.add(userInput.nextInt());
            }

            ArrayList<Tile> toAdd = new ArrayList<>();
            for (int i=0; i < array.size(); i++){
                toAdd.add(players[currentPlayer].hand.get(array.get(i)));
                toAdd.get(i).setJustPlayed(true);
            }

            if(addToTable(toAdd)){
                for (Integer integer : array) {
                    players[currentPlayer].hand.remove(integer);
                }
            }
            else {
                System.out.println("!!: Invalid Meld");
                return;
            }
        }

        if (!testMode){
            players[currentPlayer].sortHand();
        }
    }

    public void addToScoreSheet(int round, Player[] players){
        scoreSheet.put(round, players);
    }

    public HashMap<Integer, ArrayList<Score>> getScore(){
        System.out.println("SCORE SHEET:");
        HashMap<Integer, ArrayList<Score>> score = new HashMap<>();
        ArrayList<Score> arrayList = new ArrayList<>();

        int winnerScore = 0;
        int winner = 0;

        for (int i=0; i<scoreSheet.size(); i++){
            for (int j=0; j<scoreSheet.get(i).length; j++){
                if (scoreSheet.get(i)[j].winner){
                    arrayList.add(new Score(j, winnerScore));
                    winner = j;
                }
                else {
//                    int s = -1 * (scoreSheet.get(i)[j].getScore())/2;
                    int s = -1 * (scoreSheet.get(i)[j].getScore());

                    winnerScore += (scoreSheet.get(i)[j].getScore());
                    arrayList.add(new Score(j, s));
                    System.out.println(scoreSheet.get(i)[j].name + ": " + s);
                }
            }
        }

        winnerScore /= 2;
        System.out.println(scoreSheet.get(round-1)[winner].name + ": " + winnerScore);
        arrayList.add(winner, new Score(winner, winnerScore));
        score.put(round-1, arrayList);

        return score;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void startGame(){
        currentPlayer = 0;

        while (round < maxRounds){
            currentPlayer = 0;
            System.out.println("!!: Round " + round + " Begin!");

            while (true){
                System.out.println("\nCurrent Player is: " + players[currentPlayer].name);
                showTable();
                for (Player player : players){
                    player.showHand();
                }
                showMenu();
                System.out.println("Input here: ");
                int choice = userInput.nextInt();
                if (choice == 1){
                    currentPlayer = nextPlayer(currentPlayer);
                    showTable();
                    for (Player player : players){
                        player.showHand();
                    }
                }
                else if (choice == 2){
                    showTable();
                    players[currentPlayer].showHand();
                    sendSelection(currentPlayer);
                }
                else if (choice == 3){
                    if (isGame(currentPlayer)){
                        break;
                    }
                    currentPlayer = players[currentPlayer].moveNextPlayer(currentPlayer);
                }
            }

            players[currentPlayer].setWinner(true);

            addToScoreSheet(round, players);
            System.out.println("\n!!: Winner of the round is: " + players[currentPlayer].name);
            round++;
        }

        getScore();
    }

    public static void main(String[] args) {
        Game game = new Game(1);

        game.initPlayers();
        game.startGame();
    }
}

class Score{
    int playerNum;
    int score;

    public Score(int player, int score){
        this.playerNum = player;
        this.score = score;
    }
}