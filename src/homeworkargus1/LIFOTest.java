package homeworkargus1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class LIFOTest {
    
    LinkedList<Integer> container;
    Iterator<Integer> itInteger;
    LIFO<Integer> instance;
    @Before
    public void setUp() {
        instance = new LIFO<>();
        container = new LinkedList<>();
        container.add(1);
        container.add(2);
        container.add(3);
    }
    

    /**
     * Тест корректной работы метода next() итератора
     */
    @Test
    public void testIteratorNext() {
        instance.takeContainer(container);
        itInteger = instance.iterator();
        int result = itInteger.next();
        assertEquals(3, result);
    }
    
    /**
     * Тест корректной работы метода hasNext() итератора
     */
    @Test
    public void testIteratorHasNext() {
        int result = 0;
        instance.takeContainer(container);
        itInteger = instance.iterator();
        while (itInteger.hasNext()) {
            result = itInteger.next();
        }
        assertEquals(1, result);
    }
    
    /**
     * Тест корректной работы метода remove() итератора
     */
    public void testIteratorRemove() {
        int result = 0;
        instance.takeContainer(container);
        itInteger = instance.iterator();
        itInteger.next();
        itInteger.remove();
        itInteger = instance.iterator();
        itInteger.next();
        assertEquals(2, result);
    }
    
    /**
     * Если вызван итератор до получения контейнера будет выброшен NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testIteratorNullContainer() {
        instance.iterator();
    }
    
    /**
     * Для незаполненного контейнера все методы итератора выкидывают NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testEmptyContainerHasNext() {
        instance.takeContainer(new LinkedList<Integer>());
        itInteger = instance.iterator();
        itInteger.hasNext();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testEmptyContainerNext() {
        instance.takeContainer(new LinkedList<Integer>());
        itInteger = instance.iterator();
        itInteger.next();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testEmptyContainerRemove() {
        instance.takeContainer(new LinkedList<Integer>());
        itInteger = instance.iterator();
        itInteger.remove();
    }
}
