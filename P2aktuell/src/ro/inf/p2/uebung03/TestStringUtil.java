/**
 * Created on 	18.03.2010
 * @author  	MD,BrM nach Vorlagen von Hue / FdR / Sid / Weigend
 * Zweck:		JUnit-Test für Stringoperationen	
 */
package ro.inf.p2.uebung03;

import junit.framework.TestCase;
import java.util.Arrays;
import java.util.logging.Logger;
//import ro.inf.p2.uebung03.StringUtil;


public class TestStringUtil extends TestCase {

    private String testString = null;
    private String testString2 = null;
    private char[] testCharArr = {'H','a','l','l','o'};

    private static Logger logger = Logger.getLogger(StringUtil.class.getName());

    public TestStringUtil(String name) {
        super(name);
    }

    public void setUp() {
        testString = "otto hugo rudi";
        testString2 = "Hallo";
    }

    public void testChars() {
        char[] carr = StringUtil.string2CharArray(testString);
        String t = StringUtil.charArray2String(carr);
        assertEquals(testString, t);
        
        carr = StringUtil.string2CharArray(testString2);
        for (int i = 0; i < carr.length; i++)
        	assertTrue(carr[i] == testCharArr[i]);   
        assertTrue(Arrays.equals(carr,testCharArr));
        
        t = StringUtil.charArray2String(testCharArr);
        assertTrue(t.equals(testString2));
        
        logger.info("testChars erfolgreich! ");
    }
}