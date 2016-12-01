package Test.Pruefung1;

/**
 * Created by dieterbiedermann on 15.09.16.
 */
// Biedermann
// Aufgabe 9
public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();
        Auto auto3 = new Auto();

        auto1.autoMarke = "Mazda";
        auto1.anzahlTueren = 5;
        auto1.ps = 140;

        auto2.autoMarke = "Opel";
        auto2.anzahlTueren = 3;
        auto2.ps = 110;

        auto3.autoMarke = "Fiat";
        auto3.anzahlTueren = 5;
        auto3.ps = 60;
    }
}
