
package Uebungen.TaschenrechnerUebung;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/** Die Repraesentionsklasse (View) unseres Taschenrechners erweitert
 *  die Klasse JPanel und erbt damit alle Eigenschaften von JPanel.
 *  Die Repraesentionsklasse ist damit (u.a.) eine (J)Komponente
 *  und kann somit in beliebigen (J)Containern plaziert werden. 
 *   
 */
public class CalculatorView extends JPanel{
    
    /* private Referenz auf die Anzeige des Taschenrechners */ 
    private JTextField anzeige;
    private ArrayList<JButton> buttons = new ArrayList<>();
    
    public CalculatorView(){
        // Die folgenden beiden Kommentarzeilen muessen wir
        // fuer die letzte Aufgabe wieder einkommentieren
        // +++++++++++++++++++++++++++++++++
        CalculatorModel cm = new CalculatorModel();
        CalculatorController cc = new CalculatorController(this,cm);
        
        /* BorderLayout */
        setLayout(new BorderLayout());
       
        /* Anzeige erzeugen und in die Mitte platzieren */
        anzeige = new JTextField();
        add(anzeige,BorderLayout.CENTER);
       
        /* temporaeres Panel erzeugen und im Sueden platzieren */
        JPanel tmp = new JPanel(new GridLayout(4,5));
        add(tmp,BorderLayout.SOUTH);
        
        // Das temporaere Panel muss nun noch mit Inhalt
        // gefuellt werden. Damit eine aehnliche Repraesention
        // wie auf den Folien erreicht wird, dafuer brauchen wir JButtons
        // fuer die Ziffern '0' ... '9' , '.' und Operatoren
        // '+','-','*','-','=','C' sowie (leere) JLabels um nicht
        // benoetigten Luecken im Grid zu fuellen.
        // Hinweis : Das GridLayout wird von links nach rechts und
        // von oben nach unten gefuellt ...

        for (int i = 0; i < 17; i++) {
            buttons.add(new JButton(""));
        }
  
        buttons.get(0).setText("7");
        buttons.get(1).setText("8");
        buttons.get(2).setText("9");

        buttons.get(3).setText("+");
        buttons.get(4).setText("-");

        buttons.get(5).setText("4");
        buttons.get(6).setText("5");
        buttons.get(7).setText("6");

        buttons.get(8).setText("*");
        buttons.get(9).setText("/");

        buttons.get(10).setText("1");
        buttons.get(11).setText("2");
        buttons.get(12).setText("3");

        buttons.get(13).setText("=");
        buttons.get(14).setText("C");

        buttons.get(15).setText("0");
        buttons.get(16).setText(".");

        for (JButton button : buttons) {
            button.setActionCommand(button.getText());
            button.addActionListener(cc);
            tmp.add(button);
        }
    }
    
    
    /**
     * Setter Methode um den Anzeigentext zu manipulieren 
     * 
     * @param text - String 
     */
    public void setAnzeige(String text){
        anzeige.setText(text);
    }

  

}
