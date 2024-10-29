import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class ExternalsortTest extends TestCase {
    
    
    /**
     * set up for tests
     */
    public void setUp() {
        //nothing to set up.
    }
    
    /**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
    
//    /**
//     * T
//     */
//    public void testExternalsort() {
//        String[] args = {"MakeAFileUsingByteFile.data"};
//        Externalsort.main(args);
//    }
    
    // ----------------------------------------------------------
    /**
     * Tests the sample provided.
     */
    public void testSampleInput1() {
        String[] args = {"sampleInput16.bin"};
        Externalsort.main(args);
       }
    
    // ----------------------------------------------------------
    /**
     * Tests the sample provided that is presorted. Tests for data
     * input and output.
     * @throws IOException 
     */
    public void testDataProcessing() throws IOException {
        String[] args = {"sampleInput16_sorted.bin"};
        Externalsort.main(args);
        
        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile(
            "Expected_Std_Out.txt");

        // Compare the two outputs
        // once you have implemented your project
        assertEquals(expectedOutput, actualOutput);
    
    }

}
