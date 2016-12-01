package Buch.Kapitel3;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe432 {
    public static void main(String[] args) {
        long b = 0;
        int m = 1;
        short d;

        System.out.print("Dezimalzahl: ");
        d = IOTools.readShort();

        while (d > 0) {
            b += (d % 2) * m;
            d /= 2;
            m *= 10;
        }
        System.out.println("als Binaerzahl: " + b);
    }
}
