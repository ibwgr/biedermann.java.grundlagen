package Uebungen.Threads.ThreadTest;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class CounterThread extends Thread{
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Zaehlerstand: " + i);
            try {
                Thread.sleep(1000); // weiter in mind. einer Sekunde
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CounterThread ct = new CounterThread();
        ct.start();
    }
}
