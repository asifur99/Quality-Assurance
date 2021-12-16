package Assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ParamTest1 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0; // Hand of Player 1
    private final ArrayList<String> hand_p1; // Hand of Player 2
    private final ArrayList<String> hand_p2; // Hand of Player 3

    // For Player 1
    private final String p0_up_hand; // Updated hand
    private final String p0_up_table; // Updated Table

    private final String[] p2_move; // Command for Player 2 to make a certain move
    private final String[] p3_move; // Command for Player 3 to make a certain move

    private final List<List<String>> toCheck_p1_move; // check the move made by Player 1 is valid or not
    private final List<List<String>> toCheck_p2_move; // check the move made by Player 2 is valid or not
    private final List<List<String>> toCheck_p3_move; // check the move made by Player 3 is valid or not


    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments
    // from parameters we defined in generateData() method
    public ParamTest1(ArrayList<String> p0_card, ArrayList<String> p1_card, ArrayList<String> p2_card, String[] p2_move, String[] p3_move, String p0_up_hand, String p0_up_table, List<List<String>> toCheck_p2_move, List<List<String>> toCheck_p3_move, List<List<String>> toCheck_p1_move) {
        this.hand_p0 = p0_card;
        this.hand_p1 = p1_card;
        this.hand_p2 = p2_card;
        this.p2_move = p2_move;
        this.p3_move = p3_move;
        this.p0_up_hand = p0_up_hand;
        this.p0_up_table = p0_up_table;
        this.toCheck_p2_move = toCheck_p2_move;
        this.toCheck_p3_move = toCheck_p3_move;
        this.toCheck_p1_move = toCheck_p1_move;
    }

    @Parameterized.Parameters
    public static Collection generateData(){
        //for iteration 1
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R1", "R2", "R3", "R3", "R4", "R4", "R5", "R5", "R6", "R12", "B12", "G12", "O12"));
        ArrayList<String> i1_card_p1 = new ArrayList<>(Arrays.asList("R11", "R12", "R13", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10", "G11"));
        ArrayList<String> i1_card_p2 = new ArrayList<>(Arrays.asList("R2", "R13", "B2", "B3", "B3", "B4", "B4", "B5", "B5", "B6", "B13", "G2", "G4", "G13"));
        
        String[] i1_p2_move = new String[]{"2", "{G1 G2 G3 G4 G5 G6 G7 G8 G9 G10 G11}", "{R11 R12 R13}"};
        List<List<String>> toCheck_p2_move = new ArrayList<>();
        toCheck_p2_move.add(Arrays.asList("R11", "R12", "R13"));
        
        String[] i1_p3_move = new String[]{"2", "{B3 B3 B4 B4 B5 B5 B6 G4}", "{R11 R12 R13} {R13 B13 G13} {R2 B2 G2}"};
        List<List<String>> toCheck_p3_move = new ArrayList<>();
        toCheck_p3_move.add(Arrays.asList("R13", "B13", "G13"));
        toCheck_p3_move.add(Arrays.asList("R2", "B2", "G2"));

        String i1_p1_updated_hand = "{R1 R1 R2 R3 R3 R4 R4 R5 R5 R6 ";
        String i1_p1_updated_table = "{R11 R12 R13} {R13 B13 G13} {R2 B2 G2} {R12 B12 G12 O12}";
        List<List<String>> toCheck_p1_move = new ArrayList<>();
        toCheck_p1_move.add(Arrays.asList("R12", "B12", "G12", "O12"));

        return Arrays.asList(new Object[][] {
                { i1_card_p0, i1_card_p1, i1_card_p2, i1_p2_move, i1_p3_move, i1_p1_updated_hand, i1_p1_updated_table, toCheck_p2_move, toCheck_p3_move, toCheck_p1_move }
        });
    }

    @Test
    @Description("Network Test")
    public void testSequence() throws IOException {
        commander.sendTestCommand("reset");

        commander.sendTestCommand("setPlayerTiles 0 " + hand_p0);
        commander.sendTestCommand("setPlayerTiles 1 " + hand_p1);
        commander.sendTestCommand("setPlayerTiles 2 " + hand_p2);

        assertEquals(hand_p0.size(), commander.getPlayer(0).getTiles().size());
        assertEquals(14, hand_p1.size());
        assertEquals(14, hand_p2.size());

        commander.sendTestCommand("draw");
        commander.sendTestCommand("endTurn");

        //Ensure table is empty and player drawn a card
        assertEquals(commander.getGameTable().size(), 0);
        assertEquals(14, hand_p0.size());

        //Write [play melds, updatedHand, updatedTable, end turn]
        p2.writeToConsole(p2_move);
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(1);

        //Ensure that tiles were played
        for(List<String> meld : toCheck_p2_move){
            assertTrue(localGameTable.contains(meld));
            for(String tile : meld){
                assertFalse(localPlayer.getTiles().contains(tile));
            }
        }

        p3.writeToConsole(p3_move);
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(2);

        //Ensure that tiles were played
        for(List<String> meld : toCheck_p3_move){
            assertTrue(localGameTable.contains(meld));
            for(String tile : meld){
                assertFalse(localPlayer.getTiles().contains(tile));
            }
        }

        //Because we drew a tile at the start of the game, we have to figure which one we have drawn
        localPlayer = commander.getPlayer(0);
        List<String> diffTiles = Utils.getDifferenceInLists(localPlayer.getTiles(), hand_p0);

        //Then we add it to the list of tiles
        p1.writeToConsole(new String[]{"2", p0_up_hand + diffTiles.get(0) + "}", p0_up_table});
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(0);

        //Ensure that tiles were played
        for(List<String> meld : toCheck_p1_move){
            assertTrue(localGameTable.contains(meld));
            for(String tile : meld){
                assertFalse(localPlayer.getTiles().contains(tile));
            }
        }
    }
}