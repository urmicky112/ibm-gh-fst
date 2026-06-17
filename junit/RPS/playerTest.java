package RPS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class playerTest {
    private player testPlayer;
    
    @BeforeEach
    public void setUp() throws Exception {
        testPlayer = new player();
    }
 
    @Test
    @DisplayName("Test setChoice with lowercase input")
    public void testSetChoiceWithLowercase() {
        testPlayer.setChoice("rock");
        assertEquals("rock", testPlayer.getChoice(), "Choice should be 'rock' when set with lowercase");
    }
    
    @Test
    @DisplayName("Test setChoice with uppercase input - should convert to lowercase")
    public void testSetChoiceWithUppercase() {
        testPlayer.setChoice("ROCK");
        assertEquals("rock", testPlayer.getChoice(), "Choice should be converted to lowercase 'rock'");
    }
    
    @Test
    @DisplayName("Test setChoice with mixed case input - should convert to lowercase")
    public void testSetChoiceWithMixedCase() {
        testPlayer.setChoice("RoCk");
        assertEquals("rock", testPlayer.getChoice(), "Choice should be converted to lowercase 'rock'");
    }
    
    @Test
    @DisplayName("Test setChoice with 'paper'")
    public void testSetChoiceWithPaper() {
        testPlayer.setChoice("PAPER");
        assertEquals("paper", testPlayer.getChoice(), "Choice should be 'paper' in lowercase");
    }
    
    @Test
    @DisplayName("Test setChoice with 'scissors'")
    public void testSetChoiceWithScissors() {
        testPlayer.setChoice("SCISSORS");
        assertEquals("scissors", testPlayer.getChoice(), "Choice should be 'scissors' in lowercase");
    }
    
    @Test
    @DisplayName("Test getChoice returns null when choice is not set")
    public void testGetChoiceWhenNotSet() {
        assertNull(testPlayer.getChoice(), "Choice should be null when not set");
    }
    
    @Test
    @DisplayName("Test getChoice returns the set value")
    public void testGetChoiceReturnsSetValue() {
        testPlayer.setChoice("rock");
        assertNotNull(testPlayer.getChoice(), "Choice should not be null after being set");
        assertEquals("rock", testPlayer.getChoice(), "getChoice should return the value that was set");
    }
    
    @Test
    @DisplayName("Test setChoice can be called multiple times - last value wins")
    public void testSetChoiceMultipleTimes() {
        testPlayer.setChoice("rock");
        assertEquals("rock", testPlayer.getChoice(), "First choice should be 'rock'");
        
        testPlayer.setChoice("paper");
        assertEquals("paper", testPlayer.getChoice(), "Choice should be updated to 'paper'");
        
        testPlayer.setChoice("SCISSORS");
        assertEquals("scissors", testPlayer.getChoice(), "Choice should be updated to 'scissors' in lowercase");
    }
    
    @Test
    @DisplayName("Test setChoice with empty string")
    public void testSetChoiceWithEmptyString() {
        testPlayer.setChoice("");
        assertEquals("", testPlayer.getChoice(), "Choice should be empty string when set to empty string");
    }
    
    @Test
    @DisplayName("Test setChoice with string containing spaces")
    public void testSetChoiceWithSpaces() {
        testPlayer.setChoice("ROCK PAPER");
        assertEquals("rock paper", testPlayer.getChoice(), "Choice should preserve spaces and convert to lowercase");
    }
}