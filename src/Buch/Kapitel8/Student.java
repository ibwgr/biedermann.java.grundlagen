package Buch.Kapitel8;
//
/**
 * Created by dieterbiedermann on 20.09.16.
 */
public class Student {

    public static final int MATHEMATIKSTUDIUM = 1;
    public static final int ARCHITEKTURSTUDIUM = 2;

    public static final int WEIBLICH = 1;
    public static final int MAENNLICH = 2;

    public static final Student PHANTOM;

    private String name;
    private int nummer, fach, geburtsjahr, geschlecht;
    private static int zaehler;

    // statischer Initialisierer, wird beim ersten Aufruf der Klasse ausgeführt!
    static {
        PHANTOM = new Student("Phantom", -12345);
        zaehler = 0;
    }

    public Student() {
        zaehler++;
    }

    public Student(String name, int nummer) {
        // Aufruf von Constructor ohne Parameter (oben)
        this();
        this.name = name;
        // setze Variable direkt oder über Getter ???
        this.nummer = nummer;
    }

    public Student(String name, int nummer, int fach, int geburtsjahr) {
        this(name, nummer);
        this.geburtsjahr = geburtsjahr;
        this.fach = fach;
    }

    public Student(String name, int nummer, int fach, int geburtsjahr, int geschlecht) {
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

    public int getFach() {
        return fach;
    }

    public void setFach(int fach) {
        this.fach = fach;
    }

    public static void setZaehler(int zaehler) {
        Student.zaehler = zaehler;
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
            case Student.WEIBLICH:
                str = str + " weiblich";
                break;
            case Student.MAENNLICH:
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
