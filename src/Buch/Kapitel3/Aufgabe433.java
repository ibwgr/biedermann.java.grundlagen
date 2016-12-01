package Buch.Kapitel3;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe433 {
    public static void main(String[] args) {
        System.out.print("Anzahl der Zeilen: ");
        int z = IOTools.readInteger();
        int max = 1 + ((z - 1) * 2);
        int center = (max / 2) + 1;
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= max; j++) {
                if (j >= center - i + 1 && j <= center + i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int j = 1; j <= max; j++) {
            if (j == center) {
                System.out.print("I");
            } else {
                System.out.print(" ");
            }
        }
    }
}
