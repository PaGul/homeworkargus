package homeworkargus1;

import java.util.Iterator;

/** Проходит по всем элементам полученного контейнера и возвращает результат в соответствии с заданным правилом сравнения,
 * определённом у наследников (метод compare). Возвращает тот же тип, что в контейнере.
 * 
 * @param <T> 
 */
abstract class FindElement<T> implements Action<Iterable<T>, T> {

    protected T result;
    protected Iterator<T> it;

    /** Принимает контейнер, итеративно сравнивает пары элементов методом
     * compare, переопределяемым наследниками и возвращает результат в result. 
     * 
     * @param container принимает контейнер в котором ищется элемент
     * @throws NullPointerException
     */
    @Override
    public void action(Iterable<T> container) {
        if (container==null) throw new NullPointerException();
        it = container.iterator();
        result = it.next();
        while (it.hasNext()) {
            T temp = it.next();
            result = compare(result, temp);
        }
    }

    /**
     * Возвращает результат action. Если будет вызван до action, выкинет null.
     * @return 
     */
    @Override
    public T getResult() {
        return result;
    }
    
    /**
     * Возвращает один из двух переданных элементов, который больше удовлетворяет требуемому условию,
     * например наибольший, если требуется найти максимальный элемент в контейнере.
     * 
     * @param el1
     * @param el2
     * @return 
     */
    abstract protected T compare(T el1, T el2);
}


/**
 * Находит наименьший элемент среди элементов, сравнимых друг с другом
 * @author pavelgulaev
 * @param <T> тип элементов в контейнере
 */
class MinComparableElement<T extends Comparable<T>> extends FindElement<T> {

    @Override
    protected T compare(T el1, T el2) {
        if (el1.compareTo(el2) == 1) {
            return el2;
        }
        return el1;
    }

}

/**
 * Находит самую короткую строку в контейнере
 *
 * @param <T> тип элементов в контейнере (extends CharSequence)
 */
class MinStringLengthElement<T extends CharSequence> extends FindElement<T> {

    @Override
    protected T compare(T el1, T el2) {
        if (el2.length() < el1.length()) {
            return el2;
        }
        return el1;
    }
}

/**
 * Находит наибольший элемент среди элементов, сравнимых друг с другом
 * @author pavelgulaev
 * @param <T> тип элементов в контейнере
 */
class MaxComparableElement<T extends Comparable<T>> extends FindElement<T> {
    @Override
    protected T compare(T el1, T el2) {
        if (el1.compareTo(el2) == -1) {
            return el2;
        }
        return el1;
    }
}

/**
 * Находит самую длинную строку в контейнере
 *
 * @param <T> тип элементов в контейнере (extends CharSequence)
 */
class MaxStringLengthElement<T extends CharSequence> extends FindElement<T> {

    @Override
    protected T compare(T el1, T el2) {
        if (el2.length() > el1.length()) {
            return el2;
        }
        return el1;
    }
}
