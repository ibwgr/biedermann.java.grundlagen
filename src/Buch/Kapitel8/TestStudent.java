package Buch.Kapitel8;

/**
 * Created by dieterbiedermann on 20.09.16.
 */
public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student();

        student1.setName("Hans");
        student1.setNummer(11111);
        System.out.println((student1.validateNummer() ? "true" : "false"));
        System.out.println(student1);
    }
}
