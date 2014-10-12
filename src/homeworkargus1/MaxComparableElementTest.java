package homeworkargus1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class MaxComparableElementTest {
    

    /**
     * Test of compare method, of class MaxComparableElement.
     */
    @Test
    public void testCompare() {
        Double el1 = 2.1;
        Double el2 = 2.0;
        MaxComparableElement<Double> instance = new MaxComparableElement<>();
        double result = instance.compare(el1, el2);
        assertEquals(2.1, result,0.00000001);
    }
    
}
