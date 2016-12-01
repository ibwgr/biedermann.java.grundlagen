package Buch.Kapitel10;

import java.io.*;
import Prog1Tools.*;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class LiesAusDatei {
    public static void main(String[] args) {
        // Lies den Dateinamen ein:
        String dateiname = IOTools.readString("Dateiname: ");
        // Oeffne die Datei zum Lesen:
        FileReader dateileser = null;
        try {
            dateileser = new FileReader(dateiname);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Lies alle Zeichen aus der Datei ein (read liefert int)
        // bis das Dateiende erreicht wird (signalisiert durch -1)
        // und gib sie (wieder als Buchstabe) auf den Bildschirm aus:
        System.out.println("In der Datei " + dateiname + " steht");
        while (true) {
            int gelesen = 0;
            try {
                gelesen = dateileser.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (gelesen == -1)
                break;
            System.out.print((char) gelesen);
        }
    }
}