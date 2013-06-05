package ro.inf.p2.uebung08;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/22/13
 * Time: 12:09 PM
 * Rechteck
 */
public class Rechteck extends Figur {
    private double hoehe;
    private double breite;

    public Rechteck(double hoehe, double breite) {
        super(hoehe * breite);

        this.hoehe = hoehe;
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public double getBreite() {
        return breite;
    }

    @Override
    public String toString() {
        return "Rechteck mit Flaeche: " + super.flaeche;
    }

    @Override
    public void scale(float factor) {
        hoehe = hoehe * factor;
        breite = breite * breite;

        super.flaeche = hoehe * breite;
    }
}
