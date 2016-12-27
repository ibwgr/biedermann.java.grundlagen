package Semesterarbeit;

import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Dieter on 21.12.2016.
 */
public class CSVParser extends Thread {

    private FileImportController fileImportController;
    private DatabaseHandler dbHandler;
    private BlockingQueue<String> queue;

    public CSVParser(FileImportController fileImportController, DatabaseHandler dbHandler) {
        this.fileImportController = fileImportController;
        this.dbHandler = dbHandler;
//        this.queue = queue;
    }

    public void run() {
        while (!fileImportController.allRowsProcessed()) {
            //String row = null;
            //row = queue.take();
            String row = fileImportController.getRow();
            if (row != null) {
                String[] rowItem = row.split("\\|");
                /**
                * ToDO --> TEST
                */
                System.out.println(this.getName() + " -> " + row);

                /**
                 * parse CSV File, check for update/insert
                 */
                if (dbHandler.exists("poi", rowItem[1])) {
                    /**
                     * update, add to updateQueue
                     */
                    System.out.println("exists");
                } else {
                    /**
                     * insert, add to insertQueue
                     */
                    dbHandler.insertPoi(rowItem);
                }

                fileImportController.putModelRow(new Vector(Arrays.asList(rowItem)));
            }
        }
    }

}
