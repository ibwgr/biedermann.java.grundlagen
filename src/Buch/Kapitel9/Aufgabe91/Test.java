package Buch.Kapitel9.Aufgabe91;

/**
 * Created by dieterbiedermann on 04.10.16.
 */
public class Test {

    public static void main(String[] args) {

        DM dm = new DM(100);
        DM dm2 = new DM(10);

        System.out.println(dm.equals(dm2));

        System.out.println(dm.hashCode());

        System.out.println(dm.toString());

        System.out.println(dm instanceof Euro);

        //dm instanceof Euro

    }

}
