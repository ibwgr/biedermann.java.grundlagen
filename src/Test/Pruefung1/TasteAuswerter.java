package Test.Pruefung1;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 15.09.16.
 */
// Biedermann
// Aufgabe 5
public class TasteAuswerter {
    public static void main(String[] args) {
        // Zahl von Tastatur einlesen mit IOTools
        int pressedNumbers = IOTools.readInt("Zahl: ");

        // Mit if else Statement
        if (pressedNumbers >= 0 && pressedNumbers <= 9) {
            System.out.println("Taste " + pressedNumbers + " gedrueckt");
        } else {
            System.out.println("Nicht erlaubt");
        }

        // Mit Switch Statement
        String taste = "";
        switch (pressedNumbers) {
            case 0: taste = "Null"; break;
            case 1: taste = "Eins"; break;
            case 2: taste = "Zwei"; break;
            case 3: taste = "Drei"; break;
            case 4: taste = "Vier"; break;
            case 5: taste = "Fuenf"; break;
            case 6: taste = "Sechs"; break;
            case 7: taste = "Sieben"; break;
            case 8: taste = "Acht"; break;
            case 9: taste = "Neun"; break;
        }
        if (taste == "") {
            System.out.println("Nicht erlaubt");
        } else {
            System.out.println("Taste " + taste + " gedrueckt");
        }
    }
}
