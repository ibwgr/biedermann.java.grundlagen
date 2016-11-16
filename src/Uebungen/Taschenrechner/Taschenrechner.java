package Uebungen.Taschenrechner;

import Others.Calculator.Display;
import Others.Calculator.Expression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dieterbiedermann on 15.11.16.
 */
public class Taschenrechner extends JFrame implements ActionListener {
    private String textEntry = new String();
    private ArrayList<String> textHistory = new ArrayList<String>();
    private ArrayList<JButton> jButtons = new ArrayList<JButton>();
    private JTextField jTextEntry;
    private JTextArea jTextResult;
    private JList<String> jListHistory;

    public Taschenrechner() {
        this.setTitle("Taschenrechner");
        JPanel jp = new JPanel();

        jp.setLayout(new BorderLayout());

        JPanel jpN = new JPanel();
        JPanel jpS = new JPanel();
        jpN.setLayout(new FlowLayout());
        jpS.setLayout(new FlowLayout());
        jTextEntry = new JTextField("", 25);
        jTextEntry.setEditable(false);
        jTextEntry.setFont(new Font("Monospaced",Font.BOLD,30));
        jTextResult = new JTextArea(3, 40);
        jTextResult.setEditable(false);
        jTextResult.setFont(new Font("Monospaced",Font.PLAIN,20));
        jListHistory = new JList<String>();
        jListHistory.setFont(new Font("Monospaced",Font.PLAIN,20));

        JTabbedPane tabbedPane = new JTabbedPane();
        JScrollPane scrollPaneResult = new JScrollPane(jTextResult);
        JScrollPane scrollPaneHistory = new JScrollPane(jListHistory);

        tabbedPane.add(scrollPaneResult, "Result");
        tabbedPane.add(scrollPaneHistory, "History");
        jpN.add(jTextEntry);
        jp.add(jpN, BorderLayout.NORTH);
        jpS.add(tabbedPane);
        jp.add(jpS, BorderLayout.SOUTH);

        JPanel jpC = new JPanel();
        jpC.setLayout(new GridLayout(4,5));
        for (int i = 7; i <= 9; i++) {
            jButtons.add(new JButton(String.valueOf(i)));
        }
        jButtons.add(new JButton("+"));
        jButtons.add(new JButton("-"));
        for (int i = 4; i <= 6; i++) {
            jButtons.add(new JButton(String.valueOf(i)));
        }
        jButtons.add(new JButton("*"));
        jButtons.add(new JButton("/"));
        for (int i = 1; i <= 3; i++) {
            jButtons.add(new JButton(String.valueOf(i)));
        }
        jButtons.add(new JButton("("));
        jButtons.add(new JButton(")"));
        jButtons.add(new JButton("0"));
        jButtons.add(new JButton("."));
        jButtons.add(new JButton("<-"));
        jButtons.add(new JButton("C"));
        jButtons.add(new JButton("="));
        for (JButton jb : jButtons) {
            jb.setFont(new Font("Monospaced", Font.PLAIN,20));
            jb.addActionListener(this);
            jpC.add(jb);
        }

        jp.add(jpC, BorderLayout.CENTER);

        this.add(jp);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack(); // setzt Start Grösse
    }

    public static void main(String[] args) {

        Taschenrechner taschenrechner = new Taschenrechner();
        taschenrechner.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton jb : jButtons) {
            if (e.getSource() == jb) {
                switch (jb.getText()) {
                    case "C":
                        if (textEntry.length() > 0) {
                            textEntry = "";
                            jTextEntry.setText(textEntry);
                        }
                        break;
                    case "<-":
                        if (textEntry.length() > 0) {
                            textEntry = textEntry.substring(0, textEntry.length() - 1);
                            jTextEntry.setText(textEntry);
                        }
                        break;
                    case "=":
                        try {
                            Expression expr = new Expression(textEntry);
                            textEntry = textEntry + "=" + Display.getDouble(expr.getResult());
                            jTextEntry.setText(textEntry);
                            jTextResult.setText(expr.getAllExprStr());
                            textHistory.add(expr.toString());
                            String[] strings = new String[textHistory.size()];
                            strings = textHistory.toArray(strings);
                            jListHistory.setListData(strings);
                        } catch (IllegalArgumentException ex) {
                            jTextResult.setText(ex.getMessage());
                        }
                        break;
                    default:
                        textEntry = textEntry + jb.getText();
                        jTextEntry.setText(textEntry);
                }
            }
        }
    }
}
