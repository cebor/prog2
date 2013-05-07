/*
 * Autwerwaltung.java
 *
 * Created on 28. März 2007, 16:30
 * 
 */
package ro.inf.p2.uebung06.GUIBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ro.inf.p2.uebung06.Auto;

@SuppressWarnings("rawtypes")
/**
 *
 * @author MD nach Vorlagen von Hue
 */
public class AutoVerwaltung {

	private List autos;

	public AutoVerwaltung() {
		autos = new ArrayList();
	}

	@SuppressWarnings("unchecked")
	public String add(Auto a) {
		autos.add(a);
		return a.toString();
	}

	public String clear() {
		autos.clear();
		return ("Alle Autodaten gelöscht!");
	}

	public String list() {
		return toString();
	}

	public String toString() {
		String result = "";
		Iterator it = autos.iterator();
		while (it.hasNext()) {
			Auto a = (Auto) it.next();
			result += a.toString() + "\n";
		}
		return result;
	}
}
