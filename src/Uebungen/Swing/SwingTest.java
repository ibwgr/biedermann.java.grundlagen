package Uebungen.Swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by dieterbiedermann on 22.11.16.
 */
public class SwingTest extends JClosableFrame {

    public SwingTest() {
        this.setSize(600,200);
        this.setTitle("Man nennt das \"Das Fenster\"");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int fullX = dimension.width;
        int fullY = dimension.height;

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                int currentX = e.getComponent().getX();
                int currentY = e.getComponent().getY();
                int currentWidth = e.getComponent().getWidth();
                int currentHeight = e.getComponent().getHeight();
                int newX = currentX, newY = currentY;

                if (currentX < 100) {
                    newX = 0;
                }
                if (currentX > fullX - currentWidth - 100) {
                    newX = fullX - currentWidth;
                }
                if (currentY < 100) {
                    newY = 0;
                }
                if (currentY > fullY - currentHeight - 100) {
                    newY = fullY - currentHeight;
                }

                e.getComponent().setLocation(newX, newY);
            }

        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                SwingTest.super.setTitle("x=" + e.getX() + ", y=" + e.getY());
            }
        });

        JPanel testPanel = new JPanel();

//        ImageIcon testImage = new ImageIcon("http://www.wine-logistix.de/magento_pic/efulfillment/ES-TE-0081_2_.jpg");

//        Image newImage = testImage.getImage();


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new URL("http://www.wine-logistix.de/magento_pic/efulfillment/ES-TE-0081_2_.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                g.drawImage(img, 0, 0, null);
            }
        };

        this.add(panel);
    }


    public static void main(String[] args) {
        SwingTest st = new SwingTest();
        st.setVisible(true);
    }

}
