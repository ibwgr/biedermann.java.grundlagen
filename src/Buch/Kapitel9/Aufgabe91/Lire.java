package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class Lire extends Euro {

    public static final double KURS = 1936.27;

    public Lire(double wert) {
        super(wert/KURS);
    }

    public Lire(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return this.euroBetrag() * KURS;
    }

}
