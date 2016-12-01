package A5;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe55 {
    public static void main(String[] args) {
        int n = 0;

        while (n < 2 || n > 10 || n % 2 == 0) {
            System.out.print("Quadrat Groesse: ");
            n = IOTools.readInteger();
        }

        int[][] quad = new int[n][n];
        int zeile = n / 2;
        int spalte = n  / 2 + 1;

        for (int i = 1; i <= (n * n); i++) {
            quad[zeile][spalte] = i;
            zeile--;
            spalte++;
            if (zeile < 0) {
                zeile = n - 1;
            }
            if (spalte == n) {
                spalte = 0;
            }
            if (quad[zeile][spalte] != 0) {
                zeile++;
                spalte++;
                if (zeile == n) {
                    zeile = 0;
                }
                if (spalte == n) {
                    spalte = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int zahl = quad[i][j];
                System.out.print((zahl > 9 ? " " : "  ") + zahl);
            }
            System.out.println();
        }
    }
}
