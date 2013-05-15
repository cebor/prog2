/*
 * Created on 	26.04.2011
 * @author  	BrM / MD
 * Zweck:		JUnit Test der Klasse InterpretTitelComparator
 */
package ro.inf.p2.uebung07;

import java.util.Arrays;
import java.util.logging.Logger;

import junit.framework.TestCase;

public class TestInterpretTitelComparator extends TestCase {
	private CompactDisc cd1;
	private CompactDisc cd2;
	private CompactDisc cd3;
	private CompactDisc cd4;
	private CompactDisc cd5;

	private static Logger logger = Logger.getLogger(TestInterpretTitelComparator.class.getName());

	public void setUp() {
		cd1 = new CompactDisc("Lena", "My Cassette Player", 2011, "Universal Music Domestic Pop");
		cd2 = new CompactDisc("Scorpions", "Crazy World", 1990, "Mercury");
		cd3 = new CompactDisc("Die Toten Hosen", "Damenwahl", 1986, "Virgin");
		cd4 = new CompactDisc("Toto", "Toto IV", 1988, "Sony Music");
		cd5 = new CompactDisc("The Who", "Who'S Next", 1995, "Polydor");
	}

	public void testInterpretTitelComparator() {
		CompactDisc cd3a = new CompactDisc("Die Toten Hosen", "Auf dem Kreuzzug ins Glück", 1990, "Virgin");
		CompactDisc cd3b = new CompactDisc("Die Toten Hosen", "Unter Falscher Flagge", 1984, "T.O.T. Musik");
		CompactDisc cd3c = new CompactDisc("Die Toten Hosen", "Opium fürs Volk", 1996, "JKP");

		// einfache Test
		InterpretTitelComparator itc = new InterpretTitelComparator();
		assertTrue(itc.compare(cd1, cd1) == 0);
		assertTrue(itc.compare(cd3, cd3) == 0);
		assertTrue(itc.compare(cd1, cd2) < 0);
		assertTrue(itc.compare(cd2, cd1) > 0);

		assertTrue(itc.compare(cd3, cd3a) > 0);
		assertTrue(itc.compare(cd3, cd3b) < 0);
		assertTrue(itc.compare(cd3a, cd3b) < 0);
		assertTrue(itc.compare(cd3a, cd3c) < 0);
		assertTrue(itc.compare(cd3c, cd3a) > 0);

		// Test mit Arrays.sort
		CompactDisc[] cds = { cd3b, cd5, cd4, cd3a, cd3, cd2, cd3c, cd1 };
		Arrays.sort(cds, itc);
		for (int i = 0; i < cds.length; ++i) {
			logger.info(cds[i].toString());
		}
		assertTrue(cds[0] == cd1);
		assertTrue(cds[1] == cd2);
		assertTrue(cds[2] == cd3a);
		assertTrue(cds[3] == cd3);
		assertTrue(cds[4] == cd3c);
		assertTrue(cds[5] == cd3b);
		assertTrue(cds[6] == cd4);
		assertTrue(cds[7] == cd5);
		logger.info("testInterpretTitelComparator erfolgreich");
	}
}
