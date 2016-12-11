package Uebungen.Counter;

import java.util.Vector;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class Aufgabe1 {
    public static void main(String[] args) {
        String s = "test";
        final int maxCount = 1000, noThreads = 10;
        Vector<UpcountThread> upcountThreads = new Vector<UpcountThread>();
        for (int i=0; i<noThreads; i++) {
            upcountThreads.add(new UpcountThread(s, i, maxCount));
        }
        for (int i=0; i<noThreads; i++) {
            upcountThreads.elementAt(i).start();
        }
    }
}