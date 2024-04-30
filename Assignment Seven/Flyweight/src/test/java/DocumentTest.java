import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DocumentTest {

    private static final String TEST_FILENAME = "testDocument.txt";
    private static final String LOAD_TEST_FILENAME = "loadTestDocument.txt";

    @BeforeEach
    public void setUp() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOAD_TEST_FILENAME))) {
            writer.write("H:Arial,12,Red" + System.lineSeparator());
            writer.write("i:Calibri,14,Blue" + System.lineSeparator());
        }
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILENAME));
        Files.deleteIfExists(Path.of(LOAD_TEST_FILENAME));
    }

    @Test
    public void testSaveToFile() throws IOException {
        Document doc = new Document();
        doc.addCharacter('H', "Arial", 12, "Red");
        doc.addCharacter('i', "Calibri", 14, "Blue");
        doc.saveToFile(TEST_FILENAME);

        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILENAME))) {
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();

            assertEquals("H:Arial,12,Red", firstLine);
            assertEquals("i:Calibri,14,Blue", secondLine);
        }
    }

    @Test
    public void testLoadFromFile() throws IOException {
        Document doc = new Document();
        doc.loadFromFile(LOAD_TEST_FILENAME);
        doc.saveToFile(TEST_FILENAME);

        assertFileContentsEqual(LOAD_TEST_FILENAME, TEST_FILENAME);
    }

    private void assertFileContentsEqual(String filename1, String filename2) throws IOException {
        String content1 = Files.readString(Path.of(filename1));
        String content2 = Files.readString(Path.of(filename2));

        assertEquals(content1, content2, "The contents of the files should be identical.");
    }
}