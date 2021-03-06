package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class Franc extends Euro {

    public static final double KURS = 6.55957;

    public Franc(double wert) {
        super(wert/KURS);
    }

    public Franc(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return this.euroBetrag() * KURS;
    }

}
