package Semesterarbeit;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by Dieter on 21.12.2016.
 */
public class CSVParserTest extends JFrame {

    private JButton button;
    private JList<String> jlist;
    private JTable table;
    private File myFile;

    public CSVParserTest() {

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());

        button = new JButton("Open File");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFile = getFile();
                if (myFile != null) {
                    TableModel model = parseCSVAndCreateTableModel(myFile);
                    table.setModel(model);
                }
            }
        });

        //jlist.setListData(new String[]{"hallo", "test"});


        jpanel.add(button, BorderLayout.NORTH);
        table = new JTable();
        jpanel.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(jpanel);

        this.setTitle("CSV Parser Test");
        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.pack();
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

    private TableModel parseCSVAndCreateTableModel(final File file)
    {

        FileImportController fileImportController = new FileImportController(file);

        final Vector v = fileImportController.getVector();

        final Vector header = new Vector(Arrays.asList(new String[]{"CategoryId","uniqueId","Latitude","Longitude","Name"}));
        DefaultTableModel model = new DefaultTableModel(v,header);
        return model;

    }

    public static void main(String[] args) {
        CSVParserTest testGui = new CSVParserTest();
        testGui.setVisible(true);
    }
}
