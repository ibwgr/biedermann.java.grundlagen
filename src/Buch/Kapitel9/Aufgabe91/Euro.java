package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class Euro extends Waehrung {

    /**
     * Ein Euro ist soviel Dollar wert
     */
    private static double kurs = 1;


    /**
     * Instanzvariable: Wert in Euro
     */
    private double wert;

    /**
     * Konstruktor
     */
    public Euro(double wert) {
        this.wert = wert;
    }

    /**
     * Deklaration der sonst abstrakten Methode dollarBetrag
     */
    public double dollarBetrag() {
        return wert * kurs;
    }

    /**
     * Gibt den Wert der Waehrung in Euro zurueck
     */
    public double euroBetrag() {
        return wert;
    }

    /**
     * Zugriff auf die private Klassenvariable
     */
    public static void setEuroKurs(double Kurs) {
        kurs = Kurs;
    }

    /**
     * Prueft, ob das Objekt gleich dem Parameter-Objekt obj ist
     */
    public boolean equals(Object obj) {
        if (obj == null) // Vergleich mit null-Referenz
            return false;
        if (obj == this) // Vergleich mit sich selber
            return true;
        if (!obj.getClass().equals(getClass())) // Datentyp-Vergleich
            return false;
        Waehrung that = (Waehrung) obj; // Typecast und Inhalts-
        return this.dollarBetrag() == that.dollarBetrag(); // Vergleich }
    }

}