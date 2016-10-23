package Buch.Kapitel9.Aufgabe911;

/**
 * Created by dieterbiedermann on 23.10.16.
 */
public class MetallPlatte {
    /** Laenge der Platte */
    public double laenge;

    /** Breite der Platte */
    public double breite;

    /** Konstruktor */
    public MetallPlatte(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;
    }

    /** Berechnet die Flaeche der Platte */
    public double flaeche() {
        return laenge * breite;
    }

    /** Vergleicht das Gewicht dieser Platte mit dem einer anderen MetallPlatte */
    public boolean schwererAls(MetallPlatte p) {
        return (this.flaeche() > p.flaeche());
    }
}
