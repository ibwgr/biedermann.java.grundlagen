package Uebungen.Swing;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by dieterbiedermann on 22.11.16.
 */
public class JClosableFrame extends JFrame {

    public JClosableFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(null, "Soll die Applikation wirklich geschlossen werden?", "Applikation schliessen?", JOptionPane.YES_NO_OPTION);

                if(dialogResult == JOptionPane.YES_OPTION){
                    super.windowClosing(e);
                    System.exit(0);
                }
            }
        });
    }
}
