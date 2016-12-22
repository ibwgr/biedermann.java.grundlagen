package Semesterarbeit;

import java.io.File;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImportController {

    private File file;
    private LinkedList<String> rowQueue = new LinkedList<>();
    private Vector modelList = new Vector();

    public FileImportController(File file) {
        this.file = file;
    }


    public Vector getVector() {

        FileImporter fileImporter = new FileImporter(file, this);
        fileImporter.start();

        CSVParser parser1 = new CSVParser(this);
        CSVParser parser2 = new CSVParser(this);
        CSVParser parser3 = new CSVParser(this);

        parser1.start();
        parser2.start();
        parser3.start();

        return modelList;
    }

    public void putRow(String s) {
        rowQueue.addLast(s);
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
    }

    public boolean queueIsEmpty() {
        return rowQueue.isEmpty();
    }
}
