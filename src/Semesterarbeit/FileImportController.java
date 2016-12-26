package Semesterarbeit;

import java.io.File;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImportController {

    private File file;
    private CSVParserTest csvParserTest;
    private LinkedList<String> rowQueue = new LinkedList<>();
    private Vector modelList = new Vector();
    private long rowCount = 0;
    private long counter = 0;

    public FileImportController(CSVParserTest csvParserTest, File file) {
        this.file = file;
        this.csvParserTest = csvParserTest;
    }


    public Vector getVector() {

        FileImporter fileImporter = new FileImporter(file, this);
        FileImportStatus fileImportStatus = new FileImportStatus(this);
        fileImporter.start();

        CSVParser parser1 = new CSVParser(this);
        CSVParser parser2 = new CSVParser(this);
        CSVParser parser3 = new CSVParser(this);
        //CSVParser parser4 = new CSVParser(this);

        parser1.start();
        parser2.start();
        parser3.start();
        //parser4.start();

        fileImportStatus.start();

        return modelList;
    }

    public void putRow(String s) {
        rowQueue.addLast(s);
    }

    public synchronized String getRow() {
        String row = null;
        while (queueIsEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        try {
            row = rowQueue.getFirst();
            rowQueue.removeFirst();
        } catch (NoSuchElementException e) {

        }
        return row;
    }

    public void putModelRow(Vector vector) {
        modelList.add(vector);
        counter++;
    }

    public boolean queueIsEmpty() {
        return rowQueue.isEmpty();
    }

    public void setRowCount(long count) {
        rowCount = count;
    }

    public void showStatus() {
        csvParserTest.setStatusText(counter + " / " + rowCount);
    }
}
