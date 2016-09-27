package A5;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe54 {
    public static void main(String[] args) {
        int count;

        System.out.print("Anzahl Zahlen: ");
        count = IOTools.readInteger();

        int zahlenFeld[] = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print((i+1) + ". Zahl: ");
            zahlenFeld[i] = IOTools.readInteger();
        }

        java.util.Arrays.sort(zahlenFeld);

        for (int i = 0; i < count; i++) {
            System.out.print(zahlenFeld[i] + " ");
        }
    }
}
