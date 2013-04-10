/**
 * Created on 	29.02.2004
 * @author MD nach Vorlagen von Hue / FdR / Sid
 * Zweck:		JUnit-Test für Palindrom
 */
package ro.inf.p2.uebung03;

import junit.framework.TestCase;

import java.util.logging.Logger;
//import ro.inf.p2.uebung03.Pali;

/**
 * JUnit-Test für Klasse Pali
 */
public class TestPali extends TestCase {
    // Initialisierung Logger
    private static Logger logger = Logger.getLogger(TestPali.class.getName());

    private String[] testOk = {
            "Otto",
            "Reittier",
            "Ein Neger mit Gazelle zagt im Regen nie.",
            "Reliefpfeiler",
            "Madam, I'm Adam",
            "Risotto, Sir?",
            "Eine treue Familie bei Lima feuerte nie",
            "Liese, tu Gutes, eil!",
            "O Genie, der Herr ehre dein Ego!",
            "Grub Nero nie in Orenburg?",
            "Plaudere, du Alp!",
            "Dogma: I am God."
    };

    private String[] testNotOk = {
            "xy",
            "A b cdxy CBa",
            "Regen",
            "Neger",
            "Irgendein Quatsch",
            "soso"
    };

    public void testPaliOk() {
        for (String entry : testOk) {
            logger.info(entry + "  " + Pali.filter(entry));
            assertTrue(Pali.isPalindrome(entry));
        }
        logger.info("Test PaliOK erfolgreich!");
    }

    public void testPaliNotOk() {
        for (String entry : testNotOk) {
            logger.info(entry + "  " + Pali.filter(entry));
            assertFalse(Pali.isPalindrome(entry));
        }
        logger.info("Test PaliNotOK erfolgreich!");
    }
}
