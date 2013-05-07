package ro.inf.p2.gui.test;

import junit.framework.TestCase;
import ro.inf.p2.gui.InputOutputDialog;

/*
 * Created on 	23.02.2010
 * @author  	MD / BrM nach Vorlagen von Hue / FdR / Sid / Weigend
 * Zweck:		einfaches Beispiel einer Swing-Anwendung mit der Beispiel-GUI
 */
public class TestDialog2 extends TestCase {
	public void testInputOutputDialog() {

		String[] list = new String[4];
		list[0] = "Eingabe 1";
		list[1] = "Eingabe 2";
		list[2] = "Eingabe 3";
		list[3] = "Eingabe 4";

		InputOutputDialog dialog = new InputOutputDialog(list);
		dialog.setSize(400, 300);
		dialog.setLocation(250, 200);
		String[] input = null;

		do {
			dialog.setVisible(true);
			input = dialog.getSelectedItem();
			System.out.println("result: ");
			for (int i = 0; i < input.length; i++) {
				System.out.print("Eingabe " + Integer.toString(i + 1) + ": ");
				System.out.println((String) input[i]);
				dialog.writeOutput("Eingabe " + Integer.toString(i + 1) + ": "
						+ (String) input[i]);
			}

		} while (!input[0].equals("CANCEL"));
	}
}
