package ro.inf.p2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created on 29.02.2004
 * 
 * @author MD nach Vorlagen von Hue / FdR / Sid / Weigend Zweck: Einfaches
 *         Beispiel eines GUI-Frameworks Beispiel aus java.sun.com Tutorial.
 *         Beispiel wird auch in Prg2-Skript verwendet.
 */
public class Button implements ActionListener {

	private static String labelPrefix = "Number of button clicks: ";
	private int numClicks = 0;
	private JLabel label = new JLabel(labelPrefix + "0    ");

	public Component createComponents() {

		JButton button = new JButton("I'm a Swing button!");

		/*
		 * Ausprobieren! Zählen klappt dann auch mit der Tastenkombination Alt-I
		 */
		// button.setMnemonic(KeyEvent.VK_I);

		button.addActionListener(this);
		label.setLabelFor(button);

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		pane.setLayout(new GridLayout(2, 1));
		pane.add(button);
		pane.add(label);
		return pane;
	}

	/**
	 * Implementation of ActionListener interface.
	 */
	public void actionPerformed(ActionEvent event) {
		numClicks++;
		label.setText(labelPrefix + numClicks);
	}

	public static void main(String[] args) {
		// Create the top-level container and add contents to it.
		JFrame frame = new JFrame("SwingApplication");
		Button app = new Button();
		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
