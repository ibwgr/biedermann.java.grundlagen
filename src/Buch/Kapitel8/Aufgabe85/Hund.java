package Buch.Kapitel8.Aufgabe85;

/**
 * Created by dieterbiedermann on 27.09.16.
 */
public class Hund extends Fuchs {

    // Instanzvariablen
    Maus m = new Maus();            // 3. Maus
    Ratte r = new Ratte();          // 4. Maus, 5. Ratte

    // Konstruktor
    Hund() {
        System.out.println("Hund"); // 6. Hund
    }

    public static void main(String[] args) {
        new Hund();                 // 1. Katze, 2. Fuchs
    }

}
