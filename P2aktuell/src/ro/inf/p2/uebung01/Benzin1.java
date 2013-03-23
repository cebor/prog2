/*
 * Created on 	29.02.2004
 * @author  	FdR/ Hue / BrM
 * Zweck:		Einfaches Programm mit Ein-/Ausgabe (wie bei C)
 */
package ro.inf.p2.uebung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Benzin1 {
	private final static double UNTERGRENZE = 5;
	private final static double OBERGRENZE = 10;

	public static void main(String[] args)
		throws NumberFormatException, IOException {
		String name;
		double km, liter, verbrauch;
		
		// Die Eingabe ist etwas umständlich
		BufferedReader in =
			new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Bitte Name eingeben: ");
		name = in.readLine();

		System.out.println("Bitte km eingeben: ");
		km = Double.parseDouble(in.readLine());
		System.out.println("Bitte Liter eingeben: ");
		liter = Double.parseDouble(in.readLine());
		verbrauch = liter / km * 100;
		System.out.println("Verbrauch = " + verbrauch);
						
		if (verbrauch > OBERGRENZE)
			System.out.println(name + ", Du bist ein Energieverschwender!!");

		if (verbrauch <= UNTERGRENZE)
			System.out.println(name + ", Du bist ein Schwindler!!");
	}
}
