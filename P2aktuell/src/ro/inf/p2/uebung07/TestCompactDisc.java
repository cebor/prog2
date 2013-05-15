/*
 * Created on 	26.04.2011
 * @author  	BrM / MD
 * Zweck:		JUnit Test der Klasse CompactDisc
 */
package ro.inf.p2.uebung07;

import java.util.Arrays;
import java.util.logging.Logger;

import junit.framework.TestCase;

public class TestCompactDisc extends TestCase {
	private CompactDisc cd1;
	private CompactDisc cd2;
	private CompactDisc cd3;
	private CompactDisc cd4;
	private CompactDisc cd5;
	private CompactDisc cd6;
	private CompactDisc cd6a;
	private CompactDisc cd6b;
	private CompactDisc cd7;
	private CompactDisc cd8;

	private static Logger logger = Logger.getLogger(TestCompactDisc.class.getName());

	public void setUp() {
		cd1 = new CompactDisc("lena", "My Cassette Player", 2011, "Universal Music Domestic Pop");
		cd2 = new CompactDisc("Scorpions", "Crazy World", 1990, "Mercury");
		cd3 = new CompactDisc("Die Toten Hosen", "Damenwahl", 1986, "Virgin");
		cd4 = new CompactDisc("Toto", "Toto IV", 1988, "Sony Music");
		cd5 = new CompactDisc("The The", "Soul Mining", 2002, "Epic");
		cd6 = new CompactDisc("The who", "Who'S Next", 1995, "Polydor");
		cd6a = new CompactDisc("The Who", "Who'S Next", 1995, "Polydor");
		cd6b = new CompactDisc("THE who", "Who'S NEXT", 1990, "PolydorOOPS");
		cd7 = new CompactDisc("Die!", "Stigmata", 2006, "Black Bards Entertainment");
		cd8 = new CompactDisc("Die Toten Köpfe", "Herrenqual", 1876, "Gibtsimmernochnicht");
	}

	public void testEquals() {
		assertTrue(cd1.equals(cd1));
		assertTrue(cd4.equals(cd4));
		assertFalse(cd2.equals(cd3));

		assertFalse(cd6.equals(null));
		assertFalse(cd1.equals(new String("Hallo")));

		assertTrue(cd6.equals(cd6a));
		assertTrue(cd6.equals(cd6b));
		logger.info("testEquals erfolgreich");
	}

	public void testToString() {
		logger.info(cd1.toString());
		logger.info(cd2.toString());
		logger.info(cd3.toString());
		logger.info(cd4.toString());
		logger.info(cd5.toString());
		logger.info(cd6.toString());
		logger.info(cd7.toString());
		logger.info("testToString erfolgreich");
	}

	public void testHashCode() {
		assertEquals(cd1.hashCode(), cd1.hashCode());
		assertEquals(cd2.hashCode(), cd2.hashCode());
		assertEquals(cd3.hashCode(), cd3.hashCode());
		assertEquals(cd4.hashCode(), cd4.hashCode());
		assertEquals(cd5.hashCode(), cd5.hashCode());
		assertEquals(cd6.hashCode(), cd6.hashCode());
		assertEquals(cd6a.hashCode(), cd6a.hashCode());
		assertEquals(cd6b.hashCode(), cd6b.hashCode());

		assertEquals(cd6.hashCode(), cd6a.hashCode());
		assertEquals(cd6a.hashCode(), cd6b.hashCode());
		assertEquals(cd7.hashCode(), cd7.hashCode());
		logger.info("testHashCode erfolgreich");
	}

	public void testCompareTo() {
		assertTrue(cd1.compareTo(cd1) == 0);
		assertTrue(cd2.compareTo(cd2) == 0);
		assertTrue(cd3.compareTo(cd3) == 0);
		assertTrue(cd4.compareTo(cd4) == 0);
		assertTrue(cd5.compareTo(cd5) == 0);
		assertTrue(cd6.compareTo(cd6) == 0);
		assertTrue(cd7.compareTo(cd7) == 0);

		assertTrue(cd6.compareTo(cd6a) == 0);
		assertTrue(cd6a.compareTo(cd6b) == 0);
		assertFalse(cd8.compareTo(cd3) == 0);

		assertTrue(cd1.compareTo(cd2) < 0);
		assertTrue(cd2.compareTo(cd1) > 0);
		CompactDisc[] cds = { cd6, cd5, cd4, cd3, cd2, cd1, cd7 };
		Arrays.sort(cds);
		for (int i = 0; i < cds.length; ++i) {
			logger.info(cds[i].toString());
		}
		assertTrue(cds[0] == cd7);
		assertTrue(cds[1] == cd1);
		assertTrue(cds[2] == cd2);
		assertTrue(cds[3] == cd5);
		assertTrue(cds[4] == cd3);
		assertTrue(cds[5] == cd4);
		assertTrue(cds[6] == cd6);
		logger.info("testCompareTo erfolgreich");
	}

	public void testErscheinungsjahrComparator() {
		// einfache Test
        ErscheinungsjahrComparator ec = new ErscheinungsjahrComparator();
        assertTrue(ec.compare(cd1, cd1) == 0);
        assertTrue(ec.compare(cd3, cd3) == 0);
        assertTrue(ec.compare(cd1, cd2) > 0);
        assertTrue(ec.compare(cd2, cd1) < 0);


		// Test mit Arrays.sort
        CompactDisc[] cds = { cd6, cd5, cd4, cd3, cd2, cd1, cd7 };
		Arrays.sort(cds, ec);
        assertTrue(cds[0] == cd3);
        assertTrue(cds[1] == cd4);
        assertTrue(cds[2] == cd2);
        assertTrue(cds[3] == cd6);
        assertTrue(cds[4] == cd5);
        assertTrue(cds[5] == cd7);
        assertTrue(cds[6] == cd1);

		logger.info("testErscheinungsjahrComparator erfolgreich");
	}
}
