package Uebungen.CowboyJim;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class LaufThread extends Thread{
    int isLinks = 0;
    public void run() {
//        for (int i = 0; i < 20; i++) {
        while (!Thread.interrupted()) {
            if (isLinks == 1) {
                System.out.println("links");
                isLinks = 0;
            } else {
                System.out.println("rechts");
                isLinks = 1;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
