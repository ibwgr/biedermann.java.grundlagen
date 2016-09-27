package Test.Pruefung1;

/**
 * Created by dieterbiedermann on 15.09.16.
 */
// Biedermann
// Aufgabe 6
public class Summe {
    public static void main(String[] args) {
        int summer = 0;
        int lowerBound = 1;
        int upperBound = 100;

        for (int i = lowerBound; i <= upperBound; i++) {
            summer = summer + i;
        }

        System.out.println("Summe von " + lowerBound + " bis " + upperBound + " : " + summer);
    }
}
