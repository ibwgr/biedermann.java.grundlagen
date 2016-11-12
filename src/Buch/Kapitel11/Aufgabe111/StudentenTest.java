package Buch.Kapitel11.Aufgabe111;

import Buch.Kapitel11.Aufgabe111.studienfaecher.Fach;
import static Buch.Kapitel11.Aufgabe111.studienfaecher.Fach.*;

/**
 * Created by dieterbiedermann on 01.11.16.
 */
public class StudentenTest {
    public static void main(String[] args) {
        StudentNew Peter = new StudentNew();
        Peter.setName("Peter Honig");
        Peter.setNummer(12345);
        Peter.setFach(WIRTSCHAFTLICHEESSTUDIUM);
        System.out.println(Peter);
        System.out.println("Regelstudienzeit fuer sein Studium: " + Peter.getFach().regelstudienzeit() + " Semester.");
    }
}
