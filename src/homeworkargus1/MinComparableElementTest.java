package homeworkargus1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class MinComparableElementTest {
    

    /**
     * Test of compare method, of class MinComparableElement.
     */
    @Test
    public void testCompare() {
        Long el1 = 4l;
        Long el2 = 3l;
        MinComparableElement<Long> instance = new MinComparableElement<>();
        long result = instance.compare(el1, el2);
        assertEquals(3, result);
    }
    
}
