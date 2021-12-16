import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {
    Game game = new Game(1);

    @BeforeEach
    public void init(){
        game = new Game(1);
    }

    @Test
    @DisplayName("P1 plays {JH QH KH}")
    public void test1(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 11));
        set1.add(1, new Tile('R', 12));
        set1.add(2, new Tile('R', 13));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n3\n0\n1\n2");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        for (ArrayList<Tile> array : game.getTable()){
            assertEquals(array, set1);
        }

        assertEquals(1, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {QH QC QS}")
    public void test2(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 12));
        set1.add(1, new Tile('G', 12));
        set1.add(2, new Tile('B', 12));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n3\n0\n1\n2");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        for (ArrayList<Tile> array : game.getTable()){
            assertEquals(array, set1);
        }

        assertEquals(1, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {9H 10H JH QH KH}")
    public void test3(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 9));
        set1.add(1, new Tile('R', 10));
        set1.add(2, new Tile('R', 11));
        set1.add(3, new Tile('R', 12));
        set1.add(4, new Tile('R', 13));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n5\n0\n1\n2\n3\n4\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

       for (ArrayList<Tile> array : game.getTable()){
            assertEquals(array, set1);
       }

       assertEquals(1, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {KH KC KS KD}")
    public void test4(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 13));
        set1.add(1, new Tile('B', 13));
        set1.add(2, new Tile('G', 13));
        set1.add(3, new Tile('O', 13));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n1\n4\n0\n1\n2\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        for (ArrayList<Tile> array : game.getTable()){
            assertEquals(array, set1);
        }

        assertEquals(1, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {2H 3H 4H} {7S 8S 9S}")
    public void test5(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('R', 2));
        set1.add(1, new Tile('R', 3));
        set1.add(2, new Tile('R', 4));

        //meld 2
        set1.add(3, new Tile('B', 7));
        set1.add(4, new Tile('B', 8));
        set1.add(5, new Tile('B', 9));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n2\n3\n0\n1\n2\n3\n3\n4\n5\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(0, new Tile('R', 2));
        temp.add(1, new Tile('R', 3));
        temp.add(2, new Tile('R', 4));
        for (int i = 0; i<game.getTable().get(0).size(); i++){
            assertEquals(game.getTable().get(0).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(0).get(i).getRank(), temp.get(i).getRank());
        }


        temp = new ArrayList<>();
        temp.add(0, new Tile('B', 7));
        temp.add(1, new Tile('B', 8));
        temp.add(2, new Tile('B', 9));
        for (int i = 0; i<game.getTable().get(1).size(); i++){
            assertEquals(game.getTable().get(1).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(1).get(i).getRank(), temp.get(i).getRank());
        }

        assertEquals(2, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {2H 2S 2D} {4C 4D 4S 4H} {5D 5S 5H}")
    public void test6(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('R', 2));
        set1.add(1, new Tile('B', 2));
        set1.add(2, new Tile('O', 2));

        //meld 2
        set1.add(3, new Tile('G', 4));
        set1.add(4, new Tile('O', 4));
        set1.add(5, new Tile('B', 4));
        set1.add(6, new Tile('H', 4));

        //meld 3
        set1.add(7, new Tile('O', 5));
        set1.add(8, new Tile('B', 5));
        set1.add(9, new Tile('R', 5));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n3\n3\n0\n1\n2\n4\n3\n4\n5\n6\n3\n7\n8\n9\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(0, new Tile('R', 2));
        temp.add(1, new Tile('B', 2));
        temp.add(2, new Tile('O', 2));
        for (int i = 0; i<game.getTable().get(0).size(); i++){
            assertEquals(game.getTable().get(0).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(0).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('G', 4));
        temp.add(1, new Tile('O', 4));
        temp.add(2, new Tile('B', 4));
        temp.add(3, new Tile('H', 4));
        for (int i = 0; i<game.getTable().get(1).size(); i++){
            assertEquals(game.getTable().get(1).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(1).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('O', 5));
        temp.add(1, new Tile('B', 5));
        temp.add(2, new Tile('R', 5));
        for (int i = 0; i<game.getTable().get(2).size(); i++){
            assertEquals(game.getTable().get(2).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(2).get(i).getRank(), temp.get(i).getRank());
        }

        assertEquals(3, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {8H 8C 8D} {2H 3H 4H}")
    public void test7(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('R', 8));
        set1.add(1, new Tile('G', 8));
        set1.add(2, new Tile('O', 8));

        //meld 2
        set1.add(3, new Tile('R', 2));
        set1.add(4, new Tile('R', 3));
        set1.add(5, new Tile('R', 4));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n2\n3\n0\n1\n2\n3\n3\n4\n5\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(0, new Tile('R', 8));
        temp.add(1, new Tile('G', 8));
        temp.add(2, new Tile('O', 8));
        for (int i = 0; i<game.getTable().get(0).size(); i++){
            assertEquals(game.getTable().get(0).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(0).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('R', 2));
        temp.add(1, new Tile('R', 3));
        temp.add(2, new Tile('R', 4));
        for (int i = 0; i<game.getTable().get(1).size(); i++){
            assertEquals(game.getTable().get(1).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(1).get(i).getRank(), temp.get(i).getRank());
        }

        assertEquals(2, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {2H 2D 2S} {2C 3C 4C} {3H 3S 3D} {5S 6S 7S}")
    public void test8(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('R', 2));
        set1.add(1, new Tile('B', 2));
        set1.add(2, new Tile('O', 2));

        //meld 2
        set1.add(3, new Tile('G', 2));
        set1.add(4, new Tile('G', 3));
        set1.add(5, new Tile('G', 4));

        //meld 3
        set1.add(6, new Tile('G', 3));
        set1.add(7, new Tile('B', 3));
        set1.add(8, new Tile('O', 3));

        //meld 4
        set1.add(9, new Tile('B', 5));
        set1.add(10, new Tile('B', 6));
        set1.add(11, new Tile('B', 7));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n4\n3\n0\n1\n2\n3\n3\n4\n5\n3\n6\n7\n8\n3\n9\n10\n11\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(0, new Tile('R', 2));
        temp.add(1, new Tile('B', 2));
        temp.add(2, new Tile('O', 2));
        for (int i = 0; i<game.getTable().get(0).size(); i++){
            assertEquals(game.getTable().get(0).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(0).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('G', 2));
        temp.add(1, new Tile('G', 3));
        temp.add(2, new Tile('G', 4));
        for (int i = 0; i<game.getTable().get(1).size(); i++){
            assertEquals(game.getTable().get(1).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(1).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('G', 3));
        temp.add(1, new Tile('B', 3));
        temp.add(2, new Tile('O', 3));
        for (int i = 0; i<game.getTable().get(2).size(); i++){
            assertEquals(game.getTable().get(2).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(2).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('B', 5));
        temp.add(1, new Tile('B', 6));
        temp.add(2, new Tile('B', 7));
        for (int i = 0; i<game.getTable().get(3).size(); i++){
            assertEquals(game.getTable().get(3).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(3).get(i).getRank(), temp.get(i).getRank());
        }

        assertEquals(4, game.getTable().size());
    }

    @Test
    @DisplayName("P1 plays {2H 2S 2C 2D} {3C 4C 5C 6C 7C} {4D 5D 6D 7D 8D} and wins!")
    public void test9(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        //meld 1
        set1.add(0, new Tile('R', 2));
        set1.add(1, new Tile('B', 2));
        set1.add(2, new Tile('O', 2));
        set1.add(3, new Tile('G', 2));

        //meld 2
        set1.add(4, new Tile('G', 3));
        set1.add(5, new Tile('G', 4));
        set1.add(6, new Tile('G', 5));
        set1.add(7, new Tile('G', 6));
        set1.add(8, new Tile('G', 7));

        //meld 3
        set1.add(9, new Tile('O', 4));
        set1.add(10, new Tile('O', 5));
        set1.add(11, new Tile('O', 6));
        set1.add(12, new Tile('O', 7));
        set1.add(13, new Tile('O', 8));

        game.getPlayers()[0].setHand(set1);

        game.userInput = new Scanner("2\n3\n4\n0\n1\n2\n3\n5\n4\n5\n6\n7\n8\n5\n9\n10\n11\n12\n13\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        ArrayList<Tile> temp = new ArrayList<>();
        temp.add(0, new Tile('R', 2));
        temp.add(1, new Tile('B', 2));
        temp.add(2, new Tile('O', 2));
        temp.add(3, new Tile('G', 2));
        for (int i = 0; i<game.getTable().get(0).size(); i++){
            assertEquals(game.getTable().get(0).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(0).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('G', 3));
        temp.add(1, new Tile('G', 4));
        temp.add(2, new Tile('G', 5));
        temp.add(3, new Tile('G', 6));
        temp.add(4, new Tile('G', 7));
        for (int i = 0; i<game.getTable().get(1).size(); i++){
            assertEquals(game.getTable().get(1).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(1).get(i).getRank(), temp.get(i).getRank());
        }

        temp = new ArrayList<>();
        temp.add(0, new Tile('O', 4));
        temp.add(1, new Tile('O', 5));
        temp.add(2, new Tile('O', 6));
        temp.add(3, new Tile('O', 7));
        temp.add(4, new Tile('O', 8));
        for (int i = 0; i<game.getTable().get(2).size(); i++){
            assertEquals(game.getTable().get(2).get(i).getColor(), temp.get(i).getColor());
            assertEquals(game.getTable().get(2).get(i).getRank(), temp.get(i).getRank());
        }

        assertEquals(3, game.getTable().size()); //reset
    }
}
