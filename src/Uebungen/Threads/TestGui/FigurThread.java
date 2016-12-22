package Uebungen.Threads.TestGui;

/**
 * Created by dieterbiedermann on 15.12.16.
 */
public class FigurThread extends Thread {

    Figur figur;

    public FigurThread(Figur figur) {
        this.figur = figur;
    }

    public void run() {

        figur.move();
        figur.show();

    }
}
