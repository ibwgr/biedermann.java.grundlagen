package Semesterarbeit;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImporter extends Thread {

    private File file;
    private FileImportController fileImportController;

    public FileImporter(File file, FileImportController fileImportController) {
        this.file = file;
        this.fileImportController = fileImportController;
    }

    public void run() {
//        BufferedReader br = null;

        try {
//            br = new BufferedReader(new FileReader(file));
            Stream<String> lines = Files.lines(file.toPath(), StandardCharsets.UTF_8);
            //fileImportController.lines.count();
            for (String line : (Iterable<String>) lines::iterator) {
                fileImportController.putRow(line);
                System.out.println(line);
            }
            lines.close();
            // alle Zeilen lesen
//            while (br.ready()) {
//                fileImportController.putRow(br.readLine());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
*/

    }

}
