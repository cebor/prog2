/*
 * StartProject.java
 *
 * Created on 5. April 2007
 *
 */
package ro.inf.p2.uebung06.GUIBuilder;

/**
 * 
 * @author MD / Hue
 */
public class StartProject {

	/**
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		
		// Das erste Fenster der Anwendung wird geöffnet
		new LoginView().setVisible(true);
	}
}
