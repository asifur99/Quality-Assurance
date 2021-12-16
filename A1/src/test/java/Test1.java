import org.junit.runner.RunWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1{
    Game game = new Game(1);

    @Test
    @DisplayName("player sequence and UI updates verified via a Junit test method (start a new game - 1 test)")
    public void test(){
        game.userInput = new Scanner("Player1\nPlayer2\nPlayer3\n");
        game.initPlayers();
        game.testMode = true;

        ArrayList<Tile> set1 = new ArrayList<>();
        set1.add(0, new Tile('R', 12));
        set1.add(1, new Tile('B', 12));
        set1.add(2, new Tile('O', 12));

        ArrayList<Tile> set2 = new ArrayList<>();
        set2.add(0, new Tile('R', 11));
        set2.add(1, new Tile('R', 12));
        set2.add(2, new Tile('R', 13));

        ArrayList<Tile> set3 = new ArrayList<>();
        set3.add(0, new Tile('R', 13));
        set3.add(1, new Tile('B', 13));
        set3.add(2, new Tile('G', 13));

        set3.add(3, new Tile('G', 2));
        set3.add(4, new Tile('R', 2));
        set3.add(5, new Tile('O', 2));

        game.getPlayers()[0].setHand(set1);
        game.getPlayers()[1].setHand(set2);
        game.getPlayers()[2].setHand(set3);

        game.userInput = new Scanner("1\n" + // goes to next Player
                "2\n1\n3\n0\n1\n2\n3\n" + // goes to Player 3 after adding Player 2 melds
                "2\n2\n3\n0\n1\n2\n3\n3\n4\n5\n3\n" +// goes to Player 1 after adding Player 3 melds
                "2\n1\n3\n0\n0\n1\n2\n"
        );

        try{
            game.startGame();
        } catch (NoSuchElementException e){

        }

        assertEquals(4, game.getTable().size());
        assertEquals(13, game.getPlayers()[0].hand.size()); // 14 + 1 - 3
    }
}
