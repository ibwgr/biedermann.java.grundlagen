package Buch.Kapitel3;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Aufgabe435 {
    public static void main(String[] args) {
        int t, m , j, c, y, h;
        String datum, wochentag = "";

        System.out.print("Tag:   ");
        t = IOTools.readInteger();
        System.out.print("Monat: ");
        m = IOTools.readInteger();
        System.out.print("Jahr:  ");
        j = IOTools.readInteger();

        datum = t + "." + m + "." + j;

        if (m <= 2) {
            m += 10;
            j--;
        } else {
            m -= 2;
        }

        c = j / 100;
        y = j % 100;
        h = (((26 * m - 2) / 10) + t + y + y/4 + c/4 - 2 * c) % 7;

        switch (h) {
            case 0: wochentag = "Sonntag"; break;
            case 1: wochentag = "Montag"; break;
            case 2: wochentag = "Dienstag"; break;
            case 3: wochentag = "Mittwoch"; break;
            case 4: wochentag = "Donnerstag"; break;
            case 5: wochentag = "Freitag"; break;
            case 6: wochentag = "Samstag"; break;
        }

        System.out.println("Der " + datum + " ist ein " + wochentag);
    }
}
