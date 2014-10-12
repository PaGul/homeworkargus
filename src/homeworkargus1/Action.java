package homeworkargus1;


/**Принимает тип Input, осуществляет над ним какие-то действия и возвращает результат типа Result
 *
 * @author pavelgulaev
 */
public interface Action<Input, Result> {

    abstract public void action(Input e);

    abstract public Result getResult();
}

