package Buch.Kapitel8.Aufgabe86;

/**
 * Created by dieterbiedermann on 27.09.16.
 */
public class TestZwei {
    public static void main (String[] args) {
        Eins e1 = new Eins(1), e2;
        Zwei z1 = new Zwei(e1), z2;
        System.out.print (Eins.g + "-");
        System.out.println(z1.h.f);
        e2 = (Eins) e1.clone();
        z2 = (Zwei) z1.clone();
        e1.f = 4;
        Eins.g = 5;
        System.out.print (e2.f + "-");
        System.out.print (e2.g + "-");
        System.out.print (z1.h.f + "-");
        System.out.print (z2.h.f + "-");
        System.out.println(z2.h.g);
    }
}
