package Buch.Kapitel19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * Created by dieterbiedermann on 22.12.16.
 */
public class Aufgabe1 {

    public static void main(String[] args) {

        try {
            //Path pathIn = FileSystems.getDefault().getPath("myDirectory", "fileAufgabe1.txt");
            Path pathIn = Paths.get("myDirectory/fileAufgabe1.txt");
            //Path pathOut = FileSystems.getDefault().getPath("myDirectory", "fileAufgabe1Copy.txt");
            Path pathOut = Paths.get("myDirectory/fileAufgabe1Copy.txt");
            Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
