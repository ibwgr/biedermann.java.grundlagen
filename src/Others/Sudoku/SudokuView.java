package Others.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by dieterbiedermann on 17.11.16.
 */
public class SudokuView extends JFrame implements ActionListener {
    private int[][] quad, quadHide;
    private ArrayList<JComponent> components = new ArrayList<>();
    private JButton buttonCheck, buttonNew;
    private JLabel labelCheck;
    private ButtonGroup radioButtonGroup;
    private JRadioButton radioWithCombo, radioWithLabel;
    private JSlider jSlider;
    private JPanel jPanel = new JPanel(new BorderLayout());
    private JPanel jPanelSouth = new JPanel(new FlowLayout());
    private JPanel jPanelCenter = new JPanel(new GridLayout(9,9));
    private JPanel jPanelNorth = new JPanel(new FlowLayout());

    public void getSudoku() {
        quad = Sudoku.create();
        quadHide = Sudoku.createHide(quad, jSlider.getValue());
        components.removeAll(components);
        jPanelCenter.removeAll();
        for (int i = 0; i < quad.length; i++) {
            for (int j = 0; j < quad.length; j++) {
                if (quadHide[i][j] == 1) {
                    if (radioWithCombo.isSelected()) {
                        components.add(new JComboBox());
                    } else {
                        components.add(new JLabel(" "));
                    }
                } else {
                    int zahl = quad[i][j];
                    components.add(new JLabel(String.valueOf(zahl)));
                }
            }
        }
        {
            int counter = 0, counterV = 1, counterH = 1;
            int borderBig = 3, borderSmall = 1;
            for (JComponent compo : components) {
                int topBorder = borderSmall, leftBorder = borderSmall, bottomBorder = borderSmall, rightBorder = borderSmall;
                counter++;
                if (compo.getClass() == JComboBox.class) {
                    JComboBox jc = (JComboBox) compo;
                    jc.addItem("");
                    jc.setFont(new Font("Monospaced",Font.BOLD,16));
                    for (int i = 1; i <= 9; i++) {
                        jc.addItem(i);
                    }
                }
                if (compo.getClass() == JLabel.class) {
                    JLabel jl = (JLabel) compo;
                    jl.setHorizontalAlignment(SwingConstants.CENTER);
                    jl.setFont(new Font("Monospaced", Font.BOLD, 20));
                    if (jl.getText().equals(" ")) {
                        jl.setOpaque(true);
                        jl.setBackground(Color.yellow);
                        jl.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (jl.getText().equals(" ")) {
                                    jl.setText("1");
                                } else {
                                    Integer number = Integer.valueOf(jl.getText());
                                    number++;
                                    if (number > 9) {
                                        jl.setText(" ");
                                    } else {
                                        jl.setText(String.valueOf(number));
                                    }
                                }
                            }
                        });
                    }
                }
                if (counterV == 1) {
                    leftBorder = borderBig;
                }
                if (counterV % 3 == 0) {
                    rightBorder = borderBig;
                }
                if (counterH == 1) {
                    topBorder = borderBig;
                }
                if (counterH % 3 == 0) {
                    bottomBorder = borderBig;
                }
                compo.setBorder(BorderFactory.createMatteBorder(topBorder,leftBorder,bottomBorder,rightBorder,Color.black));
                counterV++;
                if (counterV > 9) {
                    counterV = 1;
                }
                if (counter % 9 == 0) {
                    counterH++;
                }
                compo.setSize(30,60);
                jPanelCenter.add(compo);
//                jPanelCenter.add(new JPanel(new FlowLayout()).add(compo));
            }
            jPanelCenter.setBackground(Color.white);
            jPanelCenter.updateUI();
        }
    }

    public SudokuView() {

        this.setTitle("Sudoku");

        labelCheck = new JLabel();

        buttonNew = new JButton("New");
        buttonCheck = new JButton("Check");
        radioWithCombo = new JRadioButton("ComboBox", true);
        radioWithLabel = new JRadioButton("Label");
        radioButtonGroup = new ButtonGroup();
        jSlider = new JSlider(1,4,2);
        radioButtonGroup.add(radioWithCombo);
        radioButtonGroup.add(radioWithLabel);

        buttonNew.addActionListener(this);
        buttonCheck.addActionListener(this);

        getSudoku();

        jPanelNorth.add(radioWithCombo);
        jPanelNorth.add(radioWithLabel);
        jPanelNorth.add(jSlider);
        jPanelNorth.add(buttonNew);
        jPanelSouth.add(buttonCheck);
        jPanelSouth.add(labelCheck);

        jPanel.add(jPanelCenter, BorderLayout.CENTER);
        jPanel.add(jPanelNorth, BorderLayout.NORTH);
        jPanel.add(jPanelSouth, BorderLayout.SOUTH);
        this.add(jPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack(); // setzt Start Grösse
    }

    public static void main(String[] args) {
        SudokuView sv = new SudokuView();
        sv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[][] quad = new int[9][9];
        int x = 0, y = 0;

        if (e.getSource() == buttonNew) {
            getSudoku();
        }


        if (e.getSource() == buttonCheck) {
//            components.forEach();
            for (JComponent compo : components) {
                if (y > 8) {
                    x++;
                    y = 0;
                }
                if (compo.getClass() == JComboBox.class) {
                    Object obj = ((JComboBox) compo).getSelectedItem();
                    if (obj.getClass() == Integer.class) {
                        quad[x][y] = (Integer) obj;
                    } else {
                        quad[x][y] = 0;
                    }
                } else if (compo.getClass() == JTextField.class) {
                    if (!((JTextField)compo).getText().equals(" ")) {
                        quad[x][y] = Integer.valueOf(((JTextField) compo).getText());
                    }
                } else if (compo.getClass() == JLabel.class){
                    if (!((JLabel)compo).getText().equals(" ")) {
                        quad[x][y] = Integer.valueOf(((JLabel) compo).getText());
                    }
                }
                y++;
            }
            for (int i = 0; i < quad.length; i++) {
                for (int j = 0; j < quad.length; j++) {
                    int zahl = quad[i][j];
                    System.out.print((zahl > 9 ? " " : "  ") + zahl);
                }
                System.out.println();
            }
            if (Sudoku.check(quad)) {
                labelCheck.setText("true");
            } else {
                labelCheck.setText("false");
            }
        }
    }
}
