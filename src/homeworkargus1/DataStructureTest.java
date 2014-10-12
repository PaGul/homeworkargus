package homeworkargus1;

import java.util.Arrays;
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
public class DataStructureTest {

    DataStructure<Integer> integerInstance;
    Iterator<Integer> itInteger;

    @Before
    public void setUp() {
        LinkedList<Integer> container = new LinkedList<>();
        container.add(1);
        container.add(2);
        container.add(3);
        integerInstance = new DataStructure<>(container);
    }


    @Test(expected = NullPointerException.class)
    public void testWrongInitialization() {
        DataStructure<Integer> instance = new DataStructure<Integer>(null, null);
    }

    /**
     * Test of setNewContainer method, of class DataStructure.
     */
    @Test
    public void testSetNewContainer() {
        integerInstance.setNewContainer(Arrays.asList(4, 5, 6));
        int res = integerInstance.iterator().next();
        assertEquals(6, res);
    }

    /**
     * Кидаю пустой контейнер
     */
    @Test(expected = NullPointerException.class)
    public void testSetNullNewContainer() {
        integerInstance.setNewContainer(null);
    }
    
    /**
     * Test of setBufferOrganisation method, of class DataStructure.
     */
    @Test
    public void testSetBufferOrganisation() {
        integerInstance.setBufferOrganisation(new FIFO<Integer>());
        int res = integerInstance.iterator().next();
        assertEquals(1, res);
    }

    
    /**
     * Кидаю пустой алгоритм выборки
     */
    
    @Test(expected = NullPointerException.class)
    public void testSetNullBufferOrganisation() {
        integerInstance.setBufferOrganisation(null);
    }
    
    /**
     * Test of iterator method for empty container, of class DataStructure.
     */
    @Test(expected = NoSuchElementException.class)
    public void testIteratorForEmptyContainer() {
        DataStructure instance = new DataStructure();
        Iterator result = instance.iterator();
    }

    /**
     * Test of iterator method, of class DataStructure.
     */
    @Test
    public void testIterator() {
        String res = "";
        itInteger = integerInstance.iterator();
        while (itInteger.hasNext()) {
            res += itInteger.next();
        }
        assertEquals("321", res);
    }

    /**
     * Test of actionFind method for comparable arguments, of class
     * DataStructure.
     */
    @Test
    public void testActionFindComparable() {
        int result = integerInstance.actionFind(new MaxComparableElement<Integer>());
        assertEquals(3, result);
    }

    /**
     * Test of actionFind method for string arguments, of class DataStructure.
     */
    @Test
    public void testActionFindStringLength() {
        LinkedList<CharSequence> container = new LinkedList<>();
        container.add("q");
        container.add("qw");
        container.add("qwe");
        DataStructure<CharSequence> charInstance = new DataStructure<>(container);
        String result = charInstance.actionFind(new MinStringLengthElement<CharSequence>()).toString();
        assertEquals("q", result);
    }

    /**
     * Test of actionAnalyze method, of class DataStructure.
     */
    @Test
    public void testActionAnalyze() {
        LinkedList<CharSequence> container = new LinkedList<>();
        container.add("q");
        container.add("qw");
        container.add("qwe");
        DataStructure<CharSequence> charInstance = new DataStructure<>(container);
        int result = charInstance.actionAnalyze(new AverageLengthOfWordsInString<CharSequence>(), "q qw qwe");
        assertEquals(2, result);
    }

}
