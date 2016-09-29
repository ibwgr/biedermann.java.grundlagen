package Buch.Kapitel8.Aufgabe86;

/**
 * Created by dieterbiedermann on 27.09.16.
 */
public class Zwei {
    public Eins h;
    public Zwei (Eins eins) {
        h = eins;
    }
    public Object clone() {
        return new Zwei(h);
    }
}
