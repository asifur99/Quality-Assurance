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
public class ParamTest9 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0; // Hand of Player 1
    private final ArrayList<String> hand_p1; // Hand of Player 2
    private final ArrayList<String> hand_p2; // Hand of Player 3

    private final String[] p1_move_1;
    private final String[] p1_move_2;
    private final List<List<String>> toCheck_p1_move;

    private final String[] p2_move_1;
    private final String[] p2_move_2;

    private final String[] p3_move_1;
    private final String[] p3_move_2;

    private final int table_size;
    private final boolean p1_play;
    private final boolean p2_play;
    private final boolean p3_play;

    public ParamTest9(ArrayList<String> hand_p0, ArrayList<String> hand_p1, ArrayList<String> hand_p2, String[] p1_move_1, String[] p1_move_2, List<List<String>> toCheck_p1_move, String[] p2_move_1, String[] p2_move_2, String[] p3_move_1, String[] p3_move_2, int st, boolean p1_play, boolean p2_play, boolean p3_play) {
        this.hand_p0 = hand_p0;
        this.hand_p1 = hand_p1;
        this.hand_p2 = hand_p2;
        this.p1_move_1 = p1_move_1;
        this.p1_move_2 = p1_move_2;
        this.toCheck_p1_move = toCheck_p1_move;
        this.p2_move_1 = p2_move_1;
        this.p2_move_2 = p2_move_2;
        this.p3_move_1 = p3_move_1;
        this.p3_move_2 = p3_move_2;
        this.table_size = st;
        this.p1_play = p1_play;
        this.p2_play = p2_play;
        this.p3_play = p3_play;
    }

    @Parameterized.Parameters
    public static Collection generateData(){

        //for scenario 1
        //valid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "O11", "B11", "G11"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("B11", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "G11", "G12"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i1_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R7 R8 R9 R10}", "{R11 O11 B11 G11}"};
        String[] i1_p1_move2 = new String[]{"1"};

        String[] i1_p2_move1 = new String[]{"2", "{B11 B1 B2 B4 B5 B6 B7 B8 B9 B10 G11}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i1_p2_move2 = new String[]{"2", "{B1 B2 B4 B5 B6 B7 B8 B9 B10}", "{B11 G11 R11} {O11 B11 G11} {O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12}"};

        String[] i1_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i1_p3_move2 = null;

        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R11", "B11", "G11"));
        i1_toCheck_p1_move.add(Arrays.asList("B11", "G11", "O11"));
        i1_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9", "O10", "O11", "O12", "O13"));
        i1_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));

        int i1_size = 4;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "O11", "B11", "G11"));
        ArrayList<String> i2_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i2_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i2_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R7 R8 R9 R10}", "{R11 O11 B11 G11}"};
        String[] i2_p1_move2 = new String[]{"1"};

        String[] i2_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i2_p2_move2 = new String[]{"2", "{B1 B2 B4 B5 B6 B7 B8 B9 B10}", "{R11 R12 R13} {O11 B11 G11} {O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12}"};

        String[] i2_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i2_p3_move2 = null;

        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("R11", "R12", "R13"));
        i2_toCheck_p1_move.add(Arrays.asList("B11", "G11", "O11"));
        i2_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9", "O10", "O11", "O12", "O13"));
        i2_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));

        int i2_size = 4;

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R7", "R9", "R10", "R11", "O11", "B7", "B11", "G11"));
        ArrayList<String> i3_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i3_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i3_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R7 R9 R10 B7}", "{R11 O11 B11 G11}"};
        String[] i3_p1_move2 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R9 R10}", "{R7 B7 O7} {O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};

        String[] i3_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i3_p2_move2 = null;

        String[] i3_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i3_p3_move2 = null;

        List<List<String>> i3_toCheck_p1_move = new ArrayList<>();
        i3_toCheck_p1_move.add(Arrays.asList("R7", "B7", "O7"));
        i3_toCheck_p1_move.add(Arrays.asList("O8", "O9", "O10", "O11", "O12", "O13"));
        i3_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i3_toCheck_p1_move.add(Arrays.asList("R11","B11", "G11", "O11"));

        int i3_size = 4;

        //for scenario 4
        //valid
        ArrayList<String> i4_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "R13", "R9", "R10", "R11", "O11", "B13", "B11", "G11"));
        ArrayList<String> i4_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i4_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i4_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 B13 R9 R10 R13}", "{R11 O11 B11 G11}"};
        String[] i4_p1_move2 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R9 R10}", "{R13 B13 O13} {O7 O8 O9 O10 O11 O12} {R12 B12 G12} {R11 O11 B11 G11}"};

        String[] i4_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i4_p2_move2 = null;

        String[] i4_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i4_p3_move2 = null;

        List<List<String>> i4_toCheck_p1_move = new ArrayList<>();
        i4_toCheck_p1_move.add(Arrays.asList("R13", "B13", "O13"));
        i4_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9", "O10", "O11", "O12"));
        i4_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i4_toCheck_p1_move.add(Arrays.asList("R11","B11", "G11", "O11"));

        int i4_size = 4;

        //for scenario 5
        //valid
        ArrayList<String> i5_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "O8", "R9", "R10", "R11", "O11", "O9", "B11", "G11"));
        ArrayList<String> i5_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i5_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i5_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 O8 R9 R10 O9}", "{R11 O11 B11 G11}"};
        String[] i5_p1_move2 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R9 R10}", " {O7 O8 O9} {O8 O9 O10} {O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};

        String[] i5_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i5_p2_move2 = null;

        String[] i5_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i5_p3_move2 = null;

        List<List<String>> i5_toCheck_p1_move = new ArrayList<>();
        i5_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9"));
        i5_toCheck_p1_move.add(Arrays.asList("O8", "O9", "O10"));
        i5_toCheck_p1_move.add(Arrays.asList("O11", "O12", "O13"));
        i5_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i5_toCheck_p1_move.add(Arrays.asList("R11","B11", "G11", "O11"));

        int i5_size = 5;

        //for scenario 6
        //valid
        ArrayList<String> i6_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "*", "R9", "R10", "R11", "O11", "G11", "B11", "G11"));
        ArrayList<String> i6_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i6_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i6_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 * R9 R10 G11}", "{R11 O11 B11 G11}"};
        String[] i6_p1_move2 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R9 R10}", "{* G11 R11} {O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {O11 B11 G11}"};

        String[] i6_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i6_p2_move2 = null;

        String[] i6_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i6_p3_move2 = null;

        List<List<String>> i6_toCheck_p1_move = new ArrayList<>();
        i6_toCheck_p1_move.add(Arrays.asList("R11", "G11", "R11"));
        i6_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9", "O10", "O11", "O12", "O13"));
        i6_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i6_toCheck_p1_move.add(Arrays.asList("B11", "G11", "O11"));

        int i6_size = 4;

        //for scenario 7
        //valid
        ArrayList<String> i7_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6", "*", "R9", "R10", "R11", "O11", "R13", "B11", "G11"));
        ArrayList<String> i7_card_p1 = new ArrayList<>(Arrays.asList("R12", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "R13", "G12"));
        ArrayList<String> i7_card_p2 = new ArrayList<>(Arrays.asList("G1", "G3", "G5", "G7", "G9", "G10", "G11", "O7", "O8", "O9", "O10", "O11", "O12", "O13"));

        String[] i7_p1_move1 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 * R9 R10 R13}", "{R11 O11 B11 G11}"};
        String[] i7_p1_move2 = new String[]{"2", "{R1 R2 R3 R4 R5 R6 R9 R10}", "{R11 * R13} {O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {O11 B11 G11}"};

        String[] i7_p2_move1 = new String[]{"2", "{R12 B1 B2 B4 B5 B6 B7 B8 B9 B10 R13}", "{R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i7_p2_move2 = null;

        String[] i7_p3_move1 = new String[]{"2", "{G1 G3 G5 G7 G9 G10 G11}", "{O7 O8 O9 O10 O11 O12 O13} {R12 B12 G12} {R11 O11 B11 G11}"};
        String[] i7_p3_move2 = null;

        List<List<String>> i7_toCheck_p1_move = new ArrayList<>();
//        i7_toCheck_p1_move.add(Arrays.asList("R11", "G11", "R11"));
        i7_toCheck_p1_move.add(Arrays.asList("O7", "O8", "O9", "O10", "O11", "O12", "O13"));
        i7_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i7_toCheck_p1_move.add(Arrays.asList("B11", "G11", "O11"));

        int i7_size = 4;

        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_card_p1, i1_card_p2, i1_p1_move1, i1_p1_move2, i7_toCheck_p1_move, i1_p2_move1, i1_p2_move2, i1_p3_move1, i1_p3_move2, i1_size, true, true, false},
                {i2_card_p0, i2_card_p1, i2_card_p2, i2_p1_move1, i2_p1_move2, i2_toCheck_p1_move, i2_p2_move1, i2_p2_move2, i2_p3_move1, i2_p3_move2, i2_size, true, true, false},
                {i3_card_p0, i3_card_p1, i3_card_p2, i3_p1_move1, i3_p1_move2, i3_toCheck_p1_move, i3_p2_move1, i3_p2_move2, i3_p3_move1, i3_p3_move2, i3_size, true, false, false},
                {i4_card_p0, i4_card_p1, i4_card_p2, i4_p1_move1, i4_p1_move2, i4_toCheck_p1_move, i4_p2_move1, i4_p2_move2, i4_p3_move1, i4_p3_move2, i4_size, true, false, false},
                {i5_card_p0, i5_card_p1, i5_card_p2, i5_p1_move1, i5_p1_move2, i5_toCheck_p1_move, i5_p2_move1, i5_p2_move2, i5_p3_move1, i5_p3_move2, i5_size, true, false, false},
                {i6_card_p0, i6_card_p1, i6_card_p2, i6_p1_move1, i6_p1_move2, i6_toCheck_p1_move, i6_p2_move1, i6_p2_move2, i6_p3_move1, i6_p3_move2, i6_size, true, false, false},
//                {i7_card_p0, i7_card_p1, i7_card_p2, i7_p1_move1, i7_p1_move2, i7_toCheck_p1_move, i7_p2_move1, i7_p2_move2, i7_p3_move1, i7_p3_move2, i7_size, true, false, false}, //edge case
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
        if(p1_play){
            p1.writeToConsole(p1_move_2);
            commander.sendTestCommand("round");
        }

        if(p2_play){
            p2.writeToConsole(p2_move_2);
            commander.sendTestCommand("round");
        }

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(1);

//        System.out.println("############################################################  " + toCheck_p1_move);
        System.out.println("############################################################  " + localGameTable);

        for (List<String> meld : toCheck_p1_move){
            if(localGameTable.contains(meld)){
                assertTrue(localGameTable.contains(meld));
            }
            else {
                assertFalse(localGameTable.contains(meld));
            }

            System.out.println("############################################################  " + meld);

            for (String tile : meld){
                if(localPlayer.getTiles().contains(tile)){
                    assertTrue(localPlayer.getTiles().contains(tile));
                }
                else {
                    assertFalse(localPlayer.getTiles().contains(tile));
                }
            }
        }

        assertEquals(localGameTable.size(), table_size);
    }
}
