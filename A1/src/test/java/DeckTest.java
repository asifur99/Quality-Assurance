import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private final Deck deck = new Deck();

    @Test
    @DisplayName("Checking The Deck is initiated properly with 104 cards")
    public void checkDeck(){
        assertEquals(104, deck.getLength());
    }

    @Test
    @DisplayName("Check if I can pull a Tile that I want from the deck and removes it from the deck")
    public void removeTile(){
        Tile tile = deck.pullTile();
        assertTrue(deck.exists(tile));



        deck.pullTile();
        assertEquals(102, deck.getLength());
    }

    @Test
    @DisplayName("Checking if the resetting works for Deck")
    public void checkReset(){
        deck.pullTile();
        deck.pullTile();
        deck.pullTile();
        deck.pullTile();

        assertEquals(100, deck.getLength());

        deck.reset();

        assertEquals(104, deck.getLength());
    }
}
