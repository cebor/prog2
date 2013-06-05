/**
 * Created on 	11.05.2010
 * @author Brm nach Vorlagen von Hue / Sid
 * Zweck:		Beispiel für Umgang mit Collection
 * letzte Änderung:  08.04.2010 BrM / MD
 */
package ro.inf.p2.uebung09;

import java.util.*;

/**
 * Util ist eine Sammlung von nützlichen Funktionen beim Umgang mit
 * Kollektionen und Listen
 */
public abstract class Util {

    /**
     * removeLongString entfernt aus einem Behälter von Strings alle Strings
     * die eine vorgegebene Länge überschreiten.
     *
     * @param coll   Behälter
     * @param maxLen Länge bis zu der die Strings im Behälter bleiben
     */
    public static void removeLongStrings(Collection<String> coll, int maxLen) {
        Iterator<String> i = coll.iterator();

        while (i.hasNext())
            if (i.next().length() > maxLen)
                i.remove();
    }

    /**
     * reverse erstellt eine neue Liste, die alle Elemente von liste1
     * in der umgekehrten Reihenfolge enthält.
     * Der Typ des Resultats ist gleich dem Typ von liste1, falls ein
     * Standardkonstruktor existiert. Im anderen Fall ist das Ergebnis
     * eine ArrayList.
     *
     * @param liste1 umzukehrende Liste
     * @return neue Liste in umgekehrter Reihenfolge
     */
    @SuppressWarnings("unchecked")
    public static List<Object> reverse(List<Object> liste1) {
        List<Object> result = null;
        try {
            result = liste1.getClass().newInstance();
        } catch (Exception e) {
            result = new ArrayList<Object>();
        }

        ListIterator li = liste1.listIterator(liste1.size());

        while (li.hasPrevious())
            result.add(li.previous());

        return result;
    }

    /**
     * reverse1 kehrt die Reihenfolge der Elemente von liste1 um.
     * Es wird keine neue Liste erzeugt.
     *
     * @param liste1 umzukehrende Liste
     */
    public static void reverse1(List<Object> liste1) {
        int i = 0;
        int j = liste1.size() - 1;

        Object tmp;

        while (i < j) {
            tmp = liste1.get(i);
            liste1.set(i, liste1.get(j));
            liste1.set(j, tmp);
        }
    }

    /**
     * equals prueft liste1 und liste2 auf elementweise Gleichheit.
     *
     * @param liste1 erste Liste
     * @param liste2 zweite Liste
     * @return true/false falls Listen gleich/ungleich sind
     */
    public static boolean equals(List<Object> liste1, List<Object> liste2) {

        if (liste1.equals(liste2))
            return true;

        if (liste1.size() != liste2.size())
            return false;

        Iterator<Object> i1 = liste1.iterator();
        Iterator<Object> i2 = liste2.iterator();

        while (i1.hasNext() && i2.hasNext())
            if (i1.next() != i2.next())
                return false;

        return true;
    }

}
