package ro.inf.p2.uebung08;

/**
 * Created with IntelliJ IDEA.
 * User: felix
 * Date: 5/22/13
 * Time: 11:57 AM
 * Figur
 */
public abstract class Figur {
    protected double flaeche;

    public Figur(double flaeche) {
        this.flaeche = flaeche;
    }

    public double getFlaeche() {
        return flaeche;
    }

    abstract public void scale(float factor);
}
