package Buch.Kapitel9.Aufgabe912;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class DameFigur extends SpielFigur {
    private final String name = "Dame";

    public DameFigur(char x, int y, String f) {
        super(x, y, f);
    }

    public void ziehe(char richtung, int anzahlFelder) {
        switch (richtung) {
            case '|':
                ziehe(0, anzahlFelder);
                break;
            case '/':
                ziehe(anzahlFelder, anzahlFelder);
                break;
            case '\\':
                ziehe(anzahlFelder, anzahlFelder);
                break;
            case '-':
                ziehe(anzahlFelder, 0);
                break;
        }
    }

    public boolean trifft(SpielFigur sf) {
        return (this.getXPos() == sf.getXPos() && this.getYPos() == sf.getYPos());
    }

    @Override
    public String toString() {
        return getFarbe() + "e Dame auf Feld " + getXPos() + getYPos();
    }
}
