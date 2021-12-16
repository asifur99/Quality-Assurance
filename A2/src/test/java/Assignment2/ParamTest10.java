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
public class ParamTest10 extends ThreePlayersNetworkTest{
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


    public ParamTest10(ArrayList<String> hand_p0, ArrayList<String> hand_p1, ArrayList<String> hand_p2, String[] p1_move_1, String[] p1_move_2, List<List<String>> toCheck_p1_move, String[] p2_move_1, String[] p3_move_1, int table_size, int tiles) {
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
    }

    @Parameterized.Parameters
    public static Collection generateData(){

        //for scenario 1
        //valid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R4", "R8", "R11", "B2", "B4", "B6", "B11", "G1", "G11", "O4", "O11"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("R1", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "B12", "G11", "G12"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("R1", "R2", "R4", "R5", "R6", "R7", "G1", "G4", "G6", "B1", "B4", "B6", "O1", "O3"));

        String[] i1_p1_move1 = new String[]{"2", "{R1 R3 R5 B2 B4 B6 G1 O4 R4 R8}", "{R11 O11 B11 G11}"};
        String[] i1_p1_move2 = new String[]{"2", "{R1 R3 R5 B2 B4 B6 G1}", "{R4 G4 B4 O4} {R4 R5 R6 R7 R8} {R12 B12 G12} {R11 O11 B11 G11}"};

        String[] i1_p2_move1 = new String[]{"2", "{R1 B1 B2 B4 B5 B6 B7 B8 B9 B10 G11}", "{R12 B12 G12} {R11 O11 B11 G11}"};

        String[] i1_p3_move1 = new String[]{"2", "{R1, R2 G1 G6 B1 B6 O1 O3}", "{R4 G4 B4} {R5 R6 R7} {R12 B12 G12} {R11 O11 B11 G11}"};

        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R4", "B4", "G4", "O4"));
        i1_toCheck_p1_move.add(Arrays.asList("R4", "R5", "R6", "R7", "R8"));
        i1_toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12"));
        i1_toCheck_p1_move.add(Arrays.asList("R11", "B11", "G11", "O11"));

        int i1_table_size = 4;
        int i1_tiles = 16;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "B12", "G1", "R11", "B2", "B4", "B6", "B11", "G11", "G2", "B13", "O11"));
        ArrayList<String> i2_card_p1 = new ArrayList<>(Arrays.asList("R1", "R12", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "G13", "G11", "G12"));
        ArrayList<String> i2_card_p2 = new ArrayList<>(Arrays.asList("R1", "R2", "R4", "R5", "R6", "R7", "G1", "G4", "G6", "B1", "B4", "B6", "O1", "O3"));

        String[] i2_p1_move1 = new String[]{"2", "{R1 R3 R5 B12 G1 B2 B4 B6 G2 B13}", "{R11 O11 B11 G11}"};
        String[] i2_p1_move2 = new String[]{"2", "{R1 R3 R5 B2 B4 B6 G2}", "{G11 G12 G13 G1} {B11 B12 B13} {R11 O11 G11} {R4 G4 B4} {R5 R6 R7}"};

        String[] i2_p2_move1 = new String[]{"2", "{R1 R12 B1 B2 B4 B5 B6 B7 B8 B9 B10}", "{G11 G12 G13} {R11 O11 B11 G11}"};

        String[] i2_p3_move1 = new String[]{"2", "{R1 R2 G1 G6 B1 B6 O1 O3}", "{R4 G4 B4} {R5 R6 R7} {G11 G12 G13} {R11 O11 B11 G11}"};

        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("G11", "G12", "G13", "G1"));
        i2_toCheck_p1_move.add(Arrays.asList("B11", "B12", "B13"));
        i2_toCheck_p1_move.add(Arrays.asList("R11", "G11", "O11"));
        i2_toCheck_p1_move.add(Arrays.asList("R4", "B4", "G4"));
//        i2_toCheck_p1_move.add(Arrays.asList("R5", "B6", "R7"));

        int i2_table_size = 5;
        int i2_tiles = 13;

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("O11", "B11", "G11", "G10", "B10", "R13", "R2", "R4", "R5", "R9", "R11", "R13", "O3", "O9"));
        ArrayList<String> i3_card_p1 = new ArrayList<>(Arrays.asList("O12", "B12", "G12", "R1", "B1", "B2", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "G11"));
        ArrayList<String> i3_card_p2 = new ArrayList<>(Arrays.asList("R7", "R8", "R9", "R10", "R11", "R12", "R1", "R2", "G1", "G6", "B1", "B6", "O1", "O3"));

        String[] i3_p1_move1 = new String[]{"2", "{R2 R4 R5 R9 R11 R13 O3 O9 G10 B10 R13}", "{O11 B11 G11}"};
        String[] i3_p1_move2 = new String[]{"2", "{R2 R4 R5 R9 R11 R13 O3 O9}", "{R7 R8 R9} {R10 G10 B10} {R11 R12 R13} {O12 B12 G12} {O11 B11 G11}"};

        String[] i3_p2_move1 = new String[]{"2", "{R1 B1 B2 B4 B5 B6 B7 B8 B9 B10 G11}", "{O12 B12 G12} {O11 B11 G11}"};

        String[] i3_p3_move1 = new String[]{"2", "{R1 R2 G1 G6 B1 B6 O1 O3}", "{R7 R8 R9 R10 R11 R12} {O12 B12 G12} {O11 B11 G11}"};

        List<List<String>> i3_toCheck_p1_move = new ArrayList<>();
        i3_toCheck_p1_move.add(Arrays.asList("R7", "R8", "R9"));
        i3_toCheck_p1_move.add(Arrays.asList("R10", "B10", "G10"));
        i3_toCheck_p1_move.add(Arrays.asList("R11", "R12", "R13"));
        i3_toCheck_p1_move.add(Arrays.asList("B12", "G12", "O12"));
        i3_toCheck_p1_move.add(Arrays.asList("B11", "G11", "O11"));

        int i3_table_size = 5;
        int i3_tiles = 15;

        //for scenario 4
        //valid
        ArrayList<String> i4_card_p0 = new ArrayList<>(Arrays.asList("G4", "B4", "O5", "O13", "R11", "B11", "G11", "R3", "R4", "R5", "B1", "B2", "B3", "B4"));
        ArrayList<String> i4_card_p1 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "O1", "O2", "O3", "O4", "R3", "B3", "G3", "O3", "G3", "G4", "G5"));
        ArrayList<String> i4_card_p2 = new ArrayList<>(Arrays.asList("R7", "R8", "R9", "R10", "R11", "R12", "R1", "R2", "G1", "G6", "B1", "B6", "O1", "O3"));

        String[] i4_p1_move1 = new String[]{"2", "{G4 B4 O5 O13}", "{R11 B11 G11} {R3 R4 R5} {B1 B2 B3 B4}"};
        String[] i4_p1_move2 = new String[]{"2", "{}", "{R4 G4 B4} {O4 G4 B4} {O13 O1 O2 O3} {O5 R5 G5} {R3 B3 G3} {R3 O3 G3} {R11 B11 G11} {B1 B2 B3}"};

        String[] i4_p2_move1 = new String[]{"2", "{R1 R2 R3}", "{O1 O2 O3 O4} {R3 B3 G3 O3} {G3 G4 G5} {R11 B11 G11} {R3 R4 R5} {B1 B2 B3 B4}"};

        String[] i4_p3_move1 = new String[]{"1"};

        List<List<String>> i4_toCheck_p1_move = new ArrayList<>();
        i4_toCheck_p1_move.add(Arrays.asList("R4", "B4", "G4"));
        i4_toCheck_p1_move.add(Arrays.asList("B4", "G4", "O4"));
        i4_toCheck_p1_move.add(Arrays.asList("O13", "O1", "O2", "O3"));
        i4_toCheck_p1_move.add(Arrays.asList("R5", "G5", "O5"));
        i4_toCheck_p1_move.add(Arrays.asList("R3", "B3", "G3"));
        i4_toCheck_p1_move.add(Arrays.asList("R3", "G3", "O3"));
        i4_toCheck_p1_move.add(Arrays.asList("R11", "B11", "G11"));
        i4_toCheck_p1_move.add(Arrays.asList("B1", "B2", "B3"));

        int i4_table_size = 8;
        int i4_tiles = 25;

        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_card_p1, i1_card_p2, i1_p1_move1, i1_p1_move2, i1_toCheck_p1_move, i1_p2_move1, i1_p3_move1, i1_table_size, i1_tiles},
                {i2_card_p0, i2_card_p1, i2_card_p2, i2_p1_move1, i2_p1_move2, i2_toCheck_p1_move, i2_p2_move1, i2_p3_move1, i2_table_size, i2_tiles},
                {i3_card_p0, i3_card_p1, i3_card_p2, i3_p1_move1, i3_p1_move2, i3_toCheck_p1_move, i3_p2_move1, i3_p3_move1, i3_table_size, i3_tiles},
                {i4_card_p0, i4_card_p1, i4_card_p2, i4_p1_move1, i4_p1_move2, i4_toCheck_p1_move, i4_p2_move1, i4_p3_move1, i4_table_size, i4_tiles},
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
        localPlayer = commander.getPlayer(1);

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
    }
}
