/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homeworkargus1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pavelgulaev
 */
public class AverageLengthOfWordsInStringTest {
    
    AverageLengthOfWordsInString<CharSequence> instance;
    @Before
    public void setUp() {
        instance = new AverageLengthOfWordsInString<CharSequence>();
    }

    /**
     * Если в action передать null, то средняя длина строки - 0.
     */
    @Test
    public void testActionIfElementNull() {
        CharSequence element = null;
        instance.action(element);
        int res = instance.getResult();
        assertEquals(res, 0);
    }
    
    /**
     * Корректный тест метода action
     */
    @Test
    public void testAction() {
        CharSequence element = "second\t string\n   ";
        instance.action(element);
        int res = instance.getResult();
        assertEquals(res, 6);
    }

    /**
     * Null если не был вызван action(T e) до getResult()
     */
    @Test
    public void testGetResultBeforeCallAction() {
        Integer expResult = null;
        Integer result = instance.getResult();
        assertEquals(expResult, result);
    }
    
    
}
