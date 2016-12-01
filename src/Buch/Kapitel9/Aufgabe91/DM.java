package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class DM extends Euro {

    public static final double KURS = 1.95583;

    public DM(double wert) {
        super(wert/KURS);
    }

    public DM(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return this.euroBetrag() * KURS;
    }

}
