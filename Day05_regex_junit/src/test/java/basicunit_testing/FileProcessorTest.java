package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;


public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private String filename = "testFile.txt";

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    public void tearDown() {
        //Delete the file after each test to ensure clean state
        try {
            Files.deleteIfExists(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteToFile() throws IOException {
        String content = "This is a test content.";

        //Write content to the file
        fileProcessor.writeToFile(filename, content);

        //Verify if the file exists after writing
        assertTrue(Files.exists(Paths.get(filename)));

        //Read the content from the file
        String readContent = fileProcessor.readFromFile(filename);

        //Verify if the content is the same as written
        assertEquals(content, readContent);
    }

    @Test
    public void testReadFromFile_FileNotFound() {
        //Verify that an exception is thrown when trying to read a non-existing file
        FileProcessor fileProcessor = new FileProcessor();

        assertThrows(FileNotFoundException.class, () -> {
            fileProcessor.readFromFile("nonExistingFile.txt");
        });
    }

    @Test
    public void testWriteAndReadFileContent() throws IOException {
        String content = "Test content for validation.";

        //Write the content to the file
        fileProcessor.writeToFile(filename, content);

        //Verify the content is correctly written and can be read back
        String fileContent = fileProcessor.readFromFile(filename);
        assertEquals(content, fileContent);
    }
}
