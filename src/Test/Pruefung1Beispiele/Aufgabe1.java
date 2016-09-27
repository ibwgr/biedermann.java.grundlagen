package PruefungBeispiele;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 13.09.16.
 */
public class Aufgabe1 {
    public static void main(String[] args) {
        int n;
        n = IOTools.readInteger("Zahl: ");

        for (int i = 3; i < 2 * n; i++) {
            System.out.println((double)1 / (2 * i + 1));
        }

    }

}
