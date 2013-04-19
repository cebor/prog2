/*
 * Created on 	11.04.2013
 * @author  	BrM / MD nach Vorlagen von Hue / FdR / Sid / Weigend
 * Zweck:		Stichproben-Test der rationalen Zahlen mit JUnit	
 */
package ro.inf.p2.uebung04;

import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 * JUnit-Test für Klasse Rational
 */
public class TestRational extends TestCase {

    //	Initialisierung Logger
    private static Logger logger =
        Logger.getLogger(TestRational.class.getName());

    public void testConstructors() {

        Rational r1 = new Rational();
        assertTrue(r1.getNumerator() == 0 && r1.getDenominator() == 1);
        Rational r2 = new Rational(1, 2);
        assertTrue(r2.getNumerator() == 1 && r2.getDenominator() == 2);
        Rational r6 = new Rational(5, -15);
        assertTrue(r6.getNumerator() == -1 && r6.getDenominator() == 3);
        r2 = new Rational(3,6);
        assertTrue(r2.getNumerator() == 1 && r2.getDenominator() == 2);
        Rational r3 = new Rational(2);
        assertTrue(r3.getNumerator() == 2 && r3.getDenominator() == 1);
        Rational r4 = new Rational(3.1415);
        assertTrue(r4.getNumerator() == 6283 && r4.getDenominator() == 2000);
        logger.info(r4.toString());
        Rational r7 = new Rational(2.5);
        assertTrue(r7.getNumerator() == 5 && r7.getDenominator() == 2);
        Rational r5 = new Rational("1/2");
        assertTrue(r5.getNumerator() == 1 && r5.getDenominator() == 2);
        r5 = new Rational("4/-6");
        logger.info(r5.toString());
        assertTrue(r5.getNumerator() == -2 && r5.getDenominator() == 3);
        try {
            r5 = new Rational("4");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }
        try {
            r5 = new Rational("4/v");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }
        try {
            r5 = new Rational("4:6");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }

        logger.info("Test Rational testConstructors erfolgreich!");
    }

    public void testArithmetic() {

        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        Rational r3 = r1.multiply(r2); // 1/2 * 2/3 = 2/6 (1/3)
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r2.getNumerator() == 2 && r2.getDenominator() == 3);
        assertTrue(r3.getNumerator() == 1 && r3.getDenominator() == 3);
        Rational r7 = r1.invert(); // 2/1
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r7.getNumerator() == 2 && r7.getDenominator() == 1);
        Rational r4 = r1.divide(r2); // 1/2 * 3/2 = 3/4
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r2.getNumerator() == 2 && r2.getDenominator() == 3);
        assertTrue(r4.getNumerator() == 3 && r4.getDenominator() == 4);
        Rational r5 = r1.add(r2); // 1/2 + 2/3 = 7/6
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r2.getNumerator() == 2 && r2.getDenominator() == 3);
        assertTrue(r5.getNumerator() == 7 && r5.getDenominator() == 6);
        Rational r6 = r1.subtract(r2); // 1/2 - 2/3 = -1/6
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r2.getNumerator() == 2 && r2.getDenominator() == 3);
        assertTrue(r6.getNumerator() == -1 && r6.getDenominator() == 6);
        Rational r8 = r1.negate(); // -1/2
        assertTrue(r1.getNumerator() == 1 && r1.getDenominator() == 2);
        assertTrue(r8.getNumerator() == -1 && r8.getDenominator() == 2);
        double d1 = r4.doubleValue();
        assertEquals(d1, 0.75, 0.000001);  // zu vergleichende doubles, Delta

        logger.info("Test Rational testArithmetic erfolgreich!");
    }

}
