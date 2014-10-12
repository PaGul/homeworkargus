package homeworkargus1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class MaxStringLengthElementTest {

    /**
     * Test of compare method, of class MaxStringLengthElement.
     */
    @Test
    public void testCompare() {
        String el1 = "first";
        String el2 = "secondfirst";
        MaxStringLengthElement<String> instance = new MaxStringLengthElement<>();
        String result = instance.compare(el1, el2);
        assertEquals("secondfirst", result);
    }
    
}
