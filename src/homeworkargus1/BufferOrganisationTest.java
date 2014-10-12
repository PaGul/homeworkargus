package homeworkargus1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class BufferOrganisationTest {

    BufferOrganisation<Integer> instance;
    LinkedList<Integer> container;
    Iterator<Integer> itInteger;
    @Before
    public void setUp() {
        //LIFO ходящий через элемент понечётным позициям
        instance = new BufferOrganisation<Integer>() {

            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    {
                        boolean isEmpty = container.isEmpty();
                        if (isEmpty) {
                            throw new NoSuchElementException();
                        }
                    }
                    int size = container.size();
                    int nextIndex = size - 1;
                    Integer lastReturned = container.get(0);
                    Integer next = container.get(nextIndex);

                    @Override
                    public boolean hasNext() {
                        return nextIndex >= 0;
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }

                        lastReturned = next;
                        nextIndex-=2;
                        next = (hasNext()) ? container.get(nextIndex) : null;
                        return lastReturned;
                    }

                    @Override
                    public void remove() {
                        container.remove(lastReturned);
                        size--;
                    }

                };
            }
        };
        container = new LinkedList<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
    }

    @After
    public void tearDown() {
    }

    /**
     * null контейнер кидает NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testTakeContainer() {
        instance.takeContainer(null);
    }

    @Test
    public void testIteratorNext() {
        instance.takeContainer(container);
        itInteger = instance.iterator();
        itInteger.next();
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
        assertEquals(4, result);
    }
    
    /**
     * Если вызван итератор до получения контейнера будет выброшен NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testIteratorNullContainer() {
        instance.iterator();
    }

}
