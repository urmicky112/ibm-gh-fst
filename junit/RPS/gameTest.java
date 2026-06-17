package RPS;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class gameTest {

    @Test
    void testDraw() {
        game g = new game();

        String result = g.determineWinner("rock", "rock");

        assertEquals("Draw", result);
        assertEquals(0, g.getPlayerScore());
        assertEquals(0, g.getComputerScore());
    }

    @Test
    void testPlayerWins() {
        game g = new game();

        String result = g.determineWinner("rock", "scissors");

        assertEquals("player Wins", result);
        assertEquals(1, g.getPlayerScore());
        assertEquals(0, g.getComputerScore());
    }

    @Test
    void testComputerWins() {
        game g = new game();

        String result = g.determineWinner("rock", "paper");

        assertEquals("computer Wins", result);
        assertEquals(0, g.getPlayerScore());
        assertEquals(1, g.getComputerScore());
    }

    @Test
    void testScoreAccumulation() {
        game g = new game();

        g.determineWinner("rock", "scissors"); // player
        g.determineWinner("rock", "paper");    // computer
        g.determineWinner("paper", "rock");    // player

        assertEquals(2, g.getPlayerScore());
        assertEquals(1, g.getComputerScore());
    }
}
