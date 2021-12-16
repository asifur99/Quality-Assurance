package Assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParamTest5 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0;
    private final String[] p1_move, p1_move_1;
    private final boolean needed;

    public ParamTest5(ArrayList<String> hand_p0, String[] p1_move, String[] p1_move_1, boolean needed) {
        this.hand_p0 = hand_p0;
        this.p1_move = p1_move;
        this.p1_move_1 = p1_move_1;
        this.needed = needed;
    }

    @Parameterized.Parameters
    public static Collection generateData(){

        //for scenario 1
        //valid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "R13", "R1", "R3", "R5", "R7", "R9", "R11", "R13"));
        String[] i1_p1_move = new String[]{"1"};
        String[] i1_p1_move_1 = null;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "R12", "R13", "R1", "R3", "R5", "R7", "R9", "R13"));
        String[] i2_p1_move = new String[]{"1"};
        String[] i2_p1_move_1 = new String[]{"2", "{R1 R3 R5 R7 R9 R1 R3 R5 R7 R9 R13}", "{R11 R12 R13}"};

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "R12", "R13", "R1", "R3", "R5", "R7", "R9", "R13"));
        String[] i3_p1_move = new String[]{"1"};
        String[] i3_p1_move_1 = null;

        //for scenario 4
        //valid
        ArrayList<String> i4_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "R12", "R13", "R1", "R3", "R5", "R7", "O1", "G1"));
        String[] i4_p1_move = new String[]{"1"};
        String[] i4_p1_move_1 = new String[]{"2", "{R1 R3 R5 R7 R9 R1 R3 R5 R7 O1 G1}", "{R11 R12 R13}"};

        //for scenario 5
        //valid
        ArrayList<String> i5_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "R12", "R13", "R1", "R3", "R5", "R7", "O1", "R14"));
        String[] i5_p1_move = new String[]{"1"};
        String[] i5_p1_move_1 = new String[]{"2", "{R1 R3 R5 R7 R9 R1 R3 R5 R7 R14 O1}", "{R11 R12 R13}"};

        return Arrays.asList(new Object[][] {
                {i1_card_p0, i1_p1_move, i1_p1_move_1, false},
                {i2_card_p0, i2_p1_move, i2_p1_move_1, true},
                {i3_card_p0, i3_p1_move, i3_p1_move_1, false},
                {i4_card_p0, i4_p1_move, i4_p1_move_1, true},
//                {i5_card_p0, i5_p1_move, i5_p1_move_1, true}, //w
        });
    }

    @Before
    public void init(){
        commander.sendTestCommand("reset");
        commander.sendTestCommand("setPlayerTiles 0 " + hand_p0);

        if(needed){
            commander.sendTestCommand("setPlayerTiles 1 " + new ArrayList<>(Arrays.asList("B1", "B1", "B2", "B2", "B3", "B3", "B4", "B4", "B5", "B5", "B6", "B6", "B7", "B7")));
            commander.sendTestCommand("setPlayerTiles 2 " + new ArrayList<>(Arrays.asList("O1", "O1", "O2", "O2", "O3", "O3", "O4", "O4", "O5", "O5", "O6", "O6", "O7", "O7")));

            //Write [play melds, updatedHand, updatedTable]
            p1.writeToConsole(p1_move_1);
            commander.sendTestCommand("round");

            commander.sendTestCommand("endTurn");
            commander.sendTestCommand("endTurn");
        }
    }

    @Test
    @Description("A player's attempts to play one or more melds from hand after initial 30 points of previous turn obtained with R11 O11 G11")
    public void testSequence() throws IOException {
        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(0);

        p1.writeToConsole(p1_move);
        commander.sendTestCommand("round");

        System.out.println("#######################################################################  " + commander.sendTestCommand("getIfPlayerCanPlayMelds"));

        localPlayer = commander.getPlayer(0);

        if(needed){
            assertEquals(localPlayer.getTiles().size(), 12);
        }
        else {
            assertEquals(localPlayer.getTiles().size(), 15);
        }
    }
}
