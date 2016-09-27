package A4;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe426 {
    public static void main(String[] args) {
        int z;
        int m = 1;
        int d = 0;
        int sum = 0;
        while (d < 1 || d > 9999) {
            System.out.print("Positive ganze Zahl eingeben: ");
            d = IOTools.readInteger();
        }
        System.out.print("Die Quersumme ergibt sich zu: ");
        while (d > 0) {
            z = d % 10;
            d /= 10;
            sum += z;
            System.out.print((m > 1 ? " + " : "") + z);
            m *= 10;
        }
        System.out.println(" = " + sum);
    }
}
