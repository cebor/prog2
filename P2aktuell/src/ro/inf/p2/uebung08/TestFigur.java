package ro.inf.p2.uebung08;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/22/13
 * Time: 12:41 PM
 * TEST
 */
public class TestFigur extends TestCase {

    public void testFigur() {

        Kreis k1 = new Kreis(12);
        Kreis k2 = new Kreis(3.5);
        Kreis k3 = new Kreis(76.32);

        Rechteck r1 = new Rechteck(23, 32);
        Rechteck r2 = new Rechteck(21.32, 43.23);

        Figur[] array = {k1, r1, k2, r2, k3};

        for (Figur entry : array) {
            System.out.println(entry.toString());
        }
    }
}
