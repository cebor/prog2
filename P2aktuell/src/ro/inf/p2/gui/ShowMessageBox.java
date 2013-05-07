package ro.inf.p2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 29.02.2004
 * 
 * @author Hue / FdR nach Vorlagen von Sid / Weigend Zweck: einfaches Beispiel
 *         eines GUI-Frameworks Klasse für ein Dialogbox mit einer Nachricht und
 *         einem OK-SwingButton
 *         <p>
 *         <img src="doc-files/ShowMessageBox.jpg">
 */
public class ShowMessageBox extends JDialog {
	private static final long serialVersionUID = 1L;
	private DialogController controller = new DialogController();
	private String actioncommand = null;
	private String title = null;

	/**
	 * Konstruktor
	 * 
	 * @param message
	 *            Nachricht die angezeigt wird
	 */
	public ShowMessageBox(String message) {
		createDialog(message);
	}

	/**
	 * Konstruktor
	 * 
	 * @param message
	 *            Nachricht die angezeigt wird
	 * @param title
	 *            Titel des Dialogs
	 */
	public ShowMessageBox(String message, String title) {
		this.title = title;
		createDialog(message);
	}

	/**
	 * Dialog wird aufgebaut und angezeigt
	 * 
	 * @param message
	 *            Nachricht die im Dialog angezeigt wird
	 */
	private void createDialog(String message) {
		Container frame = this.getContentPane();

		frame.setLayout(new GridLayout(2, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		frame.add(panel1);

		JLabel label = new JLabel(message);
		panel1.add(label);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		frame.add(panel2);

		JButton buttonOK = new JButton("OK");

		// Listener wird registriert
		buttonOK.addActionListener(controller);

		panel2.add(buttonOK);

		this.setTitle(title);

		this.setLocation(20, 20);
		this.setModal(true);
		this.setResizable(false);
		this.pack();
	}

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return Text des aktivierten Buttons ("OK")
	 */
	public String getSelectedItem() {
		return actioncommand;
	}

	/**
	 * Wird aufgerufen wenn ein SwingButton aktiviert wurde Aktivierter
	 * SwingButton wird in actioncommand gespeichert.
	 */
	private class DialogController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actioncommand = e.getActionCommand();
			setVisible(false);
		}
	}
}
