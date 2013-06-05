package ro.inf.p2.uebung08;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/22/13
 * Time: 12:02 PM
 * Kreis
 */
public class Kreis extends Figur {

    private double radius;

    public Kreis(double radius) {
        super(radius * radius * Math.PI);

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Kreis mit Flaeche: " + super.flaeche;
    }

    @Override
    public void scale(float factor) {
        radius = radius * factor;

        super.flaeche = radius * radius * Math.PI;
    }
}
