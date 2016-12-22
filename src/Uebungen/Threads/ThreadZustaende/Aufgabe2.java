package Uebungen.Threads.ThreadZustaende;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class Aufgabe2 {
    public static void main(String[] args) throws InterruptedException {
        Runner c = new Runner();
        Thread r = new Thread(c);
        System.out.println(r.getState()); // 1
        r.start();
        while (r.isAlive()) {
            System.out.println(r.getState()); // 2
            Thread.sleep(100);
        }
        System.out.println(r.getState()); // 3
    }
}