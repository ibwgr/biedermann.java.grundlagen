package Semesterarbeit;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Dieter on 23.12.2016.
 */
public class FileImportStatus extends Thread {

    private FileImportController fileImportController;
    private BlockingQueue<String> queue;

    public FileImportStatus(FileImportController fileImportController) {
        this.fileImportController = fileImportController;
//        this.queue = queue;
    }

    public void run() {

        while (!fileImportController.allRowsProcessed()) {
            fileImportController.showStatus();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        fileImportController.showStatus();
    }

}
