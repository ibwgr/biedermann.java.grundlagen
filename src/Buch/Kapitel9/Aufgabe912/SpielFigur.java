package Buch.Kapitel9.Aufgabe912;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class SpielFigur {
    private char xPos;

    private int yPos;

    private String farbe;

    public SpielFigur (char x, int y, String f) {
        xPos = x;
        yPos = y;
        farbe = f;

        korrigierePosition();
    }

    private void korrigierePosition() {
        if (xPos < 'A') {
            xPos = 'A';
        } else if (xPos > 'H') {
            xPos = 'H';
        }
        if (yPos < 1) {
            yPos = 1;
        } else if (yPos > 8) {
            yPos = 8;
        }
    }

    public char getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public String getFarbe() {
        return farbe;
    }

    public void ziehe (int xF, int yF) {
        xPos = (char) (xPos + xF);
        yPos = yPos + yF;
        korrigierePosition();
    }

    public String toString() {
        return farbe + "e Figur auf Feld " + xPos + yPos;
    }
}
