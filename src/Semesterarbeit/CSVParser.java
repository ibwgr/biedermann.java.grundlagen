package Semesterarbeit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private ArrayList<String> poiList;

    public CSVParser(FileImportController fileImportController) {
        this.fileImportController = fileImportController;
//        this.dbHandler = dbHandler;
        this.dbHandler = new DatabaseHandler(fileImportController);
//        this.queue = queue;
        this.poiList = new ArrayList<>();
    }

    public void run() {
//        dbHandler.prepareInsert();
        while (!fileImportController.allRowsProcessed()) {
            //String row = null;
            //row = queue.take();
            String row = fileImportController.getRow();
            if (row != null) {
//                String[] rowItem = row.split("\\|");
                /*
                  ToDO --> TEST
                 */
//                System.out.println(this.getName() + " -> " + row);

                Collections.addAll(poiList, row.split("\\|"));

                if (poiList.size() % 5000 == 0) {
                    dbHandler.insertMultiValuePois(poiList);
                    poiList.clear();
                }
/*
                */
/*
                  parse CSV File, check for update/insert
                 *//*

                if (dbHandler.exists("poi2", rowItem[1])) {
                    */
/*
                      update, add to updateQueue
                     *//*

                    System.out.println("exists");
                } else {
                    */
/*
                      insert, add to insertQueue
                     *//*

                    dbHandler.insertPoi2(rowItem);
                }
*/



                //fileImportController.putModelRow(new Vector(Arrays.asList(rowItem)));
            }
        }

        if (poiList.size() > 0) {
            dbHandler.insertMultiValuePois(poiList);
            poiList.clear();
//            dbHandler.commit();
        }

//        dbHandler.close();

    }

}
