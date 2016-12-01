package Uebungen.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by dieterbiedermann on 22.11.16.
 */
public class Umrechnung extends JClosableFrame implements ActionListener{
    double kurs = 1.09;

    JTextField jtext1, jtext2;
    JLabel jlabel1, jlabel2;

    public Umrechnung() {
        this.setTitle("Umrechnung");
        this.setSize(400,300);

        this.setLayout(new GridLayout(2,2));

        jlabel1 = new JLabel("Euro");
        jlabel2 = new JLabel("CHF");
        jtext1 = new JTextField();
        jtext2 = new JTextField();

//        jtext1.addActionListener(this);
//        jtext2.addActionListener(this);

        jtext1.addKeyListener(new MyKeyAdapter());
        jtext2.addKeyListener(new MyKeyAdapter());

        this.add(jlabel1);
        this.add(jtext1);
        this.add(jlabel2);
        this.add(jtext2);
    }

    public static void main(String[] args) {
        Umrechnung umr = new Umrechnung();
        umr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double result;
        if (e.getSource() == jtext1) {
            if (jtext1.getText().matches("\\d*\\.?\\d*")) {
                result = Double.valueOf(jtext1.getText()) * kurs;
                jtext2.setText(String.valueOf(result));
            } else {
                jtext2.setText("***");
            }
        } else if (e.getSource() == jtext2) {
            if (jtext2.getText().matches("\\d*\\.?\\d*")) {
                result = Double.valueOf(jtext2.getText()) / kurs;
                jtext1.setText(String.valueOf(result));
            } else {
                jtext1.setText("***");
            }
        }
    }

    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            double result;
            if (e.getSource() == jtext1) {
                if (!jtext1.equals("") && jtext1.getText().matches("\\d*\\.?\\d*")) {
                    result = Double.valueOf(jtext1.getText()) * kurs;
                    jtext2.setText(String.valueOf(result));
                } else {
                    jtext2.setText("***");
                }
            } else if (e.getSource() == jtext2) {
                if (!jtext2.equals("") && jtext2.getText().matches("\\d*\\.?\\d*")) {
                    result = Double.valueOf(jtext2.getText()) / kurs;
                    jtext1.setText(String.valueOf(result));
                } else {
                    jtext1.setText("***");
                }
            }
        }
    }
}
