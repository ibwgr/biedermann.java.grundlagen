package Uebungen.CSVTableExample;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.Exchanger;


public class CSVTableExample extends JFrame {

    private JTable table;
    private JButton btnAction, btnSave, newCol, newRow;
    private File myFile;

    public CSVTableExample()
    {
        super("CSVTableExample");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jp = new JPanel(new FlowLayout());
        newCol = new JButton("add Column");
        newCol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                TableColumn col = new TableColumn();
                col.setHeaderValue("new");
                table.addColumn(col);
            }
        });
        newRow = new JButton("add Row");
        newRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
            }
        });
        btnAction = new JButton("Dateiauswahl");
        btnSave = new JButton("Speichern");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                if (myFile != null) {
                    try {
                        FileWriter fw = new FileWriter(myFile);
//                        BufferedWriter bw = new BufferedWriter(fw);
                        for (int j = 0; j < table.getModel().getColumnCount(); j++) {
                            fw.write(table.getModel().getColumnName(j));
                            if (j < table.getModel().getColumnCount() - 1) {
                                fw.write(";");
                            }
                        }
                        fw.write(Character.LINE_SEPARATOR);
                        for (int i = 0; i < table.getModel().getRowCount(); i++) {
                            for (int j = 0; j < table.getModel().getColumnCount(); j++) {
                                fw.write(table.getModel().getValueAt(i,j).toString());
                                if (j < table.getModel().getColumnCount() - 1) {
                                    fw.write(";");
                                }
                            }
                            fw.write(Character.LINE_SEPARATOR);
                        }
                        fw.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                myFile = getFile();
                if (myFile != null) {
                    TableModel model = parseCSVAndCreateTableModel(myFile);
                    table.setModel(model);
                }
            }
        });

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);
        jp.add(btnAction);
        jp.add(btnSave);
        jp.add(newCol);
        add(jp, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public File getFile() {
        JFileChooser fileChooser = new JFileChooser();

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith("csv");
            }

            @Override
            public String getDescription() {
                return "CSV Datei";
            }
        };
        fileChooser.setFileFilter(filter);

        fileChooser.setMultiSelectionEnabled(false);
        int returnCode = fileChooser.showOpenDialog(this);
        if (returnCode == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public static void main(final String[] args)
    {
        new CSVTableExample();
    }

    private TableModel parseCSVAndCreateTableModel(final File file)
    {

        final Vector v = new Vector();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));

            // Beschriftungen lesen 1. Zeile in der Datei
            String[] rowItem = br.readLine().split(";");

            final Vector header = new Vector(Arrays.asList(rowItem));

            // alle Zeilen lesen
            while (br.ready()) {
                rowItem = br.readLine().split(";");
                v.add(new Vector(Arrays.asList(rowItem)));
            }

            DefaultTableModel model = new DefaultTableModel(v,header);
            return model;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }


        return null;
    }

}
