/*
 * Created on 	9.03.2005
 * @author  	FdR
 * Zweck:		Einfacher JUnit-Test der Klasse Service mit Zufallszahlen
 */
package ro.inf.p2.uebung01;

import junit.framework.TestCase;

public class TestService extends TestCase {

	final public void testAdd() {
		final int anzahlTests = 100;
		int a, b;
		Service service = new Service();
		for (int i = 0; i < anzahlTests; i++) {
			//	Summanden als Zufallszahlen zwischen 1 und 1000 ermitteln
			a = (int) (Math.random() * 1000 + 1);
			b = (int) (Math.random() * 1000 + 1);
			assertEquals(service.add(a, b), (a + b ));
			System.out.println(i +": " + a + "+" + b + "=" + service.add(a, b));
		}
	}
}