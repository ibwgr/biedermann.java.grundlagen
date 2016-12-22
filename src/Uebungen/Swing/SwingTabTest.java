package Uebungen.Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dieterbiedermann on 18.12.16.
 */
public class SwingTabTest extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();


    public SwingTabTest() {
        this.setSize(600,400);
        this.setTitle("SwingTabTest");
        this.setLayout(new BorderLayout());

        JButton button1 = new JButton("new tab");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setOpaque(false);
                panel.setName("tab new");
                tabbedPane.add(panel);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel), new ButtonTabComponent(tabbedPane));
            }
        });

        this.add(button1, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setName("tab1");
        tabbedPane.add(panel);
        tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel), new ButtonTabComponent(tabbedPane));

        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        panel1.setName("tab2");
        tabbedPane.add(panel1);
        tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel1), new ButtonTabComponent(tabbedPane));

        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setName("tab3");
        tabbedPane.add(panel2);
        tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(panel2), new ButtonTabComponent(tabbedPane));

        this.add(tabbedPane, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingTabTest swingTabTest = new SwingTabTest();


    }

}
