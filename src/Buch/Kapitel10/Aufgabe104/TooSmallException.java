package Buch.Kapitel10.Aufgabe104;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class TooSmallException extends Exception{
    public TooSmallException(String message) {
        super("Number is too small! " + message);
    }
}
