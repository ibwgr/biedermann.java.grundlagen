package Buch.Kapitel11.Aufgabe115;

/**
 * Created by dieterbiedermann on 01.11.16.
 */
public class Tierleben {
    public static <T> void gibAus(T tier) {
        System.out.println("Unbekannt: " + tier);
    }
    public static <T extends Tier> void gibAus(T tier) {
        System.out.println("Tier: " + tier);
    }
    public static <T extends Haustier> void gibAus(T tier) {
        System.out.println("Haustier: " + tier);
    }

    public static void main(String[] args) {
        gibAus("Amoebe");
        gibAus(new Katze());
        gibAus(new Hauskatze());
        gibAus(new Wildkatze());
    }
}
