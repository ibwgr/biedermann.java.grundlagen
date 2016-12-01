package Buch.Kapitel9.Aufgabe917;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class Strecke {
    private Point p, q;


    public Strecke(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    public String toString() {
        return p + "_" + q;
    }

    public double getLaenge() {
        return Point.distance(p,q);
    }

    public void turn (double phi) {
        p.turn(phi);
        q.turn(phi);
    }
}
