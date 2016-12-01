package Buch.Kapitel9.Aufgabe917;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class RunStrecke {
    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(3,3);
        Strecke s = new Strecke(a,b);
        System.out.println(s);

        double drehwinkel = IOTools.readDouble("Drehwinkel: ");
        s.turn(drehwinkel);
        System.out.println(s.getLaenge());
    }
}
