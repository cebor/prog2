package ro.inf.p2.uebung02;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 4/3/13
 * Time: 10:38 AM
 */
public class WechselnTest extends TestCase {
    public void testAnzahl() throws Exception {

        int betrag = 317;
        int[] erg = {1, 1, 0, 0, 1, 1, 1, 0};
        int[] array = Wechseln.anzahl(betrag);

        assertTrue(Arrays.equals(erg, array));


        betrag = 783;
        erg = new int[] {3, 1, 1, 1, 1, 0, 1, 1};
        array = Wechseln.anzahl(betrag);

        assertTrue(Arrays.equals(erg, array));
    }
}
