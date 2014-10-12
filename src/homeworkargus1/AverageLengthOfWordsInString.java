package homeworkargus1;

/** Вычисляет среднюю длину слов в строке, результат Integer
 * 
 *  
 * @author pavelgulaev
 * @param <T> строка
 */
class AverageLengthOfWordsInString<T extends CharSequence> implements Action<T, Integer> {

    private Integer res = null;

    /** Находит среднюю длину слова в элементе
     * Если элемент - null, то результат = 0
     * 
     * @param element элемент для анализа 
     */
    @Override
    public void action(T element) {
        if (element==null) {res=0; return; }
        String elementToString = element.toString();
        //удаляет все whitespace символы
        String[] words = elementToString.split("\\W+");
        int numberOfWords = words.length;
        int lengthOfWords = 0;
        for (int i = 0; i < numberOfWords; i++) {
            lengthOfWords += words[i].length();
        }
        res = lengthOfWords / numberOfWords;
    }

    /** Возвращает среднюю длину в строке, для корректной работы должен вызываться после action
     * 
     * @return средняя длина слова в строке или null, если getResult() был вызван до action(T element)
     */
    @Override
    public Integer getResult() {
        return res;
    }
}
