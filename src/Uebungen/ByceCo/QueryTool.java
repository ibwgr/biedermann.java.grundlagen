package Uebungen.ByceCo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by dieterbiedermann on 06.12.16.
 */
public class QueryTool extends JFrame {
    private Container c;
    private JPanel fNorth, fCenter;
    private JLabel lUrl, lBenutzer, lPasswort, lAbfrage, lLeer;
    private JTextField tUrl, tBenutzer, tPasswort;
    private JTextArea tAbfrage, tResult;
    private JButton bExecute;

    public QueryTool() {
        c = getContentPane();
//        fNorth = new JPanel(new FlowLayout());
        fNorth = new JPanel(new GridLayout(5,2));
//        fNorth.setLayout(new GridLayout(4,2));
//        fCenter = new JPanel();

        lUrl = new JLabel("URL");
        lBenutzer = new JLabel("Benutzer");
        lPasswort = new JLabel("Passwort");
        lAbfrage = new JLabel("Abfrage");
        lLeer = new JLabel("");
/*
        lUrl.setSize(100,20);
        lBenutzer.setSize(100,20);
        lPasswort.setSize(100,20);
        lAbfrage.setSize(100,20);
*/

        Dimension dimension = new Dimension();
        dimension.width = 100;
        dimension.height = 20;
        Dimension bigDimension = new Dimension();
        bigDimension.width = 100;
        bigDimension.height = 100;

        tUrl = new JTextField();
        tBenutzer = new JTextField();
        tPasswort = new JTextField();
        tAbfrage = new JTextArea();
        tUrl.setPreferredSize(dimension);
        tBenutzer.setPreferredSize(dimension);
        tPasswort.setPreferredSize(dimension);
        tAbfrage.setPreferredSize(dimension);

        bExecute = new JButton("Ausführen");
        bExecute.setActionCommand("ausfuehren");
        bExecute.addActionListener(new MyActionListener());

        tResult = new JTextArea();
//        fCenter.add();

        fNorth.add(lUrl);
        fNorth.add(tUrl);
        fNorth.add(lBenutzer);
        fNorth.add(tBenutzer);
        fNorth.add(lPasswort);
        fNorth.add(tPasswort);
        fNorth.add(lAbfrage);
        fNorth.add(tAbfrage);
        fNorth.add(lLeer);
        fNorth.add(bExecute);

        c.add(fNorth, BorderLayout.NORTH);
        c.add(new JScrollPane(tResult), BorderLayout.CENTER);
    }

    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String url = tUrl.getText();
            String benutzer = tBenutzer.getText();
            String passwort = tPasswort.getText();
            String abfrage = tAbfrage.getText();
            String result = "";

            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/"+url, benutzer, passwort);
                Statement statement = connection.createStatement();

                ResultSet resultset = statement.executeQuery(abfrage);
                ResultSetMetaData metaData = resultset.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    result = result + metaData.getColumnName(i)+"; ";
                }
                result = result + "\n";

                while (resultset.next()) {
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        result = result + resultset.getString(i)+"; ";
                    }
                    result = result + "\n";
                }
                resultset.close();

                tResult.setText(result);

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }

    public static void main(String[] args) {
        QueryTool qt = new QueryTool();
        qt.setSize(640,400);
        qt.setTitle("Query Tool");
        qt.setVisible(true);
        qt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
