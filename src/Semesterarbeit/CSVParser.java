package Semesterarbeit;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Dieter on 21.12.2016.
 */
public class CSVParser extends Thread {

    private FileImportController fileImportController;

    public CSVParser(FileImportController fileImportController) {
        this.fileImportController = fileImportController;
    }

    public void run() {
        while (!fileImportController.queueIsEmpty()) {
            String row = fileImportController.getRow();
            if (row != null) {
                String[] rowItem = row.split("\\|");
                /*
                * ToDO --> TEST
                */
                //System.out.println(this.getName() + " -> " + row);

                fileImportController.putModelRow(new Vector(Arrays.asList(rowItem)));
            }
        }
    }

}
