package Uebungen.Pizzastore.b;

/**
 * Created by dieterbiedermann on 20.10.16.
 */
public abstract class Pizza {

    public final static int TOMATEN = 1;
    public final static int MOZARELLA = 2;
    public final static int OLIVEN = 3;

    public int[] getZutaten() {
        return new int[5];
    };

    public int getPreis() {
        return 0;
    };
}
