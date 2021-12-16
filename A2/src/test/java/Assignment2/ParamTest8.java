package Assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParamTest8 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0; // Hand of Player 1
    private final ArrayList<String> hand_p1; // Hand of Player 2
    private final ArrayList<String> hand_p2; // Hand of Player 3

    private final String[] p1_move_1;
    private final String[] p1_move_2;
    private final List<List<String>> toCheck_p1_move;
    private final int p1_played;


    public ParamTest8(ArrayList<String> hand_p0, ArrayList<String> hand_p1, ArrayList<String> hand_p2, String[] p1_move_1, String[] p1_move_2, List<List<String>> toCheck_p1_move, int p1_played) {
        this.hand_p0 = hand_p0;
        this.hand_p1 = hand_p1;
        this.hand_p2 = hand_p2;
        this.p1_move_1 = p1_move_1;
        this.p1_move_2 = p1_move_2;
        this.toCheck_p1_move = toCheck_p1_move;
        this.p1_played = p1_played;
    }

    @Parameterized.Parameters
    public static Collection generateData(){

        //for scenario 1
        //invalid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R6", "R7", "R8", "R11", "B4", "B6", "B11", "G11", "O11", "O11"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("R9", "R12", "R13", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("R2", "R13", "B2", "B3", "B3", "B4", "B5", "B5", "B6", "B7", "B13", "G2", "G4", "G13"));

        String[] i1_p1_move1 = new String[]{"2", "{R4 R11 B4 B6 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i1_p1_move2 = new String[]{"2", "{R11 B4 B6 B11 G11 O11 O11}", "{R3 R4 R4} {R5 R6 R7 R8}", "end"};

        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5", "R6", "R7", "R8"));
        int i1_played = 6;

        //for scenario 2
        //invalid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R6", "R7", "R7", "R8", "R11", "B4", "B11", "G11", "O11", "O11"));

        String[] i2_p1_move1 = new String[]{"2", "{R4 R7 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i2_p1_move2 = new String[]{"2", "{R4 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5} {R7 R6 R7 R8}", "end"};

        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5", "R6", "R7", "R8"));
        int i2_played = 6;

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R5", "R6", "R7", "R8", "R11", "B4", "B11", "G11", "O11", "O11"));

        String[] i3_p1_move1 = new String[]{"2", "{R4 R5 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i3_p1_move2 = new String[]{"2", "{R4 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5} {R5 R6 R7 R8}"};

        List<List<String>> i3_toCheck_p1_move = new ArrayList<>();
        i3_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5"));
        i3_toCheck_p1_move.add(Arrays.asList("R5", "R6", "R7", "R8"));
        int i3_played = 7;

        //for scenario 3
        //valid
        ArrayList<String> i4_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R6", "R6", "R7", "R8", "R11", "B4", "B11", "G11", "O11", "O11"));

        String[] i4_p1_move1 = new String[]{"2", "{R4 R6 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i4_p1_move2 = new String[]{"2", "{R4 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6} {R6 R7 R8}"};

        List<List<String>> i4_toCheck_p1_move = new ArrayList<>();
        i4_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5", "R6"));
        i4_toCheck_p1_move.add(Arrays.asList("R6", "R7", "R8"));
        int i4_played = 7;

        //for scenario 5
        //invalid
        ArrayList<String> i5_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R6", "R7", "R7", "R8", "R11", "B4", "B11", "G11", "O11", "O11"));

        String[] i5_p1_move1 = new String[]{"2", "{R4 R7 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i5_p1_move2 = new String[]{"2", "{R4 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7} {R7 R8}", "end"};

        List<List<String>> i5_toCheck_p1_move = new ArrayList<>();
        i5_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5", "R6", "R7", "R8"));
        int i5_played = 6;

        //for scenario 6
        //valid
        ArrayList<String> i6_card_p0 = new ArrayList<>(Arrays.asList("R3", "R4", "R4", "R5", "R6", "*", "R7", "R8", "R11", "B4", "B11", "G11", "O11", "O11"));

        String[] i6_p1_move1 = new String[]{"2", "{R4 * R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 R6 R7 R8}"};
        String[] i6_p1_move2 = new String[]{"2", "{R4 R11 B4 B11 G11 O11 O11}", "{R3 R4 R5 *} {R6 R7 R8}"};

        List<List<String>> i6_toCheck_p1_move = new ArrayList<>();
        i6_toCheck_p1_move.add(Arrays.asList("R3", "R4", "R5"));
        i6_toCheck_p1_move.add(Arrays.asList("R6", "R7", "R8"));
        int i6_played = 7;

        //for scenario 7
        //invalid
        ArrayList<String> i7_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R4", "R4", "R5", "R7", "R8", "R11", "B1", "B11", "G1", "G11", "O1", "O11"));

        String[] i7_p1_move1 = new String[]{"2", "{R2 R4 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 G1 B1 O1}"};
        String[] i7_p1_move2 = new String[]{"2", "{R4 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 R2 G1} {B1 O1}", "end"};

        List<List<String>> i7_toCheck_p1_move = new ArrayList<>();
        i7_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1", "O1"));
        int i7_played = 4;

        //for scenario 8
        //invalid
        ArrayList<String> i8_card_p0 = new ArrayList<>(Arrays.asList("R1", "R1", "R2", "R4", "R5", "R7", "R8", "R11", "B1", "B11", "G1", "G11", "O1", "O11"));

        String[] i8_p1_move1 = new String[]{"2", "{R1 R2 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 G1 B1 O1}"};
        String[] i8_p1_move2 = new String[]{"2", "{R2 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 G1 R1} {B1 O1}", "end"};

        List<List<String>> i8_toCheck_p1_move = new ArrayList<>();
        i8_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1", "O1"));
        int i8_played = 4;

        //for scenario 9
        //invalid
        ArrayList<String> i9_card_p0 = new ArrayList<>(Arrays.asList("R1", "R1", "R2", "R4", "R5", "R7", "R8", "R11", "B1", "B11", "G1", "G11", "O1", "O11"));

        String[] i9_p1_move1 = new String[]{"2", "{R1 R2 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 G1 B1 O1}"};
        String[] i9_p1_move2 = new String[]{"2", "{R1 R2 R4 R5 R7 R8 R11 B11 G11 O11}", "{R1 G1 O1} {B1}", "end"};

        List<List<String>> i9_toCheck_p1_move = new ArrayList<>();
        i9_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1", "O1"));
        int i9_played = 4;

        //for scenario 10
        //valid
        ArrayList<String> i10_card_p0 = new ArrayList<>(Arrays.asList("R1", "R1", "R4", "R5", "R7", "R11", "B1", "B1", "B11", "G1", "G1", "G11", "O1", "O11"));

        String[] i10_p1_move1 = new String[]{"2", "{R1 R4 R5 R7 R11 B1 B11 G1 G11 O11}", "{R1 G1 B1 O1}"};
        String[] i10_p1_move2 = new String[]{"2", "{R1 R4 R5 R7 R11 B11 G11 O11}", "{R1 G1 B1} {G1 B1 O1}"};

        List<List<String>> i10_toCheck_p1_move = new ArrayList<>();
        i10_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1"));
        i10_toCheck_p1_move.add(Arrays.asList("B1", "G1", "O1"));
        int i10_played = 6;

        //for scenario 11
        //valid
        ArrayList<String> i11_card_p0 = new ArrayList<>(Arrays.asList("R1", "R1", "R4", "R5", "R7", "R11", "B1", "B1", "B11", "G1", "G1", "G11", "O1", "O11"));

        String[] i11_p1_move1 = new String[]{"2", "{R1 R4 R5 R7 R11 B1 B11 G1 G11 O11}", "{R1 G1 B1 O1}"};
        String[] i11_p1_move2 = new String[]{"2", "{R1 R4 R5 R7 R11 B11 G11 O11}", "{R1 G1 B1} {G1 B1 O1}"};

        List<List<String>> i11_toCheck_p1_move = new ArrayList<>();
        i11_toCheck_p1_move.add(Arrays.asList("R1", "B1", "G1"));
        i11_toCheck_p1_move.add(Arrays.asList("B1", "G1", "O1"));
        int i11_played = 6;

        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_card_p1, i1_card_p2, i1_p1_move1, i1_p1_move2, i1_toCheck_p1_move, i1_played},
                {i2_card_p0, i1_card_p1, i1_card_p2, i2_p1_move1, i2_p1_move2, i2_toCheck_p1_move, i2_played},
                {i3_card_p0, i1_card_p1, i1_card_p2, i3_p1_move1, i3_p1_move2, i3_toCheck_p1_move, i3_played},
                {i4_card_p0, i1_card_p1, i1_card_p2, i4_p1_move1, i4_p1_move2, i4_toCheck_p1_move, i4_played},
                {i5_card_p0, i1_card_p1, i1_card_p2, i5_p1_move1, i5_p1_move2, i5_toCheck_p1_move, i5_played},
                {i6_card_p0, i1_card_p1, i1_card_p2, i6_p1_move1, i6_p1_move2, i6_toCheck_p1_move, i6_played},
                {i7_card_p0, i1_card_p1, i1_card_p2, i7_p1_move1, i7_p1_move2, i7_toCheck_p1_move, i7_played},
                {i8_card_p0, i1_card_p1, i1_card_p2, i8_p1_move1, i8_p1_move2, i8_toCheck_p1_move, i8_played},
                {i9_card_p0, i1_card_p1, i1_card_p2, i9_p1_move1, i9_p1_move2, i9_toCheck_p1_move, i9_played},
                {i10_card_p0, i1_card_p1, i1_card_p2, i10_p1_move1, i10_p1_move2, i10_toCheck_p1_move, i10_played},
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

        commander.sendTestCommand("endTurn");
        commander.sendTestCommand("endTurn");
    }

    @Test
    @Description("A player's attempts to play one or more melds from hand after initial 30 points of previous turn obtained with R11 O11 G11")
    public void testSequence() throws IOException {
        p1.writeToConsole(p1_move_2);
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(0);

        for(List<String> meld : toCheck_p1_move){
//            System.out.println("############################################################  " + localPlayer.getTiles());
//            System.out.println("############################################################  " + localGameTable);

            assertTrue(localGameTable.contains(meld));

            for(String tile : meld){
                if(localPlayer.getTiles().contains(tile)){
                    assertTrue(localPlayer.getTiles().contains(tile));
                }
                else {
                    assertFalse(localPlayer.getTiles().contains(tile));
                }
            }
        }

        assertEquals(localPlayer.getTiles().size(), 14-p1_played);
    }
}
