package Uebungen.Threads.ThreadZustaende;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
class Runner implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                for (int j = 0; j < 100000; j++) {
                    Thread.yield();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
