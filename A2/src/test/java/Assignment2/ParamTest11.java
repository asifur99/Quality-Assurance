package Assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParamTest11 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0; // Hand of Player 1
    private final ArrayList<String> hand_p1; // Hand of Player 2
    private final ArrayList<String> hand_p2; // Hand of Player 3

    private final String[] p1_move_1;
    private final String[] p1_move_2;
    private final List<List<String>> toCheck_p1_move;

    private final String[] p2_move_1;

    private final String[] p3_move_1;

    private final int table_size;
    private final int tiles;

    private final boolean end;


    public ParamTest11(ArrayList<String> hand_p0, ArrayList<String> hand_p1, ArrayList<String> hand_p2, String[] p1_move_1, String[] p1_move_2, List<List<String>> toCheck_p1_move, String[] p2_move_1, String[] p3_move_1, int table_size, int tiles, boolean end) {
        this.hand_p0 = hand_p0;
        this.hand_p1 = hand_p1;
        this.hand_p2 = hand_p2;
        this.p1_move_1 = p1_move_1;
        this.p1_move_2 = p1_move_2;
        this.toCheck_p1_move = toCheck_p1_move;
        this.p2_move_1 = p2_move_1;
        this.p3_move_1 = p3_move_1;
        this.table_size = table_size;
        this.tiles = tiles;
        this.end = end;
    }

    @Parameterized.Parameters
    public static Collection generateData(){

        //for scenario 1
        //valid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "B1", "G1", "O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9", "O10", "O11"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("O2", "O3", "O4", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R4", "B6", "G9", "O13"));

        String[] i1_p1_move1 = new String[]{"2", "{R1 G1 B1}", "{O1 O2 O3 O4 O5 O6 O7 O8 O9 O10 O11}"};
        String[] i1_p1_move2 = new String[]{"2", "{}", "{R1 G1 B1} {G1 G2 G3 G4 G5 G6 G7 G8 G9 G10 G11} {O1 O2 O3 O4 O5 O6 O7 O8 O9 O10 O11} {R1 R2 R3 R4 R5 R6 R7 R8 R9 R10}"};

        String[] i1_p2_move1 = new String[]{"2", "{O2 O3 O4}", "{G1 G2 G3 G4 G5 G6 G7 G8 G9 G10 G11} {O1 O2 O3 O4 O5 O6 O7 O8 O9 O10 O11}"};

        String[] i1_p3_move1 = new String[]{"2", "{R4 B6 G9 O13}", "{G1 G2 G3 G4 G5 G6 G7 G8 G9 G10 G11} {O1 O2 O3 O4 O5 O6 O7 O8 O9 O10 O11} {R1 R2 R3 R4 R5 R6 R7 R8 R9 R10}"};


        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1"));
        i1_toCheck_p1_move.add(Arrays.asList("G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11"));
        i1_toCheck_p1_move.add(Arrays.asList("O1", "O2", "O3", "O4", "O5", "O6", "O7", "O8", "O9", "O10", "O11"));
        i1_toCheck_p1_move.add(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10"));

        int i1_table_size = 4;
        int i1_tiles = 35;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R2","B2", "G2", "O2", "G3", "G4", "G5", "G6", "G7", "O4", "O5", "O6", "O7", "O8"));
        ArrayList<String> i2_card_p1 = new ArrayList<>(Arrays.asList("R1", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "G13", "G11", "G12"));
        ArrayList<String> i2_card_p2 = new ArrayList<>(Arrays.asList("R1", "R2", "R4", "R5", "R6", "R7", "G1", "G4", "G6", "B1", "B4", "B6", "O1", "O3"));

        String[] i2_p1_move1 = new String[]{"2", "{}", "{R2 B2 G2 O2} {G3 G4 G5 G6 G7} {O4 O5 O6 O7 O8}"};

        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("R2", "B2", "G2", "O2"));
        i2_toCheck_p1_move.add(Arrays.asList("G3", "G4", "G5", "G6", "G7"));
        i2_toCheck_p1_move.add(Arrays.asList("O4", "O5", "O6", "O7", "O8"));

        int i2_table_size = 3;
        int i2_tiles = 14;

        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_card_p1, i1_card_p2, i1_p1_move1, i1_p1_move2, i1_toCheck_p1_move, i1_p2_move1, i1_p3_move1, i1_table_size, i1_tiles, false},
//                {i2_card_p0, i2_card_p1, i2_card_p2, i2_p1_move1, null, i2_toCheck_p1_move, null, null, i2_table_size, i2_tiles, true}, //w
        });
    }

    @Before
    public void init() {
        commander.sendTestCommand("reset");

        commander.sendTestCommand("setPlayerTiles 0 " + hand_p0);
        commander.sendTestCommand("setPlayerTiles 1 " + hand_p1);
        commander.sendTestCommand("setPlayerTiles 2 " + hand_p2);

        //Write [play melds, updatedHand, updatedTable]
        p1.writeToConsole(p1_move_1);
        commander.sendTestCommand("round");

        p2.writeToConsole(p2_move_1);
        commander.sendTestCommand("round");

        p3.writeToConsole(p3_move_1);
        commander.sendTestCommand("round");
    }

    @Test
    @Description("A player's attempts to play one or more melds from hand after initial 30 points of previous turn obtained with R11 O11 G11")
    public void testSequence() throws IOException {
        p1.writeToConsole(p1_move_2);
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(0);

        System.out.println("############################################################  " + toCheck_p1_move);
        System.out.println("############################################################  " + localGameTable);

        int count = 0;

        for (List<String> meld : toCheck_p1_move){
            assertTrue(localGameTable.contains(meld));
//            System.out.println("############################################################  " + meld);

            for (String tile : meld){
                count++;
            }
        }

        assertEquals(localGameTable.size(), table_size);
        assertEquals(tiles, count);
        assertEquals(localPlayer.getName(), commander.getWinner().getName());

        commander.sendTestCommand("hardReset");
    }
}
