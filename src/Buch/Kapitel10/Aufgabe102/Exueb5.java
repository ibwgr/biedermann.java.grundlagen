package Buch.Kapitel10.Aufgabe102;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
import java.io.*;

public class Exueb5 {

    // richtige Antwort Listing 6

    public static void main(String[] args)
            throws FileNotFoundException {

        FileReader f=new FileReader("Exueb6.java");

        try {
            while (true) { int c=f.read();
                if (c<0)
                    return;
                System.out.print((char)c);
            }
        }
        catch(IOException e) {}
    }
}