import io.cucumber.java.hu.Ha;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Game game = new Game(1);
    Player player1;
    Player player2;
    Player player3;

    @Test
    @DisplayName("Checking hand")
    public void checkHand(){
        player1 = new Player("Player1", game);
        player1.showHand();

        assertEquals(14, player1.hand.size());

        System.out.println();
        player2 = new Player("Player2", game);
        player2.showHand();

        assertEquals(14, player2.hand.size());

        System.out.println();
        player3  = new Player("Player3", game);
        player3.showHand();

        assertEquals(14, player2.hand.size());
    }

    @Test
    @DisplayName("Test to make sure hand can be manually set")
    public void manipulatingHand(){
        player1 = new Player("Player1", game);

        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile('R', 1));
        tiles.add(new Tile('R', 3));
        tiles.add(new Tile('R', 5));
        tiles.add(new Tile('R', 2));
        tiles.add(new Tile('R', 1));
        tiles.add(new Tile('B', 1));
        tiles.add(new Tile('G', 1));
        tiles.add(new Tile('O', 1));
        tiles.add(new Tile('R', 4));
        tiles.add(new Tile('B', 1));
        tiles.add(new Tile('B', 2));
        tiles.add(new Tile('B', 3));
        tiles.add(new Tile('O', 1));
        tiles.add(new Tile('O', 2));

        System.out.println();
        player1.setHand(tiles);
        HashMap<Integer, Tile> handAfter = player1.showHand();

        boolean check = false;
        for (int i = 0; i < handAfter.size(); i++){
            if(handAfter.get(i) == tiles.get(i)){
                check = true;
            }
            else{
                check = false;
            }
        }

        assertTrue(check);
    }
}