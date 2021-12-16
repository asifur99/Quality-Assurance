import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Test5 {
    private Game game;

//    public Test5(){
//        game = new Game(1);
//    }

    @Test
    @DisplayName("declaring a winner upon a player playing all tiles and reporting correct scores (1 test starting with a new game)")
    public void test1(){
        game = new Game(1);

        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> p1 = new ArrayList<>();
        p1.add(0, new Tile('G', 1));
        p1.add(1, new Tile('G', 2));
        p1.add(2, new Tile('O', 2));
        p1.add(3, new Tile('R', 3));
        p1.add(4, new Tile('B', 3));
        p1.add(5, new Tile('B', 3));
        p1.add(6, new Tile('R', 5));
        p1.add(7, new Tile('B', 6));
        p1.add(8, new Tile('O', 7));
        p1.add(9, new Tile('R', 9));
        p1.add(10, new Tile('R', 10));
        p1.add(11, new Tile('B', 11));
        p1.add(12, new Tile('B', 12));
        p1.add(13, new Tile('B', 13));

        ArrayList<Tile> p2 = new ArrayList<>();
        p2.add(0, new Tile('R', 2));
        p2.add(1, new Tile('B', 2));
        p2.add(2, new Tile('G', 2));
        p2.add(3, new Tile('O', 2));

        p2.add(4, new Tile('G', 3));
        p2.add(5, new Tile('G', 4));
        p2.add(6, new Tile('G', 6));
        p2.add(7, new Tile('G', 7));

        p2.add(8, new Tile('O', 4));
        p2.add(9, new Tile('O', 5));
        p2.add(10, new Tile('O', 6));
        p2.add(11, new Tile('O', 7));
        p2.add(12, new Tile('O', 8));
        p2.add(13, new Tile('O', 9));

        ArrayList<Tile> p3 = new ArrayList<>();
        p3.add(0, new Tile('R', 4));
        p3.add(1, new Tile('O', 6));
        p3.add(2, new Tile('B', 6));
        p3.add(3, new Tile('B', 7));
        p3.add(4, new Tile('R', 7));
        p3.add(5, new Tile('G', 8));

        p3.add(6, new Tile('R', 10));
        p3.add(7, new Tile('R', 11));
        p3.add(8, new Tile('R', 12));
        p3.add(9, new Tile('R', 13));

        p3.add(10, new Tile('B', 10));
        p3.add(11, new Tile('B', 11));
        p3.add(12, new Tile('B', 12));
        p3.add(13, new Tile('B', 13));

        game.getPlayers()[0].setHand(p1);
        game.getPlayers()[1].setHand(p2);
        game.getPlayers()[2].setHand(p3);

        game.nextPlayer(game.getCurrentPlayer(), new Tile('R', 2));
        game.setCurrentPlayer(game.getCurrentPlayer()+1);

        game.nextPlayer(game.getCurrentPlayer(), new Tile('G', 5));
        game.setCurrentPlayer(game.getCurrentPlayer()+1);

        game.userInput = new Scanner("3\n3\n" +
                "2\n2\n4\n6\n7\n8\n9\n4\n10\n11\n12\n13\n" +
                "3\n" +
                "2\n2\n3\n1\n2\n14\n3\n" +
                "11\n12\n13\n" +
                "3\n" +
                "2\n3\n5\n4\n5\n14\n6\n7\n4\n0\n1\n2\n3\n6\n8\n9\n10\n11\n12\n13\n3\n");

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }
    }
}
