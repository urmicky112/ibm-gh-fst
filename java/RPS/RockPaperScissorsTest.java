package RPS;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.*;
import org.junit.jupiter.api.*;

class RockPaperScissorsTest {



    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }


    @Test
    void testValidInputRock() {
        String input = "rock\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RockPaperScissors.main(new String[]{});

        String output = outputStream.toString();

        assertTrue(output.contains("Enter rock,paper,scissors:"));
        assertTrue(output.contains("computer chose:"));
        assertTrue(output.contains("Play Again?(y/n):"));
    }

    @Test
    void testValidInputPaper() {
        String input = "paper\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RockPaperScissors.main(new String[]{});

        String output = outputStream.toString();

        assertTrue(output.contains("computer chose:"));
        assertTrue(output.contains("Play Again?(y/n):"));
    }

    @Test
    void testValidInputScissors() {
        String input = "scissors\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RockPaperScissors.main(new String[]{});

        String output = outputStream.toString();

        assertTrue(output.contains("computer chose:"));
        assertTrue(output.contains("Play Again?(y/n):"));
    }

    @Test
    void testInvalidInput() {
        String input = "hello\nrock\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RockPaperScissors.main(new String[]{});

        String output = outputStream.toString();

        assertTrue(output.contains("Invalid input!"));
        assertTrue(output.contains("computer chose:"));
    }

    @Test
    void testPlayAgainOnce() {
        String input = "rock\ny\npaper\n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RockPaperScissors.main(new String[]{});

        String output = outputStream.toString();

        assertTrue(output.contains("computer chose:"));
        assertTrue(output.contains("Play Again?(y/n):"));
    }
}