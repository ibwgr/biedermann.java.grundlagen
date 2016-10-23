package Uebungen.Pizzastore.b;

/**
 * Created by dieterbiedermann on 20.10.16.
 */
public class PizzaMargherita extends Pizza {
    private int groesse;

    protected static final int KLEIN = 1;
    protected static final int MITTEL = 2;
    protected static final int GROSS = 3;

    PizzaMargherita(int groesse) {
        this.groesse = groesse;
    }

    @Override
    public int[] getZutaten() {
        int[] zutaten = new int[5];
        zutaten[0] = Pizza.TOMATEN;
        zutaten[0] = Pizza.MOZARELLA;
        return zutaten;
    }

    @Override
    public int getPreis() {
        int preis;

        switch (groesse) {
            case MITTEL: preis = 12; break;
            case GROSS: preis = 15; break;
            default: preis = 10;
        }
        return preis;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getGroesse() {
        return this.groesse;
    }

    @Override
    public String toString() {
        String str;
        switch (groesse) {
            case KLEIN: str = "klein"; break;
            case MITTEL: str = "klein"; break;
            case GROSS: str = "gross"; break;
            default: str = "unbekannte Grösse";
        }
        return "Pizza Margherita (" + str + ") - Kostet " + getPreis();
    }
}
