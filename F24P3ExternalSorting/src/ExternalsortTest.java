import student.TestCase;

/**
 * @author THIS IS A TEST CHANGE
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
     * T
     */
    public void testExternalsort() {
        String[] args = {"MakeAFileUsingByteFile.data"};
        Externalsort.main(args);
    }

}
