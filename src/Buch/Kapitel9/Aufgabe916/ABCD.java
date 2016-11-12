package Buch.Kapitel9.Aufgabe916;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class ABCD {
    public static void main(String[] args) {
        A a = new A();
        a.tell();
        B b = new B();
        b.tell();
        System.out.println(b.a);
        a = b;
        a.tell();
        System.out.println(a.a);
        C c = new C();
        c.tell();
        D d = new D();
        d.tell();
    }
}
