package Buch.Kapitel8;
//
/**
 * Created by dieterbiedermann on 20.09.16.
 */
public class Student {

    private String name;

    private int nummer;

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

    public boolean validateNummer() {
        return (nummer >= 10000 && nummer <= 99999 && nummer % 2 != 0);
    }

    public boolean checkSomething() {
        // do something
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nummer=" + nummer +
                '}';
    }
}
