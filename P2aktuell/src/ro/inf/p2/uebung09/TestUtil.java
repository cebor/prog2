/**
 * Created on 	11.05.2010
 * @author Brm nach Vorlagen von Hue / Sid / Weigend
 * Zweck:		JUnit Test f�r Util (statische Methoden f�r Container)
 * letzte �nderung:  08.04.2010 BrM / MD
 */
package ro.inf.p2.uebung09;

import junit.framework.TestCase;

import java.util.*;
import java.util.logging.Logger;

public class TestUtil extends TestCase {
    private static Logger logger = Logger.getLogger(TestUtil.class.getName());

    public void testRemoveLongStrings() {
        Set<String> s = new HashSet<String>(); // Test mit HashSet
        s.addAll(
                Arrays.asList("adam", "eva", "peter", "simon"));
        Util.removeLongStrings(s, 4);
        assertTrue(s.size() == 2);
        Util.removeLongStrings(s, 0);
        assertTrue(s.size() == 0);

        ArrayList<String> al = new ArrayList<String>();
        al.addAll(
                Arrays.asList("adam", "eva", "peter", "simon"));
        Util.removeLongStrings(al, 4);
        assertTrue(al.size() == 2);
        Util.removeLongStrings(al, 0);
        assertTrue(al.size() == 0);

        logger.info("Test Util testRemoveLongStrings erfolgreich!");
    }

    public void testEqualsReverse() {
        List<Object> list1 = new ArrayList<Object>();
        list1.addAll(
                Arrays.asList(
                        new String[]{"wort1", "wort2", "wort3", "wort4", "wort5"}));
        List<Object> list2 = new ArrayList<Object>();
        list2.addAll(
                Arrays.asList(
                        new String[]{"wort5", "wort4", "wort3", "wort2", "wort1"}));

        assertTrue(Util.equals(list2, list2));
        List<Object> list3 = Util.reverse(list1);

        // TODO  // weitere Tests von reverse und equals mit list1, list2, list3
        logger.info("Test Util testEqualReverse erfolgreich!");
    }

}
