package RPS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class computerTest {
    
    private computer computer;
    
    @BeforeEach
    public void setUp() {
        computer = new computer();
    }
    
    @Test
    public void testGenerateChoiceNotNull() {
        computer.generateChoice();
        assertNotNull(computer.getChoice(), 
            "Generated choice should not be null");
    }
    
    @Test
    public void testGenerateChoiceIsValid() {
        computer.generateChoice();
        String choice = computer.getChoice();
        assertTrue(choice.equals("rock") || 
                   choice.equals("paper") || 
                   choice.equals("scissors"),
            "Generated choice should be 'rock', 'paper', or 'scissors'");
    }
    
    @RepeatedTest(100)
    public void testGenerateChoiceRandomness() {
        computer.generateChoice();
        String choice = computer.getChoice();
        assertTrue(choice.equals("rock") || 
                   choice.equals("paper") || 
                   choice.equals("scissors"),
            "All generated choices should be valid");
    }
    
    @Test
    public void testGenerateChoiceDistribution() {
        Set<String> generatedChoices = new HashSet<>();
        
        for (int i = 0; i < 100; i++) {
            computer comp = new computer();
            comp.generateChoice();
            generatedChoices.add(comp.getChoice());
        }
        
        assertEquals(3, generatedChoices.size(), 
            "All three choices (rock, paper, scissors) should appear " +
            "in 100 random generations");
        assertTrue(generatedChoices.contains("rock"));
        assertTrue(generatedChoices.contains("paper"));
        assertTrue(generatedChoices.contains("scissors"));
    }
    
    @Test
    public void testMultipleGenerations() {
        computer.generateChoice();
        String firstChoice = computer.getChoice();
        
        computer.generateChoice();
        String secondChoice = computer.getChoice();
        
        assertNotNull(firstChoice);
        assertNotNull(secondChoice);
        assertTrue(firstChoice.equals("rock") || 
                   firstChoice.equals("paper") || 
                   firstChoice.equals("scissors"));
        assertTrue(secondChoice.equals("rock") || 
                   secondChoice.equals("paper") || 
                   secondChoice.equals("scissors"));
    }
    
    @Test
    public void testcomputerExtendsPlayer() {
        assertTrue(computer instanceof player, 
            "Computer should extend player class");
    }
}








