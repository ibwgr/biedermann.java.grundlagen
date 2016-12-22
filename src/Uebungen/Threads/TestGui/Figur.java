package Uebungen.Threads.TestGui;

import java.awt.*;

/**
 * Created by dieterbiedermann on 15.12.16.
 */
public class Figur {
    private String name;
    private int posX, posY;
    TestGui testGui;

    public Figur(String name, TestGui testGui) {
        this.name = name;
        posX = 0;
        posY = 0;
        this.testGui = testGui;
    }

    public void move() {
        posX++;
        posY++;
    }

    public void show() {
/*
        Graphics2D g = testGui.canvas.createGraphics();
        g.setPaint(Color.white);
        g.fillRect(posX,posY,10,10);

        testGui.canvas.create
*/
    }

}
