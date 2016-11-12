package Buch.Kapitel11.Aufgabe111.studienfaecher;

/**
 * Created by dieterbiedermann on 01.11.16.
 */
public enum Fach {
    MATHEMATIKSTUDIUM, ARCHITEKTURSTUDIUM, WIRTSCHAFTLICHEESSTUDIUM;

    public int regelstudienzeit() {
        int semester = 0;
        switch (this) {
            case MATHEMATIKSTUDIUM: semester = 2; break;
            case ARCHITEKTURSTUDIUM: semester = 4; break;
            case WIRTSCHAFTLICHEESSTUDIUM: semester = 6; break;
        }
        return semester;
    }
}
