import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private final ArrayList<Tile> deck;

    public Deck(){
        deck = new ArrayList<Tile>();
        reset();
    }

    /* j ranges from 0-3
     * 0 is R
     * 1 is B
     * 2 is G
     * 3 is O
     * */
    public void initTiles(){
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 13; i++){
                if(j == 0){
                    Tile tile = new Tile('R', i);
                    deck.add(tile);
                    deck.add(tile);
                }
                else if(j == 1){
                    Tile tile = new Tile('B', i);
                    deck.add(tile);
                    deck.add(tile);
                }
                else if(j == 2){
                    Tile tile = new Tile('G', i);
                    deck.add(tile);
                    deck.add(tile);
                }
                else{
                    Tile tile = new Tile('O', i);
                    deck.add(tile);
                    deck.add(tile);
                }
            }
        }
    }

    public int getLength(){
        return deck.size();
    }

    public ArrayList<Tile> getDeck() {
        return deck;
    }

    public Tile pullTile(){
        if(deck.isEmpty()){
            return null;
        }

        return deck.remove(0);
    }

    public boolean exists(Tile tile){
        for (int i=0; i<getLength(); i++){
            if ((tile.getRank() == deck.get(i).getRank()) && (tile.getColor() == deck.get(i).getColor())) {
                return true;
            }
        }
        return false;
    }

    public void reset(){
        deck.clear();
        initTiles();
        Collections.shuffle(deck);
    }
}
