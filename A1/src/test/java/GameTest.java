import io.cucumber.java.bs.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game;

    public GameTest(){
        game = new Game(1);
    }

    @Test
    @DisplayName("Initializing the Deck in Game")
    public void checkDeckInGame(){
        assertEquals(104, game.getDeck().getLength());
        game.pullTile();
        game.pullTile();
        game.pullTile();
        assertEquals(101, game.getDeck().getLength());
        game.resetGame();
        assertEquals(104, game.getDeck().getLength());
    }

    @Test
    @DisplayName("Tests on the Table in Game")
    public void checkTable(){
        game.showTable();

        ArrayList<Tile> set1 = new ArrayList<>();
        ArrayList<Tile> set2 = new ArrayList<>();
        ArrayList<Tile> set3 = new ArrayList<>();

        Tile t1 = new Tile('R', 2);
        Tile t2 = new Tile('G', 2);
        Tile t3 = new Tile('B', 2);
        Tile t4 = new Tile('O', 2);

        Tile t5 = new Tile('R', 1);
        Tile t6 = new Tile('R', 2);
        Tile t7 = new Tile('R', 3);
        Tile t8 = new Tile('R', 4);

        set1.add(t1);
        set1.add(t2);
        set1.add(t3);
        set1.add(t4);

        set2.add(t5);
        set2.add(t6);

        set3.add(t6);
        set3.add(t7);
        set3.add(t8);

        assertTrue(game.addToTable(set1));
        assertFalse(game.addToTable(set2));
        assertTrue(game.addToTable(set3));

        game.showTable();
    }

    @Test
    @DisplayName("Check if the set is Running")
    public void checkIfRunning(){
        game.resetGame();

        ArrayList<Tile> array = new ArrayList<>();
        array.add(new Tile('R', 1));
        array.add(new Tile('R', 2));
        array.add(new Tile('R', 3));
        array.add(new Tile('R', 4));

        ArrayList<Tile> array2 = new ArrayList<>();
        array2.add(new Tile('R', 1));
        array2.add(new Tile('R', 2));
        array2.add(new Tile('R', 3));
        array2.add(new Tile('B', 4));

        assertTrue(game.isRunning(array));
        assertFalse(game.isRunning(array2));
    }

    @Test
    @DisplayName("Check if the set is Same Number and Different Color")
    public void checkIfSameNumber(){
        game.resetGame();

        ArrayList<Tile> array = new ArrayList<>();
        array.add(new Tile('R', 1));
        array.add(new Tile('B', 1));
        array.add(new Tile('G', 1));
        array.add(new Tile('O', 1));

        ArrayList<Tile> array2 = new ArrayList<>();
        array2.add(new Tile('R', 1));
        array2.add(new Tile('R', 2));
        array2.add(new Tile('R', 3));
        array2.add(new Tile('R', 4));

        assertTrue(game.isSameNumber(array));
        assertFalse(game.isSameNumber(array2));
    }
}