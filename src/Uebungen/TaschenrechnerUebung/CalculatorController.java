package Uebungen.TaschenrechnerUebung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Die Steuerungsklasse (Controller) des Taschenrechners implementiert
 * die Klasse 'ActionListener'.
 */
public class CalculatorController implements ActionListener {
    
    /* private Referenz auf die Repraesentation */
    private CalculatorView cv;
    /* private Referenz auf das Modell */
    private CalculatorModel cm;
    
    
    /** 
     * Konstruktor
     * 
     * @param cv - Referenz auf die Repraesentation
     * @param cm - Referenz auf den Controller
     */
    public CalculatorController(CalculatorView cv, CalculatorModel cm){
        this.cv = cv;
        this.cm = cm;
        
    }

 
    /**
     * Implementierung der Funktion 'actionPerformed' von dem Interface
     * ActionListener 
     * 
     * @param e - ActionEvent e
     */
    public void actionPerformed(ActionEvent e) {
        /* Zunaechst betrachten wir die Ereignisse die einer
           gesonderten Behandlung beduerfen; die Operatoren.
           Die Ziffern koennen gemeinsam betrachtet werden. */
        if (e.getActionCommand().equals("+")) {
            if (cm.getOperator() == null) {
                cm.setOperator(CalculatorModel.PLUS);
                cm.setAnzeigenText(cm.getAnzeigenText() + e.getActionCommand());
                cv.setAnzeige(cm.getAnzeigenText());
            }
        } else if (e.getActionCommand().equals("-")) {
            if (cm.getOperator() == null) {
                cm.setOperator(CalculatorModel.MINUS);
                cm.setAnzeigenText(cm.getAnzeigenText() + e.getActionCommand());
                cv.setAnzeige(cm.getAnzeigenText());
            }
        } else if (e.getActionCommand().equals("*")) {
            if (cm.getOperator() == null) {
                cm.setOperator(CalculatorModel.MAL);
                cm.setAnzeigenText(cm.getAnzeigenText() + e.getActionCommand());
                cv.setAnzeige(cm.getAnzeigenText());
            }
        } else if (e.getActionCommand().equals("/")) {
            if (cm.getOperator() == null) {
                cm.setOperator(CalculatorModel.DURCH);
                cm.setAnzeigenText(cm.getAnzeigenText() + e.getActionCommand());
                cv.setAnzeige(cm.getAnzeigenText());
            }
        } else if (e.getActionCommand().equals("=")) {
            cm.setAnzeigenText(cm.getAnzeigenText() + "=" + String.valueOf(cm.berechne()));
            cv.setAnzeige(cm.getAnzeigenText());
            cm.reset();

        // Die Ereignisbehandlung fuer die Operatoren '-',
        // '*','/' und '=' muessen an dieser Stelle aehnlich 
        // implementiert werden.
        // +++++++++++++++++++++++++++++++++++++++++++++++
        } else if (e.getActionCommand().equals("C")){
            cm.reset();
            cv.setAnzeige("");
        } else if (e.getActionCommand().equals(".")){
            if (!cm.getCurrentBuffer().toString().matches(".*\\.+.*")) {
                cm.addZiffer(e.getActionCommand().charAt(0));
                cv.setAnzeige(cm.getAnzeigenText());
            }
        } else {
            // Die Ereignisbehandlung fuer die Ziffern
            // kann geschickt zusammengefasst werden!
            // Hinweis : e.getActionCommand() ...
            cm.addZiffer(e.getActionCommand().charAt(0));
            cv.setAnzeige(cm.getAnzeigenText());
        }
             
        
    }

}
