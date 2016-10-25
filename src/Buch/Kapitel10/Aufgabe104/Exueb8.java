package Buch.Kapitel10.Aufgabe104;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class Exueb8 {
    /** Bestimme eine Zufallszahl zwischen 0 und 0.5 */
    public static double gibZufallszahlBisEinhalb() throws Exception {
        double res = Math.random();
        if (res > 0.7) {
            throw new TooBigException("Zahl zu gross");
        } else if (res < 0.2) {
            throw new TooSmallException("Zahl zu klein");
        }
        return res;
    }

    /** Hauptprogramm */
    public static void main(String[] args) {
        double zahl;
        // Bestimme eine Zufallszahl zwischen 0 und 0.5
        try {
            zahl = gibZufallszahlBisEinhalb();
        }
        // Falls etwas schief geht (Exception)
        // verwende die Zahl 0.5
        catch(TooBigException e) {
            System.out.println("TooBigException Fehler...");
            zahl = 0.7;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            zahl = 0.2;
        }
        finally {
            // wird immer aufgerufen, auch ohne Fehler !

        }
        // gib die Zahl auf dem Bildschirm aus
        System.out.println(zahl);
    }
}