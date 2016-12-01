package Buch.Kapitel9.Aufgabe91;

import Prog1Tools.IOTools;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class WaehrungsKalkulator {

    public static void main(String[] args) {

        String str;

        str = IOTools.readString("Bitte Währung eingeben (Euro,DM,Lire,Franc, x = Ende): ");

        while(!str.equals("x")) {

            Euro euro = new Euro(0);
            DM dm = new DM(0);
            Lire lire = new Lire(0);
            Franc franc = new Franc(0);

            double input;
            input = IOTools.readDouble("Bitte Betrag eingeben: ");

            switch(str) {
                case "Euro":
                    euro = new Euro(input);
                    dm = new DM(euro);
                    lire = new Lire(euro);
                    franc = new Franc(euro);
                    break;
                case "DM":
                    dm = new DM(input);
                    euro = new Euro(dm.euroBetrag());
                    lire = new Lire(dm);
                    franc = new Franc(dm);
                    break;
                case "Lire":
                    lire = new Lire(input);
                    euro = new Euro(lire.euroBetrag());
                    dm = new DM(lire);
                    franc = new Franc(lire);
                    break;
                case "Franc":
                    franc = new Franc(input);
                    euro = new Euro(franc.euroBetrag());
                    dm = new DM(franc);
                    lire = new Lire(franc);
                    break;
            }

            System.out.println("Betrag in Euro: " + euro.euroBetrag());
            System.out.println("Betrag in DM: " + dm.waehrungsBetrag());
            System.out.println("Betrag in Lire: " + lire.waehrungsBetrag());
            System.out.println("Betrag in Franc: " + franc.waehrungsBetrag());
            System.out.println("------------------------");

            str = IOTools.readString("Bitte Währung eingeben (Euro,DM,Lire,Franc, x = Ende): ");
        }

    }

}
