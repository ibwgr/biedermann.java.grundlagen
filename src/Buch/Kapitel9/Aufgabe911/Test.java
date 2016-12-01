package Buch.Kapitel9.Aufgabe911;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 23.10.16.
 */
public class Test {
    public static void main(String[] args) {

        double laenge = IOTools.readDouble("Metall Platte 1 Laenge: ");
        double breite = IOTools.readDouble("Metall Platte 1 Breite: ");

        MetallPlatte mp1 = new MetallPlatte(laenge, breite);

        laenge = IOTools.readDouble("Metall Platte 2 Laenge: ");
        breite = IOTools.readDouble("Metall Platte 2 Breite: ");

        MetallPlatte mp2 = new MetallPlatte(laenge, breite);

        if (mp1.schwererAls(mp2)) {
            System.out.println("Metall Platte 1 ist schwerer");
        } else if (mp2.schwererAls(mp1)) {
            System.out.println("Metall Platte 2 ist schwerer");
        } else {
            System.out.println("Beide Metall Platten sind gleich schwer");
        }

        GelochtePlatte gp1 = lochen(mp1);
        GelochtePlatte gp2 = lochen(mp2);


        if (gp1.schwererAls(gp2)) {
            System.out.println("Gelochte Platte 1 ist schwerer");
        } else if (gp2.schwererAls(gp1)) {
            System.out.println("Gelochte Platte 2 ist schwerer");
        } else {
            System.out.println("Beide gelochten Platten sind gleich schwer");
        }

    }

    public static GelochtePlatte lochen(MetallPlatte mp) {
        int anzahl;
//        GelochtePlatte gp = (GelochtePlatte) mp;
//        GelochtePlatte gp = new GelochtePlatte(mp.laenge, mp.breite, 1);
        do {
            anzahl = IOTools.readInteger("Anzahl Loecher: ");
        } while (anzahl < 1 || anzahl > 10);

        GelochtePlatte gp = new GelochtePlatte(mp.laenge, mp.breite, anzahl);

        for (int i = 0; i < anzahl; i++) {
            gp.neuesLochStanzen();
        }

        return gp;
    }
}
