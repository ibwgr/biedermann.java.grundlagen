package Buch.Kapitel9.Aufgabe912;

import Prog1Tools.IOTools;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created by dieterbiedermann on 24.10.16.
 */
public class DSpiel {
    public static void main(String[] args) {
        char x;
        int y;
        String farbe;
        int count = 0;

        System.out.println("Positionieren sie die Beute");
        x = IOTools.readChar("Spalte (A bis H) ihrere Figur? ");
        y = IOTools.readInt("Zeile (1 bis 8) ihrer Figur? ");
        farbe = IOTools.readString("Farbe ihrer Figur? ");

        DameFigur beute = new DameFigur(x, y, farbe);

        Bildschirm.loeschen();

        System.out.println("Die Beute steht. Positionieren sie den Jaeger");
        x = IOTools.readChar("Spalte (A bis H) ihrere Figur? ");
        y = IOTools.readInt("Zeile (1 bis 8) ihrer Figur? ");
        farbe = IOTools.readString("Farbe ihrer Figur? ");

        DameFigur jaeger = new DameFigur(x, y, farbe);

        while (!jaeger.trifft(beute) && count <= 10) {
            if (count == 0) {
                System.out.println("Die Beute steht woanders!");
                System.out.println("Sie haben nun 10 Dame-Zuege, um die Beute-Figur zu treffen.");
            } else {
                System.out.println("Leider kein Treffer!");
            }

            System.out.println(jaeger);
            System.out.println("Bewegen sie ihre Figur");

            x = IOTools.readChar("Wollen sie waagrecht(-), senkrecht(|) oder diagonal(/, \\) ziehen? ");
            y = IOTools.readInt("Wie viele Felder zeihen? (> 0 nach rechts oben, < 0 nach links unten) ");

            jaeger.ziehe(x, y);

            count++;
        }

        if (count <= 10) {
            System.out.println("Treffer! sie (als Jaeger) haben gewonnen");
        } else {
            System.out.println("Der Jaeger hat bereits 10 mal die Figur bewegt");
            System.out.println("Beute wurde nicht gefunden. Sie (als Jaeger) haben verloren");
        }

    }

}
