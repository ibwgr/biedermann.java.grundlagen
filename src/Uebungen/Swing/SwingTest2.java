package Uebungen.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by dieterbiedermann on 22.11.16.
 */
public class SwingTest2 {

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        jf.setSize(256,256);
        jf.setMaximumSize(new Dimension(256,256));

        JLabel jl  = new JLabel();

        jl.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                String str;
                str = e.getComponent().getClass().toString();
                str = str + " (" + "x=" + e.getX() + ", y=" + e.getY() + ")";
                jl.setText(str);
                jl.setOpaque(true);
                jl.setBackground(new Color(e.getX(), e.getY(),0));
            }
        });

        jf.add(jl);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
