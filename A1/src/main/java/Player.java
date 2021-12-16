import java.util.*;

public class Player {
    public String name;
    HashMap<Integer, Tile> hand;
    public int turns;
    int score;
    boolean winner;
    Game game;

    public Player(String name, Game game) {
        this.name = name;
        hand = new HashMap<>();
        this.game = game;

        for(int i = 0; i < 14; i++){
            hand.put(i, this.game.pullTile());
        }
        sortHand();

        turns = 0;
        score = 0;
        winner = false;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public HashMap<Integer, Tile> showHand(){
        System.out.print(name + " hand => ");
        for (Map.Entry<Integer, Tile> hand : hand.entrySet()) {
            System.out.print("[" + hand.getKey() + "]" + ":" + hand.getValue().getColor() + "" + hand.getValue().getRank() + " ");
        }
        System.out.println();

        return hand;
    }

    public void sortHand(){
        ArrayList<Tile> red = new ArrayList<>();
        ArrayList<Tile> blue = new ArrayList<>();
        ArrayList<Tile> green = new ArrayList<>();
        ArrayList<Tile> orange = new ArrayList<>();

        for (Map.Entry<Integer, Tile> entry : hand.entrySet()) {
            if(entry.getValue().getColor() == 'R'){
                red.add(entry.getValue());
            }
            else if(entry.getValue().getColor() == 'B'){
                blue.add(entry.getValue());
            }
            else if(entry.getValue().getColor() == 'G'){
                green.add(entry.getValue());
            }
            else {
                orange.add(entry.getValue());
            }
        }

        Collections.sort(red);
        Collections.sort(blue);
        Collections.sort(green);
        Collections.sort(orange);

        hand.clear();
        hand.putAll(convertArrayListToHashMap(red, 0));
        hand.putAll(convertArrayListToHashMap(blue, hand.size()));
        hand.putAll(convertArrayListToHashMap(green, hand.size()));
        hand.putAll(convertArrayListToHashMap(orange, hand.size()));
    }

    private static HashMap<Integer, Tile> convertArrayListToHashMap(ArrayList<Tile> arrayList, int count){
        HashMap<Integer, Tile> temp = new HashMap<>();

        for (int i = 0; i < arrayList.size(); i++){
            temp.put(count, arrayList.get(i));
            count++;
        }

        return temp;
    }

    public void setHand(ArrayList<Tile> arr) {
        Object[] keys = hand.keySet().toArray();

        for (int i = 0; i < arr.size(); i++){
            hand.replace((Integer) keys[i], arr.get(i));
        }
    }

    public int moveNextPlayer(int player){
        game.updateJustPlayed();

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

    public int getScore() {
        sortHand();

        for (int i = 0; i<hand.size(); i++){
            if (hand.get(i).getRank() > 10){
                score += 10;
            }
            else {
                score += hand.get(i).getRank();
            }
        }

        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
