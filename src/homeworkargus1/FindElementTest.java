package homeworkargus1;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class FindElementTest {
    
    FindElement<Double> instance;
    List<Double> container;
    @Before
    public void setUp() {
        //находит элемент наиболее близкий к единице по модулю элемент
        instance = new FindElement<Double>() {

            @Override
            protected Double compare(Double el1, Double el2) {
                if (Math.abs(1-el1)<Math.abs(1-el2)) {
                    return el1;
                }
                return el2;
                
            }
        };
        container = new LinkedList<>();
        container.add(1.1);
        container.add(1.05);
        container.add(-0.5);
    }
    

    /**
     * Получение null вместо контейнера выбрасывает null
     */
    @Test(expected = NullPointerException.class)
    public void testActionWithNullContainer() {
        instance.action(null);
    }
    
    @Test
    public void testCorrectAction() {
        instance.action(container);
        double result = instance.getResult();
        assertEquals(1.05, result, 0.000001);
    }
    
    /**
     * Кидает null, если getResult() вызван до action.
     */
    @Test
    public void testGetResult() {
        Object expResult = null;
        Object result = instance.getResult();
        assertEquals(expResult, result);
    }
}
