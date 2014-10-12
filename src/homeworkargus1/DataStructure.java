package homeworkargus1;

import java.util.Iterator;
import java.util.LinkedList;

/** Хранит и обрабатывает данные T-типа в соответствии с динамически получаемыми алгоритмами обработки.
 * 
 * @author pavel
 * @param <T> - тип элементов в структуре. 
 */
public class DataStructure<T> {

    /**
     * Алгоритм выборки (organisation) и контейнер (container) не могут быть null
     */
    private BufferOrganisation<T> organisation;
    private Iterable<T> container;
    /**Создаёт структуру данных с заданным контейнером и алгоритмом выбора элементов.
     * 
     * @param organisation Алгоритм выбора элементов.
     * @param container Контейнер структуры данных.
     * @throws NullPointerException
     */
    public DataStructure(BufferOrganisation<T> organisation, Iterable<T> container) {
        if ((container==null)||(organisation==null)) throw new NullPointerException();
        this.container = container;
        this.organisation = organisation;
        this.organisation.takeContainer(container);
    }

    /**
     * Создаёт структуру данных с LinkedList-контейнером и LIFO выборкой по умолчанию.
     * 
     */
    public DataStructure() {
        this(new LIFO<T>(), new LinkedList<T>());
    }

    /** Создаёт структуру данных с заданным контейнером и LIFO выборкой по умолчанию.
     * 
     * @param container Контейнер структуры данных.
     * @throws NullPointerException
     */
    public DataStructure(Iterable<T> container) {
        this(new LIFO<T>(), container);
    }

    /**Создаёт структуру данных с LinkedList-контейнером и заданным алгоритмом выбора элементов
     * 
     * @param organisation Алгоритм выбора элементов.
     * @throws NullPointerException
     */
    public DataStructure(BufferOrganisation<T> organisation) {
        this(organisation, new LinkedList<T>());
    }

    /**Меняет контейнер структуры данных.
     * 
     * @param container - Iterable множество элементов
     * @throws NullPointerException
     */
    public void setNewContainer(Iterable<T> container) {
        if (container==null) throw new NullPointerException();
        this.container = container;
        organisation.takeContainer(container);
    }
    
    /**
     * Задаёт алгоритм выборки элементов.
     * 
     * @param organisation Алгоритм выборки элементов
     * @throws NullPointerException
     */
    public void setBufferOrganisation(BufferOrganisation<T> organisation) {
        if (organisation==null) throw new NullPointerException();
        this.organisation = organisation;
        organisation.takeContainer(container);
    }

    
    /**
     * Возвращает итератор структуры данных в соответствии с заданным алгоритмом выборки
     * 
     * @return iterator
     * @throws NoSuchElementException для методов итератора, если контейнер пуст
     */
    public Iterator<T> iterator() {
        return organisation.iterator();
    }
    
    /** Принимает стратегию нахождения элемента в структуре по заданному правилу и возвращает элемент
     * 
     * @param actionStrategy Заданное правило
     * @return Найденный элемент
     */
    public T actionFind(Action<Iterable<T>,T> actionStrategy) {
        actionStrategy.action(container);
        return actionStrategy.getResult();
    }
    
    /** Анализирует переданный элемент и возвращает результат анализа по заданному правилу
     * 
     * @param <R> - возвращаемый тип
     * @param actionStrategy Заданное правило
     * @param element Анализируемый элемент
     * @return Результаты анализа
     */
    public <R> R actionAnalyze(Action<T, R> actionStrategy, T element) {
        actionStrategy.action(element);
        return actionStrategy.getResult();
    }
}
