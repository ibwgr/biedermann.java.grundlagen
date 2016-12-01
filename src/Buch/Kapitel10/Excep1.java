package Buch.Kapitel10;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
import Prog1Tools.IOTools;

public class Excep1 {

    public static void main(String[] args) {
        int a = IOTools.readInteger("a=");
        int b = IOTools.readInteger("b=");

        try {
            System.out.println("a/b="+(a/b));
        } catch(ArithmeticException ex) {
            System.out.println("Fehler: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}