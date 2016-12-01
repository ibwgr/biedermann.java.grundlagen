package Buch.Kapitel9.Aufgabe911;

/**
 * Created by dieterbiedermann on 23.10.16.
 */
public class GelochtePlatte extends MetallPlatte {
    private int anzahlLoecher, lochLaenge, lochBreite;
    private MetallPlatte[] loch;

    public GelochtePlatte(double laenge, double breite, int m) {
        super(laenge, breite);
        anzahlLoecher = m;
        lochLaenge = 1 / m;
        lochBreite = 1 / m;
        loch = new MetallPlatte[m];
//        loch[0] = new MetallPlatte(lochLaenge, lochBreite);
    }

    public void neuesLochStanzen() {
        for (int i = 0; i < loch.length; i++) {
            if (loch[i] == null) {
                loch[i] = new MetallPlatte(lochLaenge, lochBreite);
            }
        }
    }

    public double flaeche() {
        double flaeche;
        flaeche = super.flaeche();
        for (int i = 0; i < loch.length; i++) {
            flaeche = loch[i].flaeche();
        }
        return flaeche;
    }
}
