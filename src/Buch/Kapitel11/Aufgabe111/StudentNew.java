package Buch.Kapitel11.Aufgabe111;
//

import Buch.Kapitel11.Aufgabe111.studienfaecher.Fach;

/**
 * Created by dieterbiedermann on 20.09.16.
 */
public class StudentNew {

    public static final int MATHEMATIKSTUDIUM = 1;
    public static final int ARCHITEKTURSTUDIUM = 2;

    public static final int WEIBLICH = 1;
    public static final int MAENNLICH = 2;

    public static final StudentNew PHANTOM;

    private String name;
    private int nummer, geburtsjahr, geschlecht;
    private Fach fach;
    private static int zaehler;

    // statischer Initialisierer, wird beim ersten Aufruf der Klasse ausgeführt!
    static {
        PHANTOM = new StudentNew("Phantom", -12345);
        zaehler = 0;
    }

    public StudentNew() {
        zaehler++;
    }

    public StudentNew(String name, int nummer) {
        // Aufruf von Constructor ohne Parameter (oben)
        this();
        this.name = name;
        // setze Variable direkt oder über Getter ???
        this.nummer = nummer;
    }

    public StudentNew(String name, int nummer, Fach fach, int geburtsjahr) {
        this(name, nummer);
        this.geburtsjahr = geburtsjahr;
        this.fach = fach;
    }

    public StudentNew(String name, int nummer, Fach fach, int geburtsjahr, int geschlecht) {
        this(name, nummer, fach, geburtsjahr);
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        int alteNummer = this.nummer;
        this.nummer = nummer;
        if (!validateNummer()) {
            this.nummer = alteNummer;
        }
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

    public static void setZaehler(int zaehler) {
        StudentNew.zaehler = zaehler;
    }

    public boolean validateNummer() {
        return (nummer >= 10000 && nummer <= 99999 && nummer % 2 != 0);
    }

    public boolean checkSomething() {
        // do something
        return true;
    }

    @Override
    public String toString() {
        String str;
        str = name + " (" + nummer + ")";
        switch (geschlecht) {
            case StudentNew.WEIBLICH:
                str = str + " weiblich";
                break;
            case StudentNew.MAENNLICH:
                str = str + " maennlich";
                break;
            default:
                str = str + " kein geschlecht";
        }

        return str;
    }

    public static int getZaehler() {
        return zaehler;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }
}
