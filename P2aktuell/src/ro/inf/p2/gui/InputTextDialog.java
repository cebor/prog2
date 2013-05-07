package ro.inf.p2.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 * Created on 29.02.2004
 * 
 * @author MD nach Vorlagen von Hue / FdR / Sid / Weigend Zweck: einfaches
 *         Beispiel eines GUI-Frameworks Klassse für einen Dialog mit einem
 *         Eingabefeld und zwei Auswahlknöpfe (Buttons) OK und Abrechen
 *         <p>
 *         <img src="doc-files/InputTextDialog.jpg">
 */
public class InputTextDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public static final String OK = "OK";
	public static final String CANCEL = "Abbrechen";

	private DialogController controller = new DialogController();

	private String inputText = null;
	private JTextField textField;
	private String message;
	private String title = null;

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return Eingabetext oder "Abbrechen"
	 */
	public String getSelectedItem() {
		return inputText;
	}

	/**
	 * Creates a non-modal dialog without a title
	 * 
	 * @exception HeadlessException
	 *                if GraphicsEnvironment.isHeadless() returns true.
	 * @see GraphicsEnvironment#isHeadless
	 * @see JComponent#getDefaultLocale
	 */
	public InputTextDialog(String message) throws HeadlessException {
		this.message = message;
		createDialog();
	}

	/**
	 * Creates a non-modal dialog without a title
	 * 
	 * @exception HeadlessException
	 *                if GraphicsEnvironment.isHeadless() returns true.
	 * @param title
	 *            Titel für den Dialog
	 * @see GraphicsEnvironment#isHeadless
	 * @see JComponent#getDefaultLocale
	 */
	public InputTextDialog(String message, String title)
			throws HeadlessException {
		this.message = message;
		this.title = title;
		createDialog();
	}

	/**
	 * Der Dialog wird aufgebaut und dann angezeigt
	 */
	private void createDialog() {

		Container frame = this.getContentPane();

		frame.setLayout(new GridLayout(2, 1));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		frame.add(panel1);

		JLabel label = new JLabel(this.message);
		textField = new JTextField(12);
		panel1.add(label);
		panel1.add(textField);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		frame.add(panel2);

		JButton buttonYes = new JButton(OK);
		JButton buttonNo = new JButton(CANCEL);

		/*
		 * Es werden sog. Listener registriert, damit bei Buttondruck die
		 * Methode Dialog aufgerufen wird
		 */
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
	 * Methode wird aufgerufen wenn ein SwingButton gedrückt wurde Bei OK wird
	 * der EingabeText zurückgegeben Bei Cancel wird "CANCEL" zurückgegeben
	 */
	private class DialogController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand();

			if (ac.equals(OK)) {
				inputText = textField.getText();
			} else {
				inputText = CANCEL;
			}

			setVisible(false);
		}
	}
}
