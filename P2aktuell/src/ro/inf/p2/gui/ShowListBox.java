package ro.inf.p2.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 29.02.2004
 * 
 * @author Hue / FdR nach Vorlagen von Sid / Weigend Zweck: einfaches Beispiel
 *         eines GUI-Frameworks Klasse für eine Dialogbox mit varaiabler Anzahl
 *         von Textzeilen und einem Button "Ok"
 *         <p>
 *         <img src="doc-files/ShowListBox.jpg">
 */
public class ShowListBox extends JDialog {
	private static final long serialVersionUID = 1L;
	private DialogController controller = new DialogController();
	private String actioncommand = null;
	private String[] items = null;
	private String title = null;

	/**
	 * @param items
	 *            Array mit Ausgabetext der Labels
	 * @param title
	 *            Titel des Dialogs
	 */
	public ShowListBox(Object[] items, String title) {
		this.items = (String[]) items;
		this.title = title;
		createDialog();
	}

	/**
	 * 
	 * @param items
	 *            Array mit Ausgabetext der Labels
	 */
	public ShowListBox(Object[] items) {
		this.items = (String[]) items;
		createDialog();
	}

	/**
	 * liefert das Ergebnis des Dialogfensters
	 * 
	 * @return gibt Name des Buttons zurück der gedrückt wurde
	 */
	public String getSelectedItem() {
		return actioncommand;
	}

	/**
	 * Der Dialog wird aufgebaut und dann angezeigt
	 */
	private void createDialog() {
		int i;

		Container frame = this.getContentPane();
		this.setTitle(title);

		frame.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel(new GridLayout(items.length, 1));
		panel1.setBorder(new LineBorder(Color.BLACK));
		frame.add(panel1, BorderLayout.CENTER);

		for (i = 0; i < items.length; i++) {
			JLabel label = new JLabel(items[i].toString());
			panel1.add(label);
		}

		JPanel panel2 = new JPanel(new FlowLayout());
		frame.add(panel2, BorderLayout.SOUTH);
		JButton button_ok = new JButton("OK");

		// Listener wird registriert
		button_ok.addActionListener(controller);
		panel2.add(button_ok);

		this.setLocation(20, 20);
		this.setModal(true);
		this.setResizable(false);
		this.pack();
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
