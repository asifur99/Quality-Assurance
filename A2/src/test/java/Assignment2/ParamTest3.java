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
public class ParamTest3 extends ThreePlayersNetworkTest{
    private final ArrayList<String> hand_p0;

    // For Player 1
    private final String[] p1_move;
    private final List<List<String>> toCheck_p1_move;
    private final int p1_played;

    public ParamTest3(ArrayList<String> hand_p0, String[] p1_move, List<List<String>> toCheck_p1_move, int p1_played) {
        this.hand_p0 = hand_p0;
        this.p1_move = p1_move;
        this.toCheck_p1_move = toCheck_p1_move;
        this.p1_played = p1_played;
    }

    @Parameterized.Parameters
    public static Collection generateData(){
        //Scenario 1
        //invalid
        ArrayList<String> i1_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R9", "R11", "R13", "B2", "B4", "B6", "*", "B10", "G11", "G12", "O9"));
        String[] i1_p1_move = new String[]{"1"};
        List<List<String>> i1_toCheck_p1_move = new ArrayList<>();
        i1_toCheck_p1_move.add(Arrays.asList("R9", "*", "O9"));
        int i1_played = 0;

        //for scenario 2
        //valid
        ArrayList<String> i2_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R11", "R13", "B2", "B4", "B6", "B9", "B11", "G5", "G12", "*"));
        String[] i2_p1_move = new String[]{"2", "{R1 R3 R5 R7 R13 B2 B4 B6 B9 G5 G12}", "{B11 * R11}"};
        List<List<String>> i2_toCheck_p1_move = new ArrayList<>();
        i2_toCheck_p1_move.add(Arrays.asList("G11", "R11", "B11"));
        int i2_played = 3;

        //for scenario 3
        //valid
        ArrayList<String> i3_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R13", "B2", "B4", "B6", "*", "B11", "G5", "G9", "O9"));
        String[] i3_p1_move = new String[]{"2", "{R1 R3 R5 R7 R13 B2 B4 B6 B11 G5}", "{* O9 G9 R9}"};
        List<List<String>> i3_toCheck_p1_move = new ArrayList<>();
        i3_toCheck_p1_move.add(Arrays.asList("B9", "R9", "G9", "O9"));
        int i3_played = 4;

        //for scenario 4
        //invalid
        ArrayList<String> i4_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "*", "R10", "R11", "B2", "B4", "B6", "B9", "B10", "G5", "G9", "O11"));
        String[] i4_p1_move = new String[]{"1"};
        List<List<String>> i4_toCheck_p1_move = new ArrayList<>();
        i4_toCheck_p1_move.add(Arrays.asList("*", "R10", "R11"));
        int i4_played = 0;

        //for scenario 5
        //valid
        ArrayList<String> i5_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R11", "*", "R13", "B2", "B4", "B6", "B9", "B10", "G5", "G9", "O11"));
        String[] i5_p1_move = new String[]{"2", "{R1 R3 R5 B2 B4 B6 B9 B10 G5 G9 O11}", "{R11 * R13}"};
        List<List<String>> i5_toCheck_p1_move = new ArrayList<>();
        i5_toCheck_p1_move.add(Arrays.asList("R11", "R12", "R13"));
        int i5_played = 3;

        //for scenario 6
        //valid
        ArrayList<String> i6_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R9", "R11", "B2", "B4", "B6", "G8", "G9", "G10", "*", "O7"));
        String[] i6_p1_move = new String[]{"2", "{R1 R3 R5 R7 R9 R11 B2 B4 B6 O7}", "{G8 G9 G10 *}"};
        List<List<String>> i6_toCheck_p1_move = new ArrayList<>();
        i6_toCheck_p1_move.add(Arrays.asList("G8", "G9", "G10"));
        int i6_played = 4;

        //for scenario 7
        //invalid
        ArrayList<String> i7_card_p0 = new ArrayList<>(Arrays.asList("R1", "R3", "R5", "R7", "R11", "B2", "B4", "G6", "G8", "*", "*", "G10", "G12", "O9"));
        String[] i7_p1_move = new String[]{"1"};
        List<List<String>> i7_toCheck_p1_move = new ArrayList<>();
        i7_toCheck_p1_move.add(Arrays.asList("O9", "*", "*"));
        int i7_played = 0;

        //for scenario 8
        //valid
        ArrayList<String> i8_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R2", "R5", "R4", "B7", "B11", "*", "G9", "*", "G6", "O1", "O3", "O11"));
        String[] i8_p1_move = new String[]{"2", "{R1 R2 R2 R5 R4 B7 G9 G6 O1 O3 O11}", "{B11 * *}"};
        List<List<String>> i8_toCheck_p1_move = new ArrayList<>();
        i8_toCheck_p1_move.add(Arrays.asList("B11", "*", "*"));
        int i8_played = 3;

        //for scenario 9
        //valid
        ArrayList<String> i9_card_p0 = new ArrayList<>(Arrays.asList("R2", "R3", "R3", "R5", "R9", "R13", "G2", "*", "G4", "*", "B3", "B11", "O3", "O9"));
        String[] i9_p1_move = new String[]{"2", "{R2 R3 R3 R5 R13 G2 G4 B3 B11 O3}", "{* O9 * R9}"};
        List<List<String>> i9_toCheck_p1_move = new ArrayList<>();
        i9_toCheck_p1_move.add(Arrays.asList("*", "O9", "*", "R9"));
        int i9_played = 4;

        //for scenario 10
        //valid
        ArrayList<String> i10_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R9", "R10", "*", "B3", "*", "B5", "B9", "G6", "G10", "O1", "O3", "O7"));
        String[] i10_p1_move = new String[]{"2", "{R1 R2 B3 B5 B9 G6 G10 O1 O3 O7}", "{R9 R10 * *}"};
        List<List<String>> i10_toCheck_p1_move = new ArrayList<>();
        i10_toCheck_p1_move.add(Arrays.asList("R9", "R10", "R11", "R12"));
        int i10_played = 4;

        //for scenario 11
        //valid
        ArrayList<String> i11_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R3", "R4", "B1", "B3", "G2", "G3", "G4", "G6", "O1", "*", "O11"));
        String[] i11_p1_move = new String[]{"2", "{G6 O11}", "{R1 O1 B1} {R2 R3 R4} {R3 * B3} {G2 G3 G4}"};
        List<List<String>> i11_toCheck_p1_move = new ArrayList<>();
        i11_toCheck_p1_move.add(Arrays.asList("R1", "B1", "O1"));
        i11_toCheck_p1_move.add(Arrays.asList("R2", "R3", "R4"));
        i11_toCheck_p1_move.add(Arrays.asList("G3", "R3", "B3"));
        i11_toCheck_p1_move.add(Arrays.asList("G2", "G3", "G4"));
        int i11_played = 12;

        //for scenario 12
        //valid
        ArrayList<String> i12_card_p0 = new ArrayList<>(Arrays.asList("R1", "R2", "R3", "R3", "R4", "B1", "B3", "G2", "G3", "*", "G6", "O1", "*", "O11"));
        String[] i12_p1_move = new String[]{"2", "{G6 O11}", "{R1 O1 B1} {R2 R3 R4} {R3 * B3} {G2 G3 *}"};
        List<List<String>> i12_toCheck_p1_move = new ArrayList<>();
        i12_toCheck_p1_move.add(Arrays.asList("R1", "B1", "O1"));
        i12_toCheck_p1_move.add(Arrays.asList("R2", "R3", "R4"));
        i12_toCheck_p1_move.add(Arrays.asList("G3", "R3", "B3"));
        i12_toCheck_p1_move.add(Arrays.asList("G2", "G3", "G4"));
        int i12_played = 12;


        return Arrays.asList(new Object[][] {
                { i1_card_p0, i1_p1_move, i1_toCheck_p1_move, i1_played },
                { i2_card_p0, i2_p1_move, i2_toCheck_p1_move, i2_played },
                { i3_card_p0, i3_p1_move, i3_toCheck_p1_move, i3_played },
                { i4_card_p0, i4_p1_move, i4_toCheck_p1_move, i4_played },
//                { i5_card_p0, i5_p1_move, i5_toCheck_p1_move, i5_played }, //w
                { i6_card_p0, i6_p1_move, i6_toCheck_p1_move, i6_played },
//                { i7_card_p0, i7_p1_move, i7_toCheck_p1_move, i7_played }, //w
//                { i8_card_p0, i8_p1_move, i8_toCheck_p1_move, i8_played }, //w
//                { i9_card_p0, i9_p1_move, i9_toCheck_p1_move, i9_played }, //w
//                { i10_card_p0, i10_p1_move, i10_toCheck_p1_move, i10_played }, //w
                { i11_card_p0, i11_p1_move, i11_toCheck_p1_move, i11_played },
//                { i12_card_p0, i12_p1_move, i12_toCheck_p1_move, i12_played }, //w
        });
    }

    @Test
    @Description("A player's attempts initial 30 points with jokers")
    public void testSequence() throws IOException {
        commander.sendTestCommand("reset");

        commander.sendTestCommand("setPlayerTiles 0 " + hand_p0);

        //Write [play melds, updatedHand, updatedTable]
        p1.writeToConsole(p1_move);
        commander.sendTestCommand("round");

        localGameTable = commander.getGameTable();
        localPlayer = commander.getPlayer(0);

        //When Player Plays a meld
        if(p1_played != 0){
            for(List<String> meld : toCheck_p1_move){
//                System.out.println("############################################################  " + localPlayer.hasToDraw());
//                System.out.println("############################################################  TABLE: " + localGameTable);

                assertTrue(localGameTable.contains(meld));

                for(String tile : meld){
                    assertFalse(localPlayer.getTiles().contains(tile));
                }
            }
        }
        // When player can't play a meld
        else{
            for(List<String> meld : toCheck_p1_move){
                for(String tile : meld){
                    assertTrue(localPlayer.getTiles().contains(tile));
                }
            }
        }

        // If no cards played then one is drawn
        if(p1_played == 0){
            assertEquals(localPlayer.getTiles().size(), 15-p1_played);
        }
        // Just played a meld
        else {
//            System.out.println("############################################################  " + (14-p1_played));
            assertEquals(localPlayer.getTiles().size(), 14-p1_played);
        }
    }

}
