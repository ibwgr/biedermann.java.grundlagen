package Semesterarbeit;

import java.io.File;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImportController {

    private File file;
    private CSVParserTest csvParserTest;
    private DatabaseHandler dbHandler;
    //private BlockingQueue<String> rowQueue = new ArrayBlockingQueue<String>(1024);
    private LinkedList<String> rowQueue = new LinkedList<String>();
    private LinkedList<String> cityInsertQueue = new LinkedList<String>();
    private LinkedList<String> cityUpdateQueue = new LinkedList<String>();
    private LinkedList<String> poiInsertQueue = new LinkedList<String>();
    private LinkedList<String> poiUpdateQueue = new LinkedList<String>();
    private Vector modelList = new Vector();
    private long rowQueueCount = -1;
    private long counter = 0;

    public FileImportController(File file, CSVParserTest csvParserTest) {
        this.file = file;
        this.csvParserTest = csvParserTest;
        this.dbHandler = new DatabaseHandler();
    }


    public Vector getVector() {

        FileImporter fileImporter = new FileImporter(file, this);
        fileImporter.start();

/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        CSVParser parser1 = new CSVParser(this, dbHandler);
        CSVParser parser2 = new CSVParser(this, dbHandler);
        CSVParser parser3 = new CSVParser(this, dbHandler);
        //CSVParser parser4 = new CSVParser(this);

        parser1.start();
        parser2.start();
        parser3.start();
        //parser4.start();

        FileImportStatus fileImportStatus = new FileImportStatus(this);
        fileImportStatus.start();

        return modelList;
    }

    public synchronized void putRow(String s) {
        rowQueue.addLast(s);
        notify();
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
        String row = rowQueue.getFirst();
        rowQueue.removeFirst();
        return row;
    }

    public void putModelRow(Vector vector) {
        modelList.add(vector);
        csvParserTest.updateTable();
        counter++;
    }

    public boolean queueIsEmpty() {
        return rowQueue.isEmpty();
    }

    public void setRowQueueCount(long count) {
        rowQueueCount = count;
    }

    public void showStatus() {
        csvParserTest.setStatusText(counter + " / " + rowQueueCount);
    }

    public boolean allRowsProcessed() {
        return counter == rowQueueCount;
    }

    public void increaseRowQueueCount() {
        if (rowQueueCount < 0) {
            rowQueueCount = 0;
        }
        rowQueueCount++;
    }
}
