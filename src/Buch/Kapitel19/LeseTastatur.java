package Buch.Kapitel19;

import java.io.*;

/**
 * Created by dieterbiedermann on 22.12.16.
 */
public class LeseTastatur {

    public static void main(String[] args) {
        try {
            File outFile = new File(args[0]);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile, true));

            r2w(in, out);

            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void r2w(BufferedReader in, BufferedWriter out) {

        int c;
        String s;

        try {
            while ((c = in.read()) != -1) {
//                System.out.println("Gelesenes Zeichen: " + (char)c);
                out.write(c);
                out.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
