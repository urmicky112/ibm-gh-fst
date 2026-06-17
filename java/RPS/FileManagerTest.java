package RPS;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class FileManagerTest {
    private static final String TEST_FILE = "result.txt";
    @BeforeEach
    public void setUp() {
        // Delete the file before each test to start fresh
        deleteTestFile();
    }
    @AfterEach
    public void tearDown() {
        // Clean up after each test
        deleteTestFile();
    }
    private void deleteTestFile() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }
    @Test
    public void testSaveResult_CreatesFile() {
        // Test that the file is created when it doesn't exist
        FileManager.saveResult("Test result");
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should be created");
    }
    @Test
    public void testSaveResult_WritesContent() throws IOException {
        // Test that content is written correctly
        String testResult = "player: rock, computer: scissors, Result: Player wins!";
        FileManager.saveResult(testResult);
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
        assertEquals(1, lines.size(), "File should contain one line");
        assertEquals(testResult, lines.get(0), "Content should match");
    }
    @Test
    public void testSaveResult_AppendsMultipleResults() throws IOException {
        // Test that multiple results are appended
        String result1 = "player: rock, computer: scissors, Result: Player wins!";
        String result2 = "player: paper, computer: rock, Result: Player wins!";
        String result3 = "player: scissors, computer: scissors, Result: Tie!";
        FileManager.saveResult(result1);
        FileManager.saveResult(result2);
        FileManager.saveResult(result3);
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
        assertEquals(3, lines.size(), "File should contain three lines");
        assertEquals(result1, lines.get(0));
        assertEquals(result2, lines.get(1));
        assertEquals(result3, lines.get(2));
    }
    @Test
    public void testSaveResult_EmptyString() throws IOException {
        // Test saving an empty string
        FileManager.saveResult("");
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
        assertEquals(1, lines.size());
        assertEquals("", lines.get(0));
    }
    @Test
    public void testSaveResult_SpecialCharacters() throws IOException {
        // Test saving special characters
        String specialResult = "Test: @#$%^&*()_+-=[]{}|;:',.<>?/~`";
        FileManager.saveResult(specialResult);
        List<String> lines = Files.readAllLines(Paths.get(TEST_FILE));
        assertEquals(specialResult, lines.get(0));
    }
    @Test
    public void testSaveResult_DoesNotThrowException() {
        // Test that method doesn't throw exception
        assertDoesNotThrow(() -> {
        	FileManager.saveResult("Test result");
        });
    }
}