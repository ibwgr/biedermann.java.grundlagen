package Uebungen.Pizzastore;

import Prog1Tools.IOTools;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by dieterbiedermann on 20.10.16.
 */
public class Main {

    public static void main(String[] args) {

        Pizza[] pizzas = new Pizza[10];
        int choice, choice2;
        int count = 0;
        double total = 0;

        choice = IOTools.readInt("Pizza auswählen (1=Margherita, 2=Napolitana, 0=Ende): ");

        while (choice > 0  && count <= 10) {
            switch (choice) {
                case 1:
                    do {
                        choice2 = IOTools.readInt("Grösse wählen (1=klein, 2=mittel, 3=gross): ");
                    } while(choice2 < 1 || choice2 > 3);
                    pizzas[count] = new PizzaMargherita(choice2);
                    System.out.println("--- OK ---");
                    break;
                case 2:
                    pizzas[count] = new PizzaNapolitana();
                    System.out.println("--- OK ---");
                    break;
                default:
                    System.out.println("--- falsche Eingabe ---");
                    break;
            }
            count++;
            choice = IOTools.readInt("Pizza auswählen (1=Margherita, 2=Napolitana, 0=Ende): ");
        }

        System.out.println("-----------------------------------");
        System.out.println("Folgende Pizzas hast du ausgewählt:");
        System.out.println("-----------------------------------");

        for (int i = 0; i < 10; i++) {
            if (pizzas[i] != null) {
                System.out.println(pizzas[i]);
                total = total + pizzas[i].getPreis();
            }
        }

        System.out.println("-----------------------------------");
        System.out.println("Pizzas kosten total: " + total);
        System.out.println("===================================");
    }

}
