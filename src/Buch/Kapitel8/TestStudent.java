package Buch.Kapitel8;

/**
 * Created by dieterbiedermann on 20.09.16.
 */
public class TestStudent {
    public static void main(String[] args) {
        System.out.println("Anzahl Studenten: " + Student.getZaehler());
        System.out.println("Phantom: " + Student.PHANTOM);


        Student student1 = new Student();

        student1.setName("Hans");
        student1.setNummer(11111);
        student1.setFach(Student.ARCHITEKTURSTUDIUM);

        Student student2 = new Student("John", 221122);
        Student student3 = new Student("Eva", 223332);
        Student student4 = new Student("Klara", 223399, Student.MATHEMATIKSTUDIUM, 1966);
        Student student5 = new Student("Peter", 883332, Student.MATHEMATIKSTUDIUM, 1979, Student.MAENNLICH);

        // System.out.println((student1.validateNummer() ? "true" : "false"));
        // System.out.println(student1.toString());
        System.out.println(student1);

        System.out.println(student4);
        System.out.println(student5);

        System.out.println("Anzahl Studenten: " + Student.getZaehler());
    }
}
