package homeworkargus1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author pavelgulaev
 */
/**
 * LIFO алгоритм обработки
 * Контейнер хранится у родителя BufferOrganisation<T> 
*
 * @author pavel
 * @param <T>
 */
class LIFO<T> extends BufferOrganisation<T> {

    /**
     * Возвращает итератор, который возвращает элементы из контейнера в порядке,
     * обратному порядку поступления. Если вызван до takeContainer(), то выкидывает NullPointerException
     *
     * @return итератор
     * @throws NoSuchElementException для методов итератора, если контейнер пуст
     * @throws NullPointerException если контейнер не проиницилизирован
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            {
                boolean isEmpty = container.isEmpty();
                if (isEmpty) {
                    throw new NoSuchElementException();
                }
            }
            int size = container.size();
            int nextIndex = size - 1;
            T lastReturned = container.get(0);
            T next = container.get(nextIndex);

            @Override
            public boolean hasNext() {
                return nextIndex >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                lastReturned = next;
                nextIndex--;
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
}

