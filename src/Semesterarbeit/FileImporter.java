package Semesterarbeit;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImporter extends Thread {

    private File file;
    private FileImportController fileImportController;
    private BlockingQueue<String> queue;

    public FileImporter(File file, FileImportController fileImportController) {
        this.file = file;
        this.fileImportController = fileImportController;
//        this.queue = queue;
    }

    public void run() {

        try {
            Stream<String> lines = Files.lines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : (Iterable<String>) lines::iterator) {
                //queue.put(line);
                fileImportController.putRow(line);
                System.out.println(line);
                fileImportController.increaseRowQueueCount();
            }
            lines.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
