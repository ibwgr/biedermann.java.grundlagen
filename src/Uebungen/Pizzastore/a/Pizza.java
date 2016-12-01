package Uebungen.Pizzastore.a;

/**
 * Created by dieterbiedermann on 20.10.16.
 */
public interface Pizza {

    int TOMATEN = 1;
    int MOZARELLA = 2;
    int OLIVEN = 3;

    int[] getZutaten();

    int getPreis();
}
