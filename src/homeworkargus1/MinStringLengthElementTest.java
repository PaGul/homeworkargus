package homeworkargus1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class MinStringLengthElementTest {

    /**
     * Test of compare method, of class MinStringLengthElement.
     */
    @Test
    public void testCompare() {
        String el1 = "testthree";
        String el2 = "testfour";
        MinStringLengthElement<String> instance = new MinStringLengthElement<>();
        String result = instance.compare(el1, el2);
        assertEquals("testfour", result);
    }
    
}
