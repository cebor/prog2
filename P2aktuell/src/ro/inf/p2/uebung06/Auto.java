/*
 * Created on 17.03.2004
 *
 */
package ro.inf.p2.uebung06;

import java.io.Serializable;

/**
 * Klasse Auto als einfache Beispielklasse für ein Projekt
 * 
 */
public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;
	private final static int AKTUELLES_JAHR = 2009;
	private String name;
	private int erstzulassung;
	private int leistung;
	private double verbrauch;

	public Auto(String name, int erstzulassung, int leistung) {
		this.name = name;
		this.erstzulassung = erstzulassung;
		this.leistung = leistung;
	};

	public void setVerbrauch(double verbrauch) {
		this.verbrauch = verbrauch;
	}

	public double getVerbrauch() {
		return verbrauch;
	}

	public int alter() {
		return AKTUELLES_JAHR - erstzulassung;
	}

	public void berechneVerbrauch(double km, double liter) {
		verbrauch = liter / km * 100;
	}

	public String toString() {
		return ("Auto: " + name + " Baujahr " + erstzulassung + " Leistung "
				+ leistung + "KW");
	}

}
