package Buch.Kapitel19;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Created by dieterbiedermann on 22.12.16.
 */
public class FileTest {

    public static void main(String[] args) {

        File directory = new File("myDirectory");

        System.out.println("Is Directory: "+directory.isDirectory()
            + ", absolute path: "+directory.getAbsolutePath()
        );

        for(File file: directory.listFiles()){
            System.out.println("File in directory: "+file.getName());
        }

        File newFile = new File(directory, "newfile.txt");

        System.out.println("Datei existiert: "+newFile.exists());

        FileInputStream in = null;
        FileOutputStream out = null;
        try {

            in = new FileInputStream("myDirectory/created.txt");
            out = new FileOutputStream("myDirectory/createdCopy.txt");
            int c;

            while((c = in.read()) != -1) {
                System.out.print((char) c);
                out.write(c);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                        in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader inputStream;
        FileWriter outputStream;
        try {
            inputStream = new FileReader("myDirectory/created.txt");
            outputStream = new FileWriter("myDirectory/created2.txt");
            int c;

            while((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Files.copy

        //Files.copy(new )

    }

}
