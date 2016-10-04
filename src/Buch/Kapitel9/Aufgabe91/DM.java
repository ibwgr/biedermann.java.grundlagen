package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class DM extends Euro {

    public DM(double wert) {
        super(wert/1.95583);
    }

    public DM(Euro euro) {
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag() {
        return this.euroBetrag() * 1.95583;
    }

}
