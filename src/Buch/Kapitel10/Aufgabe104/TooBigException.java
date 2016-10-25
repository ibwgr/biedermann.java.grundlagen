package Buch.Kapitel10.Aufgabe104;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class TooBigException extends Exception {
    public TooBigException(String message) {
        super("Number is too big! " + message);
    }
}
