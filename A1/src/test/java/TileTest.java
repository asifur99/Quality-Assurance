import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    @Test
    @DisplayName("Checking Tiles are set properly")
    public void checkTiles(){
        //making a R12 card
        Tile tile1 = new Tile('R', 12);
        assertEquals('R', tile1.getColor());
        assertEquals(12, tile1.getRank());

        //making a O1 card
        Tile tile2 = new Tile('O', 1);
        assertEquals('O', tile2.getColor());
        assertEquals(1, tile2.getRank());
    }

    @Test
    @DisplayName("Checking Tiles movement are recorded or not")
    public void checkMotion(){
        //making a R12 card
        Tile tile1 = new Tile('R', 12);
        assertFalse(tile1.moved());
        tile1.setJustMoved(true);
        assertTrue(tile1.moved());

        assertFalse(tile1.played());
        tile1.setJustPlayed(true);
        assertTrue(tile1.played());
    }
}