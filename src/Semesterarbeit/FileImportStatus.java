package Semesterarbeit;

/**
 * Created by Dieter on 23.12.2016.
 */
public class FileImportStatus extends Thread {

    private FileImportController fileImportController;

    public FileImportStatus(FileImportController fileImportController) {
        this.fileImportController = fileImportController;
    }

    public void run() {

        while (!fileImportController.queueIsEmpty()) {
            fileImportController.showStatus();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
