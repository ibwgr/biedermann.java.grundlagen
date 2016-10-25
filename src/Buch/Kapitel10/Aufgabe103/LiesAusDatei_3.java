package Buch.Kapitel10.Aufgabe103;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
import java.io.*;
import Prog1Tools.*;
public class LiesAusDatei_3 {

    // Methode zum Pruefen, ob der Unicode-int-Wert z eine Ziffer
    // darstellt. Ist dies der Fall, wird eine Exception geworfen.
    public static void check(int z) throws DigitException {
        if (z >= '0' && z <= '9') {
            DigitException de = new DigitException("Es ist eine Zahl!");
            throw de;
        }
    }

    public static void main(String[] args) {
        try {
            // Lies den Dateinamen ein:
            String dateiname = IOTools.readString("Dateiname: ");

            // Oeffne die Datei zum Lesen:
            FileReader dateileser = new FileReader(dateiname);

            // Lies alle Zeichen aus der Datei ein (read liefert int)
            // bis das Dateiende erreicht wird (signalisiert durch -1)
            // und gib sie (wieder als Buchstabe) auf den Bildschirm aus:

            System.out.println("In der Datei " + dateiname + " steht");

            while (true) {

                int gelesen = dateileser.read();
                if (gelesen == -1) {
                    break;
                }
                check(gelesen);
                System.out.print((char) gelesen);
            }
        } catch(FileNotFoundException fe) {
            System.out.println("Diese Datei existiert nicht!");
        } catch(IOException ie) {
            System.out.println("Fehler beim Lesen: "+ie.getMessage());
        } catch(DigitException de) {
            System.out.println();
            System.out.println("Fehler beim Lesen: Ziffer aufgetreten!");
            System.out.println(de.getMessage());
        }
    }
}