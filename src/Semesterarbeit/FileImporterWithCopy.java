package Semesterarbeit;

import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import sun.awt.image.ImageWatched;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

/**
 * Created by Dieter on 22.12.2016.
 */
public class FileImporterWithCopy extends Thread {

    private File file;
    private FileImportController fileImportController;
    private BlockingQueue<String> queue;

    Connection connection;
    CopyManager cpManager;
    BufferedReader reader;

    public FileImporterWithCopy(File file, FileImportController fileImportController) {
        this.file = file;
        this.fileImportController = fileImportController;
//        this.queue = queue;
    }

    public void run() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/trip_planner_db", "postgres1", "postgres1");
            cpManager = ((PGConnection)connection).getCopyAPI();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            cpManager.copyIn("COPY poi2 FROM STDIN WITH (FORMAT CSV, DELIMITER '|')", reader );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        try {
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
        }*/

    }

}
