package Uebungen.Paint;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dieterbiedermann on 28.11.16.
 */
public class Paint extends JFrame implements ActionListener{
    private Container c;        // Container dieses Frames
    private Zeichenbrett z;     // Zeichenbrett zum Linienmalen
    private JPanel fNorth;
    private JButton[] colorButtons = new JButton[10];
    private JComboBox comboBox = new JComboBox();
    private Color[] colors = {Color.white,Color.yellow,Color.orange,Color.red,Color.pink,Color.blue,Color.green,Color.gray,Color.black};
    private Border line = BorderFactory.createLineBorder(Color.black, 4);
    private Border noline = BorderFactory.createLineBorder(Color.black, 0);
    private Border empty = new EmptyBorder(10, 10, 10, 10);
    private CompoundBorder selectedBorder = new CompoundBorder(line, empty);
    private CompoundBorder noneSelectedBorder = new CompoundBorder(noline, empty);
    private JSlider jSlider;
    private JButton clearButton, saveButton, openButton;
    private JFileChooser fileChooser = new JFileChooser();
    private int returnCode;
    private static int w = 640, h = 480;

    public Paint() {
        c = getContentPane();
        fNorth = new JPanel();
        fNorth.setLayout(new FlowLayout());
/*
        bBlack = new JButton();
        bRed = new JButton();
*/
        //JColorChooser jc = new JColorChooser();

        for (int i = 0; i < colors.length; i++) {
            colorButtons[i] = new JButton();
            colorButtons[i].setBackground(colors[i]);
            colorButtons[i].setActionCommand(colors[i].toString());
            colorButtons[i].setSize(20,20);
            colorButtons[i].addActionListener(this);
            colorButtons[i].setOpaque(true);
            colorButtons[i].setBorderPainted(false);
            if (colors[i] == Color.black) {
                colorButtons[i].setBorder(selectedBorder);
            } else {
                colorButtons[i].setBorder(noneSelectedBorder);
            }
            fNorth.add(colorButtons[i]);
        }
/*
        bBlack.setBackground(Color.black);
        bRed.setBackground(Color.red);
        bBlack.setActionCommand("black");
        bRed.setActionCommand("red");
        bBlack.setSize(30,30);
        bRed.setSize(30,30);
        bBlack.addActionListener(this);
        bRed.addActionListener(this);
        bBlack.setOpaque(true);
        bBlack.setBorderPainted(false);
        bRed.setOpaque(true);
        bRed.setBorderPainted(false);
*/

        jSlider = new JSlider(2,30,5);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                z.setDrawSize(jSlider.getValue());
            }
        });

        comboBox = new JComboBox();
        comboBox.addItem("Pinsel");
        comboBox.addItem("Rechteck");
        comboBox.addActionListener(this);
        clearButton = new JButton("clear");
        clearButton.addActionListener(this);
        clearButton.setActionCommand("clear");
        saveButton = new JButton("save");
        saveButton.addActionListener(this);
        saveButton.setActionCommand("save");
        openButton = new JButton("open");
        openButton.addActionListener(this);
        openButton.setActionCommand("open");

        z = new Zeichenbrett(w,h);

        fNorth.add(comboBox);
        fNorth.add(jSlider);
        fNorth.add(clearButton);
        fNorth.add(saveButton);
        fNorth.add(openButton);
/*
        fNorth.add(bBlack);
        fNorth.add(bRed);
*/
        c.add(fNorth, BorderLayout.NORTH);
        c.add(new JScrollPane(z), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Paint fenster = new Paint();
        fenster.setTitle("Paint");
        Dimension dimension = new Dimension();
        dimension.setSize(w,h);
        fenster.setPreferredSize(dimension);
        fenster.pack();
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            z.setDrawObject(comboBox.getSelectedIndex());
        } else {
            for (int i = 0; i < colors.length; i++) {
                if (e.getSource() == colorButtons[i]) {
                    z.setColor(colors[i]);
                    colorButtons[i].setBorder(selectedBorder);
                } else {
                    colorButtons[i].setBorder(noneSelectedBorder);
                }
            }


        }

        switch (e.getActionCommand()) {
            case "clear":
                z.clear();
                break;
            case "save":
                fileChooser.setMultiSelectionEnabled(false);
                returnCode = fileChooser.showSaveDialog(this);
                if (returnCode == JFileChooser.APPROVE_OPTION) {
                    z.saveImage(fileChooser.getSelectedFile());
                }
                break;
            case "open":
                fileChooser.setMultiSelectionEnabled(false);
                returnCode = fileChooser.showOpenDialog(this);
                if (returnCode == JFileChooser.APPROVE_OPTION) {
                    z.openImage(fileChooser.getSelectedFile());
                }
                break;
        }

    }
}
