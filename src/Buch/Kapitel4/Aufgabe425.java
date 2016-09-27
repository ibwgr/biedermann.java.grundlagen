package A4;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe425 {
    public static void main(String[] args) {
        System.out.print("Anzahl der Zeilen: ");
        int z = IOTools.readInteger();
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
