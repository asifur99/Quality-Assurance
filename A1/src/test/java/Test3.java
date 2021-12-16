import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test3 {
    private Game game;

    public Test3(){
        setUp();
    }

    @BeforeEach
    void setUp(){
        System.out.println("SETUP....");
        game = new Game(1);
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 11));
        set1.add(1, new Tile('R', 12));
        set1.add(2, new Tile('R', 13));

        game.getPlayers()[0].setHand(set1);

        set1 = new ArrayList<>();
        set1.add(0, new Tile('B', 11));
        set1.add(1, new Tile('B', 12));
        set1.add(2, new Tile('B', 13));

        game.getPlayers()[1].setHand(set1);

        set1 = new ArrayList<>();
        set1.add(0, new Tile('O', 11));
        set1.add(1, new Tile('O', 12));
        set1.add(2, new Tile('O', 13));

        game.getPlayers()[2].setHand(set1);

        game.userInput = new Scanner("2\n1\n3\n0\n1\n2\n3\n2\n1\n3\n0\n1\n2\n3\n2\n1\n3\n0\n1\n2\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 3C 4C} from hand")
    public void test1(){
        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('G', 3));
        set1.add(2, new Tile('G', 4));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n3\n3\n4\n5\n3\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(4, game.getTable().size());

        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), set1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), set1.get(i).getRank());
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 3C 4C} {8D 9D 10D} from hand")
    public void test2(){
        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('G', 3));
        set1.add(2, new Tile('G', 4));
        //meld 2
        set1.add(3, new Tile('O', 8));
        set1.add(4, new Tile('O', 9));
        set1.add(5, new Tile('O', 10));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n2\n3\n3\n4\n5\n3\n6\n7\n8\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(5, game.getTable().size());

        ArrayList<Tile> c1 = new ArrayList<>();
        //meld 1
        c1.add(0, new Tile('G', 2));
        c1.add(1, new Tile('G', 3));
        c1.add(2, new Tile('G', 4));

        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), c1.get(i).getRank());
        }

        c1 = new ArrayList<>();
        //meld 2
        c1.add(0, new Tile('O', 8));
        c1.add(1, new Tile('O', 9));
        c1.add(2, new Tile('O', 10));

        for (int i = 0; i<game.getTable().get(4).size(); i++){
            assertEquals(game.getTable().get(4).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(4).get(i).getRank(), c1.get(i).getRank());
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 2H 2D} from hand")
    public void test3(){
        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('R', 2));
        set1.add(2, new Tile('O', 2));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n3\n3\n4\n5\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(4, game.getTable().size());

        ArrayList<Tile> c1 = new ArrayList<>();
        //meld 1
        c1.add(0, new Tile('G', 2));
        c1.add(1, new Tile('R', 2));
        c1.add(2, new Tile('O', 2));

        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), c1.get(i).getRank());
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 2H 2D} {8D 8H 8S 8C} from hand")
    public void test4(){
        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('R', 2));
        set1.add(2, new Tile('O', 2));

        //meld 2
        set1.add(3, new Tile('O', 8));
        set1.add(4, new Tile('R', 8));
        set1.add(5, new Tile('B', 8));
        set1.add(6, new Tile('G', 8));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n2\n3\n3\n4\n5\n3\n6\n7\n8\n9\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(5, game.getTable().size());

        ArrayList<Tile> c1 = new ArrayList<>();
        //meld 1
        c1.add(0, new Tile('G', 2));
        c1.add(1, new Tile('R', 2));
        c1.add(2, new Tile('O', 2));
        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), c1.get(i).getRank());
        }

        //meld 2
        c1 = new ArrayList<>();
        c1.add(0, new Tile('O', 8));
        c1.add(1, new Tile('R', 8));
        c1.add(2, new Tile('B', 8));
        c1.add(3, new Tile('G', 8));
        for (int i = 0; i<game.getTable().get(4).size(); i++){
            assertEquals(game.getTable().get(4).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(4).get(i).getRank(), c1.get(i).getRank());
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 2H 2D} {8D 9D 10D} from hand")
    public void test5(){
        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('G', 2));
        set1.add(1, new Tile('R', 2));
        set1.add(2, new Tile('O', 2));

        //meld 2
        set1.add(3, new Tile('O', 8));
        set1.add(4, new Tile('O', 9));
        set1.add(5, new Tile('O', 10));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n2\n3\n3\n4\n5\n3\n6\n7\n8\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(5, game.getTable().size());

        ArrayList<Tile> c1 = new ArrayList<>();
        //meld 1
        c1.add(0, new Tile('G', 2));
        c1.add(1, new Tile('R', 2));
        c1.add(2, new Tile('O', 2));
        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), c1.get(i).getRank());
        }

        //meld 2
        c1 = new ArrayList<>();
        c1.add(0, new Tile('O', 8));
        c1.add(1, new Tile('O', 9));
        c1.add(2, new Tile('O', 10));
        for (int i = 0; i<game.getTable().get(4).size(); i++){
            assertEquals(game.getTable().get(4).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(4).get(i).getRank(), c1.get(i).getRank());
        }
    }

    @Test
    @DisplayName("start of turn 2: P1 then plays {2C 2H 2D}  {3C 3H 3D} {8C 9C 10C JC QC} from hand")
    public void test6(){
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
        set1.add(6, new Tile('G', 8));
        set1.add(7, new Tile('G', 9));
        set1.add(8, new Tile('G', 10));
        set1.add(9, new Tile('G', 11));
        set1.add(10, new Tile('G', 12));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n3\n3\n3\n4\n5\n3\n6\n7\n8\n5\n9\n10\n11\n12\n13\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){
        }

        assertEquals(6, game.getTable().size());

        ArrayList<Tile> c1 = new ArrayList<>();
        //meld 1
        c1.add(0, new Tile('G', 2));
        c1.add(1, new Tile('R', 2));
        c1.add(2, new Tile('O', 2));
        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), c1.get(i).getRank());
        }

        //meld 2
        c1 = new ArrayList<>();
        c1.add(0, new Tile('G', 3));
        c1.add(1, new Tile('R', 3));
        c1.add(2, new Tile('O', 3));
        for (int i = 0; i<game.getTable().get(4).size(); i++){
            assertEquals(game.getTable().get(4).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(4).get(i).getRank(), c1.get(i).getRank());
        }

        //meld 3
        c1 = new ArrayList<>();
        c1.add(0, new Tile('G', 8));
        c1.add(1, new Tile('G', 9));
        c1.add(2, new Tile('G', 10));
        c1.add(3, new Tile('G', 11));
        c1.add(4, new Tile('G', 12));
        for (int i = 0; i<game.getTable().get(5).size(); i++){
            assertEquals(game.getTable().get(5).get(i).getColor(), c1.get(i).getColor());
            assertEquals(game.getTable().get(5).get(i).getRank(), c1.get(i).getRank());
        }
    }
}
