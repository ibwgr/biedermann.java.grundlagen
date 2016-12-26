package Buch.Kapitel19;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by dieterbiedermann on 22.12.16.
 */
public class Aufgabe2 {

    public static void main(String[] args) {

        BufferedReader reader = null;

        try {

            // read file
            reader = new BufferedReader(new FileReader("myDirectory/fileAufgabe2.txt"));

            String line;
            HashSet<String> uniqueWords = new HashSet<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    uniqueWords.add(word);
                }
            }

            // write new file
            File outputFile = new File("myDirectory/uniqueWords.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            for (String uniqueWord : uniqueWords) {
                System.out.println(uniqueWord);
                writer.write(uniqueWord+"\n");
            }

            writer.close();

            // write zip file
            ZipOutputStream zipOutputStream = new ZipOutputStream(
                    new FileOutputStream(
                            new File("myDirectory/uniqueZipped.zip")
                    )
            );
            ZipEntry zipEntry = new ZipEntry(outputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);
            Files.copy(Paths.get(outputFile.getAbsolutePath()), zipOutputStream);
            zipOutputStream.closeEntry();
            zipOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                        reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
