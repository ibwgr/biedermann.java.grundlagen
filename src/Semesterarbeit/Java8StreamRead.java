package Semesterarbeit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Java8StreamRead {

    public static void main(String[] args) {

        Path file = Paths.get("myDirectory/liechtenstein-latest.csv");
        try
        {
            Stream<String> lines = Files.lines( file, StandardCharsets.UTF_8 );
            for( String line : (Iterable<String>) lines::iterator )
            {
               System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
