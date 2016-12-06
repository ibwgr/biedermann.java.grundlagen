package Uebungen.Paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by dieterbiedermann on 28.11.16.
 */
public class Zeichenbrett extends JPanel {
    private int[] x, y; // Koordinaten der Maus-Klicks
    private int n; // Anzahl Klicks
    private int x2,y2,x2Start,y2Start,x2Old = -1,y2Old = -1;
    private BufferedImage canvas;
    private Color color = Color.black;
    private int drawSize = 5;
    private int drawObject = 0;
    int w,h;


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDrawSize() {
        return drawSize;
    }

    public void setDrawSize(int drawSize) {
        this.drawSize = drawSize;
    }

    public int getDrawObject() {
        return drawObject;
    }

    public void setDrawObject(int drawObject) {
        this.drawObject = drawObject;
    }

    public void clear() {
        Graphics2D g = canvas.createGraphics();
        g.setPaint(Color.white);
        g.fillRect(0,0,600,400);
        repaint();
    }

    public Zeichenbrett() { // Konstruktor
        canvas = new BufferedImage(600,400,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = canvas.createGraphics();
        g.setPaint(Color.white);
        g.fillRect(x2,y2,600,400);
//        updateCanvas();
        n = 0;
        x = new int[1000];
        y = new int[1000];
        addMouseMotionListener(new myMouseMotionAdapter());
        addMouseListener(new myMouseAdapter());
    }

    public void updateCanvas() {
        switch (drawObject) {
            case 0:
                if (x2Old >= 0 && y2Old >= 0) {
                    Graphics2D g = canvas.createGraphics();
                    g.setPaint(color);
                    g.setStroke(new BasicStroke(drawSize));
                    g.drawLine(x2, y2, x2Old, y2Old);
                    repaint();
                }
                break;
            case 1:
                if (x2Old < 0 && y2Old < 0) {
                    Graphics2D g = canvas.createGraphics();
                    g.setPaint(color);
                    g.setStroke(new BasicStroke(drawSize));
                    int x3,y3,w3,h3;
                    if (x2Start < x2) {
                        x3 = x2Start;
                        w3 = x3 - x2;
                    } else {
                        x3 = x2;
                        w3 = x3 - x2Start;
                    }
                    if (y2Start < y2) {
                        y3 = y2Start;
                        h3 = y3 - y2;
                    } else {
                        y3 = y2;
                        h3 = y3 - y2Start;
                    }
                    g.drawRect(x3, y3, w3, h3);
                    repaint();
                }
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
    }

    public void openImage(File file) {
        try {
            canvas = ImageIO.read(file);
            w = canvas.getWidth(null);
            h = canvas.getHeight(null);
            if (canvas.getType() != BufferedImage.TYPE_INT_RGB) {
                BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi2.getGraphics();
                g.drawImage(canvas, 0, 0, null);
                canvas = bi2;
            }
            repaint();
        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
    }

    public void saveImage(File file) {
        try {
            // retrieve image
            ImageIO.write(canvas, "png", file);
        } catch (IOException e) {
            System.out.println("Image could not be saved");
            System.exit(1);
        }
    }

    class myMouseMotionAdapter extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            updateCanvas();
            x2Old = x2;
            y2Old = y2;        }
    }

    class myMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            x2Old = e.getX();
            y2Old = e.getY();
            x2Start = x2Old;
            y2Start = y2Old;
//            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            y2Old = -1;
            x2Old = -1;
            updateCanvas();
//            repaint();
        }
    }
}
