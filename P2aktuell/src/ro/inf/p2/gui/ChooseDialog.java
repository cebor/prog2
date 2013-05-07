package ro.inf.p2.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created on 23.02.2010
 * 
 * @author MD / BrM nach Vorlagen von Hue / FdR / Sid / Weigend Zweck: einfaches
 *         Beispiel eines GUI-Frameworks Klasse für eine Dialogbox mit variabler
 *         Anzahl von Radiobuttons einem Button "Ok" und einem optionalen Button
 *         "Abbrechen"
 *         <p>
 *         <img src="doc-files/ChooseDialog.jpg">
 */
public class ChooseDialog extends JDialog {
	private static final long serialVersionUID = 1L; // zur serialisierung
	public static final String OK = "OK";
	public static final String ABORT = "Abbrechen";

	private RadioController radiocontroller = new RadioController();
	private DialogController dialogcontroller = new DialogController();
	private String actioncommand = null;
	private Object actionsource = null;
	private String[] items = null;
	private String title = null;

	/**
	 * 
	 * @param items
	 *            Array mit Ausgabetext der Labels
	 */
	public ChooseDialog(Object[] items) {
		this.items = (String[]) items;
		createDialog(false);
	}

	/**
	 * 
	 * @param items
	 *            Array mit Ausgabetext der Labels der Radionbuttons
	 * @param forceSelection
	 *            Nur OK SwingButton vorhanden kein Abbrechen
	 */
	public ChooseDialog(Object[] items, boolean forceSelection) {
		this.items = (String[]) items;
		createDialog(forceSelection);
	}

	/**
	 * 
	 * @param items
	 *            Array mit Ausgabetext der Labels der Radiobuttons
	 * @param title
	 *            Titel des Dialogs
	 */
	public ChooseDialog(Object[] items, String title) {
		this.items = (String[]) items;
		this.title = title;
		createDialog(false);
	}

	/**
	 * 
	 * @param items
	 *            Array mit Ausgabetext der Labels der Radiobuttons
	 * @param title
	 *            Titel des Dialogs
	 * @param forceSelection
	 *            Nur OK SwingButton vorhanden kein Abbrechen
	 */
	public ChooseDialog(Object[] items, String title, boolean forceSelection) {
		this.items = (String[]) items;
		this.title = title;
		createDialog(forceSelection);
	}

	/**
	 * Baut den Dialog auf und zeigt ihn dann an
	 * 
	 * @param forceSelection
	 *            Es wird nur der OK Button angezeigt und kein Abbrechen Button
	 */
	private void createDialog(boolean forceSelection) {
		int i;

		Container frame = this.getContentPane();

		frame.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel(new GridLayout(items.length, 1));
		panel1.setBorder(new LineBorder(Color.BLACK));
		frame.add(panel1, BorderLayout.CENTER);

		ButtonGroup radiogroup = new ButtonGroup();

		for (i = 0; i < items.length; i++) {
			JRadioButton rb = new JRadioButton(items[i].toString());

			// Listener wird registriert
			rb.addActionListener(radiocontroller);

			/* enable first item by default */
			if (i == 0) {
				rb.setSelected(true);
				actioncommand = items[i].toString();
				actionsource = rb;
			} else {
				rb.setSelected(false);
			}

			radiogroup.add(rb);
			panel1.add(rb);
		}

		JPanel panel2 = new JPanel(new FlowLayout());
		frame.add(panel2, BorderLayout.SOUTH);
		JButton button_ok = new JButton(OK);

		// Listener wird registriert
		button_ok.addActionListener(dialogcontroller);
		panel2.add(button_ok);

		if (!forceSelection) {
			JButton button_cancel = new JButton(ABORT);

			// Listener wird registriert
			button_cancel.addActionListener(dialogcontroller);
			panel2.add(button_cancel);
		}

		if (title != null) {
			this.setTitle(title);
		}

		this.setLocation(20, 20);
		this.setModal(true);
		this.setResizable(false);
		this.pack();
	}

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return Das selektierte Object, bei ok
	 * @return String, beim Abbrechen.
	 */
	public Object getSelectedItem() {
		if (!(actionsource instanceof JRadioButton)) {
			// Abbrechen SwingButton wurde gedrueckt
			return actioncommand;
		}

		// OK SwingButton gedrueckt. Gib selektiertes Object zurueck.
		// Die Objects wurden beim Konstruktor uebergeben.
		JRadioButton rb = (JRadioButton) actionsource;
		String s = rb.getText();

		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(s))
				return items[i];
		}
		return null;
	}

	/**
	 * Wird aufgerufen wenn ein RadioButton gedrückt wurde. Der aktivierte
	 * Radiobutton wird gespeichert, da er bei <code>getSelectedItem</code>
	 * benutzt wird
	 */
	private class RadioController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actioncommand = e.getActionCommand();
			actionsource = e.getSource();
		}
	}

	/**
	 * Wird aufgerufen wenn ein SwingButton gedrückt wurde.
	 */
	private class DialogController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand();
			Object as = e.getSource();

			if (ac.equals("OK")) {
				ac = actioncommand;
				as = actionsource;
			} else {
				actioncommand = ac;
				actionsource = as;
			}
			setVisible(false);
		}
	}
}
