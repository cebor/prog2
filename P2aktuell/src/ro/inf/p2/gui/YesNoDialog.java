package ro.inf.p2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 29.02.2004
 * 
 * @author Hue / FdR nach Vorlagen von Sid / Weigend Zweck: einfaches Beispiel
 *         eines GUI-Frameworks Klasse für eine Dialogbox mit einem Text und den
 *         beiden Auswahlknöpfen (Buttons) "yes" und "no"
 *         <p>
 *         <img src="doc-files/YesNoDialog.jpg">
 */
public class YesNoDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public static final String YES = "Ja";
	public static final String NO = "Nein";

	private DialogController controller = new DialogController();
	private String actioncommand = null;
	private String buttonYesLabel = null;
	private String buttonNoLabel = null;
	private String message = null;
	private String title = null;

	/**
	 * @param message
	 *            Nachricht die im Dialog angezeigt werden soll
	 */
	public YesNoDialog(String message) {
		this.message = message;
		createDialog();
	}

	/**
	 * @param message
	 *            Nachricht die im Dialog angezeigt werden soll
	 * @param yes
	 *            Text der auf dem YES SwingButton stehen soll
	 * @param no
	 *            Text der auf dem NO SwingButton stehen soll
	 */
	public YesNoDialog(String message, String yes, String no) {
		this.message = message;
		this.buttonYesLabel = yes;
		this.buttonNoLabel = no;
		createDialog();
	}

	/**
	 * @param message
	 *            Nachricht die im Dialog angezeigt werden soll
	 * @param title
	 *            Titel des Dialogs
	 */
	public YesNoDialog(String message, String title) {
		this.message = message;
		this.title = title;
		createDialog();
	}

	/**
	 * @param message
	 *            Nachricht die im Dialog angezeigt werden soll
	 * @param yes
	 *            Text der auf dem YES SwingButton stehen soll
	 * @param no
	 *            Text der auf dem NO SwingButton stehen soll
	 * @param title
	 *            Titel des Dialogs
	 */
	public YesNoDialog(String message, String yes, String no, String title) {
		this.message = message;
		this.buttonYesLabel = yes;
		this.buttonNoLabel = no;
		this.title = title;
		createDialog();
	}

	/**
	 * Dialog wird aufgebaut und angezeigt
	 */
	private void createDialog() {

		if (this.buttonYesLabel == null) {
			this.buttonYesLabel = new String(YES);
		}
		if (this.buttonNoLabel == null) {
			this.buttonNoLabel = new String(NO);
		}

		Container frame = this.getContentPane();

		frame.setLayout(new GridLayout(2, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		frame.add(panel1);

		JLabel label = new JLabel(this.message);
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		frame.add(panel2);

		JButton buttonYes = new JButton(this.buttonYesLabel);
		JButton buttonNo = new JButton(this.buttonNoLabel);

		// Listener registrieren
		buttonYes.addActionListener(controller);
		buttonNo.addActionListener(controller);

		panel2.add(buttonYes);
		panel2.add(buttonNo);

		this.setTitle(title);

		this.setLocation(20, 20);
		this.setModal(true);
		this.setResizable(false);
		this.pack();
	}

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return gibt den Text des aktivierten SwingButton zurück
	 */
	public String getSelectedItem() {
		return actioncommand;
	}

	/**
	 * Wird aufgerufen wenn ein SwingButton aktiviert wurde und speichert diesen
	 */
	private class DialogController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actioncommand = e.getActionCommand();
			setVisible(false);
		}
	}
}
