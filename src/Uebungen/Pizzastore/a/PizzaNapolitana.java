package Uebungen.Pizzastore.a;

/**
 * Created by dieterbiedermann on 20.10.16.
 */
public class PizzaNapolitana implements Pizza {

    @Override
    public int[] getZutaten() {
        int[] zutaten = new int[5];
        zutaten[0] = Pizza.TOMATEN;
        zutaten[0] = Pizza.OLIVEN;
        return zutaten;
    }

    @Override
    public int getPreis() {
        return 18;
    }

    @Override
    public String toString() {
        return "Pizza Margherita - Kostet " + getPreis();
    }

}
