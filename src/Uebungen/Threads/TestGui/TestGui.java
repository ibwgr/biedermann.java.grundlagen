package Uebungen.Threads.TestGui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by dieterbiedermann on 15.12.16.
 */
public class TestGui extends JFrame {

    Canvas canvas;

    public TestGui() {
//        canvas = new Canvas();
        canvas = new Canvas();
        canvas.setSize(new Dimension(640,480));

        this.add(new JPanel().add(canvas), BorderLayout.CENTER);

        this.setSize(new Dimension(640,480));

        this.setTitle("TestGui");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TestGui testGui = new TestGui();

        FigurThread ft = new FigurThread(new Figur("Figur1", testGui));
        ft.start();
    }
}
