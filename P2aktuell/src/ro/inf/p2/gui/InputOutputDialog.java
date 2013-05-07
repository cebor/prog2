package ro.inf.p2.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created on 23.02.2010
 * 
 * @author MD / BrM nach Vorlagen von Hue Zweck: Klasse für eine Dialogbox mit
 *         drei Bereichen: eine variable Anzahl von Eingabefeldern mit Label,
 *         drei Buttons (OK, REST, Abbrechen) und ein Ausgabebereich
 */
public class InputOutputDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	public static final String OK = "    OK    ";
	public static final String CANCEL = "  Abbrechen  ";
	public static final String RESET = "    Reset    ";

	private InputOutputDialog.DialogController controller = new InputOutputDialog.DialogController();

	private String[] labels = null;
	private JTextField[] textFields = null;
	private String[] inputText = null;
	private Container frame = null;
	private JTextArea area1 = null;
	private boolean textisset = false;

	/**
	 * @param items
	 *            Array mit Ausgabetext der Labels
	 * @throws HeadlessException
	 */
	public InputOutputDialog(String[] items) throws HeadlessException {
		this.labels = items;
		createDialog();
	}

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return Gibt wenn nicht abgebrochen wurde die textfields zurück Bei
	 *         Schliessen des Fensters(Rechts oben mit X) wird auch CANCEL
	 *         zurückgegeben
	 */
	public String[] getSelectedItem() {
		if (textisset == false) {
			inputText = new String[1];
			inputText[0] = "CANCEL";
		}
		textisset = false;
		return inputText;
	}

	/**
	 * Schreibt eine Zeile auf die TextArea
	 * 
	 * @param text
	 *            der zu schreibende Text
	 */
	public void writeOutput(String text) {
		area1.append(text + "\n");
	}

	/**
	 * Baut den Dialog auf und zeigt ihn an
	 */
	private void createDialog() {
		frame = this.getContentPane();
		frame.setLayout(new BorderLayout(2, 2));
		JPanel pInput = new JPanel(new BorderLayout(2, 2));
		pInput.setBorder(new LineBorder(Color.BLACK));
		frame.add(pInput, BorderLayout.NORTH);

		JPanel pInputLabel = new JPanel(new GridLayout(labels.length, 1, 2, 2));
		pInputLabel.setBorder(new EmptyBorder(2, 5, 0, 0));
		pInput.add(pInputLabel, BorderLayout.CENTER);

		JPanel pInputButton = new JPanel(new BorderLayout(2, 2));
		pInputButton.setBorder(new EmptyBorder(0, 0, 2, 2));
		pInput.add(pInputButton, BorderLayout.EAST);

		JPanel pButtonLayoutSouth = new JPanel(new GridLayout(2, 1, 2, 2));
		pInputButton.add(pButtonLayoutSouth, BorderLayout.SOUTH);

		textFields = new JTextField[labels.length];

		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i].toString());
			textFields[i] = new JTextField();
			pInputLabel.add(label);
			pInputLabel.add(textFields[i]);
		}

		JButton buttonYes = new JButton(OK);
		buttonYes.setBorder(new BevelBorder(BevelBorder.RAISED));
		JButton buttonNo = new JButton(CANCEL);
		buttonNo.setBorder(new BevelBorder(BevelBorder.RAISED));
		JButton buttonReset = new JButton(RESET);
		buttonReset.setBorder(new BevelBorder(BevelBorder.RAISED));

		pButtonLayoutSouth.add(buttonYes);
		pButtonLayoutSouth.add(buttonReset);

		buttonYes.addActionListener(controller);
		buttonNo.addActionListener(controller);
		buttonReset.addActionListener(controller);

		area1 = new JTextArea();
		area1.setLineWrap(true);
		JScrollPane panel4 = new JScrollPane(area1);
		frame.add(panel4, BorderLayout.CENTER);

		JPanel pEnd = new JPanel();
		pEnd.setLayout(new BorderLayout());
		pEnd.add(buttonNo, BorderLayout.EAST);
		frame.add(pEnd, BorderLayout.SOUTH);

		this.setModal(true);
		this.setResizable(false);
		this.pack();
	}

	/**
	 * Wird aufgerufen wenn ein SwingButton aktiviert wurde Bei OK werden die
	 * Eingabetexte zurückgegeben Bei RESET werden alle Eingabefelder gelöscht
	 * und RESET zurückgegeben Bei CANCEL wird CANCEL zruückgegeben
	 */
	private class DialogController implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String ac = e.getActionCommand();

			if (ac.equals(OK)) {
				inputText = new String[labels.length];
				for (int i = 0; i < labels.length; i++) {
					inputText[i] = textFields[i].getText();
				}
			} else if (ac.equals(RESET)) {
				for (int i = 0; i < textFields.length; i++) {
					textFields[i].setText("");
				}
				inputText = new String[1];
				inputText[0] = "RESET";
			} else {
				inputText = new String[1];
				inputText[0] = "CANCEL";
			}
			textisset = true;
			setVisible(false);
		}
	}
}
