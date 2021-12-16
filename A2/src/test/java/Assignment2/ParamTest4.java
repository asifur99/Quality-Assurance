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
public class ParamTest4 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0; // Hand of Player 1
    private final ArrayList<String> hand_p1; // Hand of Player 2
    private final ArrayList<String> hand_p2; // Hand of Player 3

    private final String[] p1_move_1;
    private final String[] p1_move_2;
    private final List<List<String>> toCheck_p1_move;
    private final int p1_played;


    public ParamTest4(ArrayList<String> hand_p0, ArrayList<String> hand_p1, ArrayList<String> hand_p2, String[] p1_move_1, String[] p1_move_2, List<List<String>> toCheck_p1_move, int p1_played) {
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
        //valid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R11", "R11", "R12", "B2", "B4", "B6", "B11", "G11", "O11", "O11"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("R9", "R12", "R13", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("R2", "R13", "B2", "B3", "B3", "B4", "B5", "B5", "B6", "B7", "B13", "G2", "G4", "G13"));

        String[] i1_p1_move1 = new String[]{"2", "{R1 R3 R5 R7 R11 R12 B2 B4 B6 B11 O11}", "{R11 O11 G11}"};
        String[] i1_p1_move2 = new String[]{"2", "{R1 R3 R5 R7 R12 B2 B4 B6}", "{R11 O11 G11} {B11 O11 R11}"};

        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R11", "B11", "O11"));
        int i1_played = 6;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R11", "R12", "B2", "B4", "B6", "B11", "B12", "B13", "G11", "O11"));

        String[] i2_p1_move1 = new String[]{"2", "{R1 R3 R5 R7 R12 B2 B4 B6 B11 B12 B13}", "{R11 O11 G11}"};
        String[] i2_p1_move2 = new String[]{"2", "{R1 R3 R5 R7 R12 B2 B4 B6}", "{R11 O11 G11} {B11 B12 B13}"};

        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("B11", "B12", "B13"));
        int i2_played = 6;

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R4", "R9", "R11", "B11", "B12", "B13", "G1", "G4", "G11", "O1", "O4", "O11"));

        String[] i3_p1_move1 = new String[]{"2", "{R1 R3 R4 R9 B11 B12 B13 G1 G4 O1 O4}", "{R11 O11 G11}"};
        String[] i3_p1_move2 = new String[]{"2", "{R3 R9}", "{R11 O11 G11} {B11 B12 B13} {O1 G1 R1} {O4 G4 R4}"};

        List<List<String>> i3_toCheck_p1_move = new ArrayList<>();
        i3_toCheck_p1_move.add(Arrays.asList("B11", "B12", "B13"));
        i3_toCheck_p1_move.add(Arrays.asList("R1", "G1", "O1"));
        i3_toCheck_p1_move.add(Arrays.asList("R4", "G4", "O4"));

        int i3_played = 12;


        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_card_p1, i1_card_p2, i1_p1_move1, i1_p1_move2, i1_toCheck_p1_move, i1_played},
                {i2_card_p0, i1_card_p1, i1_card_p2, i2_p1_move1, i2_p1_move2, i2_toCheck_p1_move, i2_played},
                {i3_card_p0, i1_card_p1, i1_card_p2, i3_p1_move1, i3_p1_move2, i3_toCheck_p1_move, i3_played},
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
                assertFalse(localPlayer.getTiles().contains(tile));
            }
        }

        assertEquals(localPlayer.getTiles().size(), 14-p1_played);
    }
}
