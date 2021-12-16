import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4 {
    private Game game;

    @BeforeEach
    public void setup(){
        game = new Game(1);
    }

    @Test
    @DisplayName("P1 starts with {2C 2H 2D}  {3C 3H 3D} {8D 9D 10D} {8H 9H 10H} QC 7H in hand and chooses to draw\n")
    public void test1(){
        game = new Game(1);

        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('R', 2));
        set1.add(2, new Tile('O', 2));
        //meld 2
        set1.add(3, new Tile('G', 3));
        set1.add(4, new Tile('R', 3));
        set1.add(5, new Tile('O', 3));
        //meld 3
        set1.add(6, new Tile('O', 8));
        set1.add(7, new Tile('O', 9));
        set1.add(8, new Tile('O', 10));
        //meld 4
        set1.add(9, new Tile('R', 8));
        set1.add(10, new Tile('R', 9));
        set1.add(11, new Tile('R', 10));

        set1.add(12, new Tile('G', 12));
        set1.add(13, new Tile('R', 7));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("1\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(15, game.getPlayers()[0].hand.size());
    }

    @Test
    @DisplayName("P1 starts with 2C 2C 2D 3H 3S 3S 5H 6S 7D 9H 10H JC QS KS and has to draw\n")
    public void test2(){
        game = new Game(1);

        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();

        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('G', 2));
        set1.add(2, new Tile('O', 2));
        set1.add(3, new Tile('R', 3));
        set1.add(4, new Tile('B', 3));
        set1.add(5, new Tile('B', 3));
        set1.add(6, new Tile('H', 5));
        set1.add(7, new Tile('G', 6));
        set1.add(8, new Tile('O', 7));
        set1.add(9, new Tile('R', 9));
        set1.add(10, new Tile('R', 10));
        set1.add(11, new Tile('B', 11));
        set1.add(12, new Tile('B', 12));
        set1.add(13, new Tile('B', 13));

        game.getPlayers()[0].setHand(set1);
        game.userInput = new Scanner("1\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(15, game.getPlayers()[0].hand.size());
    }
}
