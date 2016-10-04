package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class Lire extends Euro {

    public Lire(double wert) {
        super(wert/1936.27);
    }

    public Lire(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return this.euroBetrag() * 1936.27;
    }

}
