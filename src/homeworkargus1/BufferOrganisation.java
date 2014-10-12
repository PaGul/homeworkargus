package homeworkargus1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Контракт алгоритма обработки. Прежде чем возвращать итератор, обязательно
 * надо передать коллекцию!
 *
 *
 * @author pavel
 * @param <T> the type of elements in the processed data structure.
 */
public abstract class BufferOrganisation<T> implements Iterable<T> {

    /**
     * Внутренний контейнер, хранящий элементы
     */
    protected List<T> container;

    /**
     * Принимает контейнер для обработки
     *
     * @param c - контейнер
     * @throws NullPointerException
     */
    public void takeContainer(Iterable<T> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        container = new LinkedList<>();
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            container.add(it.next());
        }
    }

    /**
     * Возвращает итератор, который возвращает элементы из контейнера по
     * заданному правилу. Если вызван до takeContainer(), то выкидывает NullPointerException
     *
     * @return итератор
     * @throws NoSuchElementException для методов итератора, если контейнер пуст
     * @throws NullPointerException если контейнер не проиницилизирован
     */
    @Override
    abstract public Iterator<T> iterator();
}