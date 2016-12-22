package Uebungen.Taschenrechner;

import Others.Calculator.Display;
import Others.Calculator.Expression;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;

import static javax.swing.UIManager.put;

/**
 * Created by dieterbiedermann on 15.11.16.
 */
public class Taschenrechner extends JFrame implements ActionListener {
    private String textEntry = "";
    private ArrayList<String> textHistory = new ArrayList<>();
    private ArrayList<JButton> jButtons = new ArrayList<>();
    private JTextArea jTextEntry;
    private JTextArea jTextResult;
    private JList<String> jListHistory;

    public Taschenrechner() {
        this.setTitle("Taschenrechner");

        Dimension dimension = new Dimension();
        dimension.setSize(400,480);
        this.setPreferredSize(dimension);

        JPanel jp = new JPanel();

        jp.setLayout(new BorderLayout()); // BorderLayout ist auch Standard Layout, wenn kein Layout gesetzt wird.

        JPanel jpN = new JPanel();
        JPanel jpS = new JPanel();
        jpN.setLayout(new GridLayout());
        jpS.setLayout(new GridLayout());
        jTextEntry = new JTextArea();
        jTextEntry.setEditable(false);
        jTextEntry.setLineWrap(true);


        // Border
        /*Border line = BorderFactory.createLineBorder(Color.GRAY, 4);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        jTextEntry.setBorder(border);
*/
        jTextEntry.setFont(new Font("Monospaced",Font.BOLD,30));
        jTextResult = new JTextArea();
        jTextResult.setEditable(false);
        jTextResult.setFont(new Font("Monospaced",Font.PLAIN,14));
        jListHistory = new JList<>();
        jListHistory.setFont(new Font("Monospaced",Font.PLAIN,14));

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add(new JScrollPane(jTextResult), "Result");
        tabbedPane.add(new JScrollPane(jListHistory), "History");
        tabbedPane.setPreferredSize(new Dimension(400,120));
        jpN.add(new JScrollPane(jTextEntry));
//        jpN.add(new Button("ok"));
        jp.add(jpN, BorderLayout.CENTER);
        jpS.add(tabbedPane);

        JPanel jpC = new JPanel(new GridLayout(4,5));
        jpC.setPreferredSize(new Dimension(400,180));
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
            //jb.setActionCommand();
            jpC.add(jb);
        }

        JPanel jpSgrid = new JPanel(new GridLayout(2,1));
        jpSgrid.add(jpC);
        jpSgrid.add(jpS);
        jp.add(jpSgrid, BorderLayout.SOUTH);

        jp.getActionMap().put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                        new StringSelection(textEntry), null);
            }
        });
        jp.getActionMap().put("paste", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().getSystemClipboard().getContents(textEntry);
            }
        });

        jp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK), "copy");
        jp.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK), "paste");



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
                        //jb.getActionCommand();
                        textEntry = textEntry + jb.getText();
                        jTextEntry.setText(textEntry);
                }
            }
        }
    }
}
