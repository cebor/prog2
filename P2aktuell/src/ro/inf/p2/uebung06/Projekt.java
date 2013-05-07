package ro.inf.p2.uebung06;

import ro.inf.p2.gui.InputOutputDialog;
import ro.inf.p2.gui.YesNoDialog;

/**
 * @author MD / BrM nach Vorlage von Hue Date: 23.04.2010
 *         <p>
 *         Einfache Beipiel Anwendung für ein Projekt
 *         <p>
 *         Achtung: Es fehlen Überprüfungen bei falschen Eingaben
 * 
 */
public class Projekt {

	public static void main(String[] args) {
		Auto auto1 = null;

		// Erste GUI zur Eingabe der Autodaten
		String[] autoDaten = new String[3];
		autoDaten[0] = "Marke / Typ";
		autoDaten[1] = "Erstzulassung";
		autoDaten[2] = "Leistung (KW)";
		String[] result1;

		InputOutputDialog dialog = new InputOutputDialog(autoDaten);
		dialog.setSize(500, 400);
		dialog.setLocation(200, 200);

		dialog.setVisible(true);
		result1 = dialog.getSelectedItem();

		// Auswertung der Autodaten
		if (!result1[0].equals("CANCEL") && !result1[0].equals("RESET")) {
			// Abspeichern der Eingaben in einem Objekt Auto
			auto1 = new Auto(result1[0], Integer.parseInt(result1[1]),
					Integer.parseInt(result1[2]));
			dialog.writeOutput(auto1.toString());
			dialog.setVisible(true);
			result1 = dialog.getSelectedItem();
		}

		// Zweite GUI
		YesNoDialog yndialog = new YesNoDialog("Weiter?", "JA", "NEIN");
		yndialog.setLocation(300, 300);
		yndialog.setVisible(true);
		if (yndialog.getSelectedItem().equals("NEIN"))
			return;

		// Dritte GUI zur Berechnung des Verbrauchs
		String[] angaben = new String[2];
		angaben[0] = "Verbrauchte Liter";
		angaben[1] = "Gefahrene Kilometer";
		String[] result2;

		dialog = new InputOutputDialog(angaben);
		dialog.setSize(500, 400);
		dialog.setLocation(200, 200);
		double verbrauch;

		do {
			dialog.setVisible(true);
			result2 = dialog.getSelectedItem();
			if (!result2[0].equals("CANCEL") && !result2[0].equals("RESET")) {
				double liter = (double) Integer.parseInt(result2[0]);
				double km = (double) Integer.parseInt(result2[1]);
				verbrauch = (liter / km) * 100;
				if (auto1 != null)
					// Abspeichern der Berechnung im Objekt Auto
					auto1.setVerbrauch(verbrauch);
				dialog.writeOutput("Dein Verbrauch liegt bei " + verbrauch);
			}
		} while (result2[0] != "CANCEL");
	}
}
