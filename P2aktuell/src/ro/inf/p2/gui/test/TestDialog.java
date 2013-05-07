package ro.inf.p2.gui.test;

import ro.inf.p2.gui.*;
import junit.framework.TestCase;

/*
 * Created on 	29.02.2004
 * @author  	Hue / FdR nach Vorlagen von Sid / Weigend
 * Zweck:		einfaches Beispiel einer Swing-Anwendung mit der Beispiel-GUI
 */
public class TestDialog extends TestCase {

	public TestDialog(String s) {
		super(s);
	}

	public void testChooseDialog() {

		String[] strarray = new String[4];
		strarray[0] = "str select 1";
		strarray[1] = "str select 2";
		strarray[2] = "str select 3";
		strarray[3] = "str select 4";

		ChooseDialog dialog1 = new ChooseDialog(strarray, "Test1");
		dialog1.setVisible(true);
		System.out.println("result: " + dialog1.getSelectedItem().toString());

		ChooseDialog dialog2 = new ChooseDialog(strarray, "Hallo", true);
		dialog2.setVisible(true);
		dialog2.setLocation(30, 30);
		System.out.println("result: " + dialog2.getSelectedItem().toString());

	}

	public void testYesNoDialog() {
		YesNoDialog dialog = new YesNoDialog("Neue Spielrunde?", "JA", "NEIN");

		dialog.setVisible(true);
		System.out.println("result: " + dialog.getSelectedItem());
	}

	public void testShowMessageBox() {
		ShowMessageBox dialog = new ShowMessageBox(
				"Schwerer Ausnahmefehler 0E. Bitte starten Sie Window neu.",
				"Exception");

		dialog.setVisible(true);
		System.out.println("result: " + dialog.getSelectedItem());
	}

	public void testShowListBox() {

		String[] strarray = new String[4];
		strarray[0] = "str 1";
		strarray[1] = "str 2";
		strarray[2] = "str 3";
		strarray[3] = "str 4";

		ShowListBox dialog2 = new ShowListBox(strarray, "ShowBox");
		dialog2.setVisible(true);
		System.out.println("result: " + dialog2.getSelectedItem());
	}

	public void testInputTextDialog() {
		InputTextDialog dialog = new InputTextDialog("Eingabefeld", "Text her");

		dialog.setVisible(true);
		System.out.println("result: " + dialog.getSelectedItem());
	}
}
