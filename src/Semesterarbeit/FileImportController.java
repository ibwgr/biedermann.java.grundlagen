package Semesterarbeit;

import java.io.File;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImportController {

    private File file;
    private CSVParserTest csvParserTest;
    private BlockingQueue<String> rowQueue = new ArrayBlockingQueue<String>(1024);
    private Vector modelList = new Vector();
    private long rowCount = 0;
    private long counter = 0;

    public FileImportController(File file) {
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
        try {
            rowQueue.put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getRow() {
        while (queueIsEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        String row = null;
        try {
            row = rowQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
