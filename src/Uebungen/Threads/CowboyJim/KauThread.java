package Uebungen.CowboyJim;

import java.util.IllegalFormatException;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
public class KauThread extends Thread{
    public void run() {
//        for (int i = 0; i < 10; i++) {
        while (!Thread.interrupted()) {
            System.out.println("schmatz");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
