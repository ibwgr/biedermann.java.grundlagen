package Uebungen.CowboyJim;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class CowboyJim {
    public static void main(String[] args) {
        KauThread kt = new KauThread();
        LaufThread lt = new LaufThread();
        kt.start();
        lt.start();
        try {
            Thread.sleep(5000);

            System.out.println("interrupt now");
            lt.interrupt();
            kt.interrupt();
            lt.join();
            kt.join();

            System.out.println("ende");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
