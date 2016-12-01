package Buch.Kapitel9.Aufgabe914;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class Sandwich extends Vesper {
    Brot b = new Brot();
    Wurst w = new Wurst();
    Salat s = new Salat();
    public Sandwich() {
        System.out.println("Sandwich()");
    }
    public static void main(String[] args) {
        new Sandwich();
    }
}
