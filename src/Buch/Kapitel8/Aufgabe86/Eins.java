package Buch.Kapitel8.Aufgabe86;

/**
 * Created by dieterbiedermann on 27.09.16.
 */
public class Eins {
    public long f;
    public static long g = 2;
    public Eins (long f) {
        this.f = f;
    }
    public Object clone() {
        return new Eins(f + g);
    }
}
