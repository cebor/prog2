package ro.inf.p2.gui.test;

import ro.inf.p2.gui.InputOutputDialog;
import junit.framework.TestCase;

/*
 * Created on 	23.02.2010
 * @author  	MD / BrM nach Vorlagen von Hue / FdR / Sid / Weigend
 * Zweck:		einfaches Beispiel einer Swing-Anwendung mit der Beispiel-GUI
 */
public class Benzin extends TestCase {
	
	public void testBenzin() {
		String[] angaben = new String[3];
		String[] result;

		angaben[0] = "Name";
		angaben[1] = "Verbrauchte Liter";
		angaben[2] = "Gefahrene Kilometer";

		InputOutputDialog dialog = new InputOutputDialog(angaben);
		dialog.setSize(500, 400);
		dialog.setLocation(200, 200);
		double verbrauch;

		do {
			dialog.setVisible(true);
			result = dialog.getSelectedItem();
			if (!result[0].equals("CANCEL") && !result[0].equals("RESET")) {
				dialog.writeOutput("Hallo " + result[0]);
				double liter = Double.parseDouble(result[1]);
				double km = Double.parseDouble(result[2]);
				verbrauch = (liter / km) * 100;
				dialog.writeOutput("Dein Verbrauch liegt bei " + verbrauch);
			}

		} while (result[0] != "CANCEL");
	}
}
