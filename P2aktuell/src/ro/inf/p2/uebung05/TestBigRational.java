/*
 * Created on 	11.04.2013
 * @author  	BrM / MD nach Vorlagen von Hue / FdR / Sid / Weigend
 * Zweck:		Stichproben-Test der rationalen Zahlen mit JUnit	
 */
package ro.inf.p2.uebung05;

import junit.framework.TestCase;
import java.util.logging.Logger;

/**
 * JUnit-Test für Klasse Rational
 */
public class TestBigRational extends TestCase {

    //	Initialisierung Logger
    private static Logger logger =
        Logger.getLogger(TestBigRational.class.getName());

    public void testConstructors() {

        BigRational r1 = new BigRational();
        assertTrue(r1.getNumerator().longValue() == 0 && r1.getDenominator().longValue() == 1);
        BigRational r2 = new BigRational(1, 2);
        assertTrue(r2.getNumerator().longValue() == 1 && r2.getDenominator().longValue() == 2);
        BigRational r6 = new BigRational(5, -15);
        assertTrue(r6.getNumerator().longValue() == -1 && r6.getDenominator().longValue() == 3);
        r2 = new BigRational(3,6);
        assertTrue(r2.getNumerator().longValue() == 1 && r2.getDenominator().longValue() == 2);
        BigRational r3 = new BigRational(2);
        assertTrue(r3.getNumerator().longValue() == 2 && r3.getDenominator().longValue() == 1);
        BigRational r4 = new BigRational(3.1415);
        assertTrue(r4.getNumerator().longValue() == 6283 && r4.getDenominator().longValue() == 2000);
        logger.info(r4.toString());
        BigRational r7 = new BigRational(2.5);
        assertTrue(r7.getNumerator().longValue() == 5 && r7.getDenominator().longValue() == 2);
        BigRational r5 = new BigRational("1/2");
        assertTrue(r5.getNumerator().longValue() == 1 && r5.getDenominator().longValue() == 2);
        r5 = new BigRational("4/-6");
        logger.info(r5.toString());
        assertTrue(r5.getNumerator().longValue() == -2 && r5.getDenominator().longValue() == 3);
        try {
            r5 = new BigRational("4");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }
        try {
            r5 = new BigRational("4/v");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }
        try {
            r5 = new BigRational("4:6");
            fail();
        } catch (Exception e){
            logger.info("Exception erkannt");
        }

        logger.info("Test Rational testConstructors erfolgreich!");
    }

    public void testArithmetic() {

        BigRational r1 = new BigRational(1, 2);
        BigRational r2 = new BigRational(2, 3);
        BigRational r3 = r1.multiply(r2); // 1/2 * 2/3 = 2/6 (1/3)
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r2.getNumerator().longValue() == 2 && r2.getDenominator().longValue() == 3);
        assertTrue(r3.getNumerator().longValue() == 1 && r3.getDenominator().longValue() == 3);
        BigRational r7 = r1.invert(); // 2/1
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r7.getNumerator().longValue() == 2 && r7.getDenominator().longValue() == 1);
        BigRational r4 = r1.divide(r2); // 1/2 * 3/2 = 3/4
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r2.getNumerator().longValue() == 2 && r2.getDenominator().longValue() == 3);
        assertTrue(r4.getNumerator().longValue() == 3 && r4.getDenominator().longValue() == 4);
        BigRational r5 = r1.add(r2); // 1/2 + 2/3 = 7/6
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r2.getNumerator().longValue() == 2 && r2.getDenominator().longValue() == 3);
        assertTrue(r5.getNumerator().longValue() == 7 && r5.getDenominator().longValue() == 6);
        BigRational r6 = r1.subtract(r2); // 1/2 - 2/3 = -1/6
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r2.getNumerator().longValue() == 2 && r2.getDenominator().longValue() == 3);
        assertTrue(r6.getNumerator().longValue() == -1 && r6.getDenominator().longValue() == 6);
        BigRational r8 = r1.negate(); // -1/2
        assertTrue(r1.getNumerator().longValue() == 1 && r1.getDenominator().longValue() == 2);
        assertTrue(r8.getNumerator().longValue() == -1 && r8.getDenominator().longValue() == 2);
        double d1 = r4.doubleValue();
        assertEquals(d1, 0.75, 0.000001);  // zu vergleichende doubles, Delta

        logger.info("Test Rational testArithmetic erfolgreich!");
    }
}
