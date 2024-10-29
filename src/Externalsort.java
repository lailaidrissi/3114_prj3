/**
 * {Project Description Here}
 */
import java.io.*;
import java.nio.ByteBuffer;
/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class Externalsort {

    private static Record[] records = new Record[512];
    private static int numRecords = 0;
    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile(args[0], "r")){
            // read in block
            byte[] buffer = new byte[8192];
            
            // create ByteBuffer wrapper
            ByteBuffer bb = ByteBuffer.wrap(buffer);
            int roomLeftOnLine = 4;
            StringBuilder strBuilder = new StringBuilder();
            for (int block = 0; block < 16; block++) {
                numRecords = 0;
                bb.position(0);
                // convert from binary to longs and doubles
                for (int i = 0; i < 512; i++) {
                    long l = file.readLong();
                    double d = file.readDouble();
                    bb.putLong(l);
                    //System.out.println(l);
                    bb.putDouble(d);
                    //System.out.println(d);
                    Record r = new Record(l, d);
                    records[numRecords] = r;
                    numRecords++;
                }
                strBuilder.append(records[0].getID()+ " " + records[0].getKey());
                if (roomLeftOnLine == 0) {
                    strBuilder.append("\n");
                    roomLeftOnLine = 4;
                } else {
                    strBuilder.append(" ");
                    roomLeftOnLine--;
                }                
                bb.clear();
            }
            
            System.out.println(strBuilder.toString());
//            System.out.println(file.read(b));
//            System.out.println(b[0]);
            
            // store into record array
            // print first record in each block from record array
            
            file.close();
        }
        catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        
    }

}
