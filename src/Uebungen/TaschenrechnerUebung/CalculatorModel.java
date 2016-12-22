package Uebungen.TaschenrechnerUebung;

/**
 * Das Modell unseres (einfachen) Taschenrechners.
 * 
 * Alle Kommentare die mit zwei Slashes (//) beginnen
 * sind ein Hinweis auf fehlende Logik, die von euch
 * implementiert werden muss.
 */
public class CalculatorModel {

        /* Konstanten */
        public static final int PLUS = 0;
        public static final int MINUS = 1;
        public static final int MAL = 2;
        public static final int DURCH = 3;
        
        /* Objektvariablen */
        private Double operand1;
        private Double operand2;
        private Integer operator;

        /* Objekt(-hilfs-)variablen */
        private StringBuffer currentBuffer = new StringBuffer();
        private String anzeigenText = "";
        
        
        /**
         * Berechnet <operand1> (operator) <operand2>.
         * 
         * @return Ergebnis in doppelter Genauigkeit
         */
        public Double berechne(){
            Double ergebnis = null;
            
            // Die berechne() Funktion muss noch vervollstaendigt
            // werden. Bevor eine Berechnung durchgefuehrt
            // werden kann muss sichergestellt sein, das der
            // Operand2 einen Wert enthaelt (vgl. setOperator)
            // und der Operator gesetzt ist. Falls das nicht der 
            // Fall ist sollten "sinnvolle" Werte "berechnet" werden.
            // - Operand2 bzw. Buffer leer => Operand1
            // - Operator nicht gesetzt => 0.0

            if ((currentBuffer.length() > 0) && (this.operator != null)) {
                operand2 = Double.parseDouble(currentBuffer.toString());
                currentBuffer.setLength(0);
            }

            if ((currentBuffer.length() > 0) && (this.operator == null)) {
                operand1 = Double.parseDouble(currentBuffer.toString());
                currentBuffer.setLength(0);
            }

            if (operand2 == null) {
                return operand1;
            }

            switch (operator) {
                case (CalculatorModel.PLUS):
                    ergebnis = operand1 + operand2;
                    break;

                case (CalculatorModel.MINUS):
                    ergebnis = operand1 - operand2;
                    break;
                case (CalculatorModel.MAL):
                    ergebnis = operand1 * operand2;
                    break;
                case (CalculatorModel.DURCH):
                    ergebnis = operand1 / operand2;
                    break;
                default:
                    ergebnis = 0.0;
                    break;
                // Die Operatoren MINUS, MAL, DURCH
                // muessen noch hinzugefuegt werden.
            }
            return ergebnis;
        }
        
        /** 
         * Fuegt eine Ziffer dem Buffer hinzu ...
         * 
         * @param ziffer - Zahl als Character 
         * 
         * @return Gibt den aktuellen Buffer als String zurueck.
         */
        public String addZiffer(char ziffer){
            currentBuffer.append(ziffer);
            anzeigenText = anzeigenText + ziffer;
            return currentBuffer.toString();
        }
        
        
        /**
         * Setzt den Operator fuer die berechne Funktion.
         * 
         * @param operator
         */
        public void setOperator(int operator){
            /* Wenn wir einen Operator hinzufuegen
             * muss der Inhalt des aktuellen Buffers
             * dem 1. Operanden zugewiesen werden (Infix).
             * Achtung! Ein fehlerhafter Buffer(String)
             * erzeugt bei der Konvertierung eine NumberFormat
             * Exception, die durch folgende Implementierung
             * NICHT abgefangen wird! */
            if ((currentBuffer.length() > 0) && (this.operator == null)) {
                operand1 = Double.parseDouble(currentBuffer.toString());
                currentBuffer.setLength(0);
                this.operator = operator;
            }
        }
        
        /**
         * Setzt das Modell zurueck (auf Initialisierungswerte ...)
         */
        public void reset(){
            // Dazu ist, glaube ich, keine weitere Erklaerung notwendig ...
            operand1 = null;
            operand2 = null;
            operator = null;
            anzeigenText = "";
            currentBuffer = new StringBuffer();
        }

        public StringBuffer getCurrentBuffer() {
            return currentBuffer;
        }

    public Integer getOperator() {
        return operator;
    }

    public String getAnzeigenText() {
        return anzeigenText;
    }

    public void setAnzeigenText(String anzeigenText) {
        this.anzeigenText = anzeigenText;
    }

    /*
             * Die Mainmethode enthaelt ein paar einfache Tests
             * um die Funktionsweise eures Modells zu testen.
             *
             */
        public static void main (String args []){
            try {
            CalculatorModel cm = new CalculatorModel();
            /* 5.4 + 3 */
            cm.addZiffer('5');
            cm.addZiffer('.');
            cm.addZiffer('4');
            cm.setOperator(PLUS);
            cm.addZiffer('3');
            Double ergb = cm.berechne();
            if (ergb == 8.4){
                System.out.println("Test '+' erfolgreich!       :: 5.4+3 == 8.4");
            } else {
                System.out.println("Test '+' NICHT erfolgreich! :: 5.4+3 != "+ergb);
            }
            /* Modell zuruecketzen */
            cm.reset();
            /*251 - 5 */
            cm.addZiffer('2');
            cm.addZiffer('5');
            cm.addZiffer('1');
            cm.setOperator(MINUS);
            cm.addZiffer('5');
            ergb = cm.berechne();
            if (ergb == 246) {
                System.out.println("Test '-' erfolgreich!       :: 251-5 == 246");
            } else {
                System.out.println("Test '-' NICHT erfolgreich! :: 251-5 != "+ergb);
            }
            /* Modell zuruecketzen */
            cm.reset();
            /*160 / 20 */
            cm.addZiffer('1');
            cm.addZiffer('6');
            cm.addZiffer('0');
            cm.setOperator(DURCH);
            cm.addZiffer('2');
            cm.addZiffer('0');
            ergb = cm.berechne();
            if (ergb == 8) {
                System.out.println("Test '/' erfolgreich!       :: 160/20 == 8");
            } else {
                System.out.println("Test '/' NICHT erfolgreich! :: 160/20 != "+ergb);
            }
            /* Modell zuruecksetzen */
            cm.reset();
            /* 2.1 * 2.2 */
            cm.addZiffer('2');
            cm.addZiffer('.');
            cm.addZiffer('1');
            cm.setOperator(MAL);
            cm.addZiffer('2');
            cm.addZiffer('.');
            cm.addZiffer('2');
            ergb = cm.berechne();
            if (ergb == (2.1*2.2)) {
                System.out.println("Test '*' erfolgreich!       :: 2.1*2.2 == 4.62");
            } else {
                System.out.println("Test '*' NICHT erfolgreich! :: 2.1*2.2 != "+ergb);
            }
            /* Modell zuruecksetzen */
            cm.reset();
            /* Operator nicht gesetzt */
            cm.addZiffer('5');
            ergb = cm.berechne();
            if (ergb == 0.0) {
                System.out.println("Test 'Operator nicht gesetzt' erfolgreich! 0.0 == 0.0");
            } else {
                System.out.println("Test 'Operator nicht gesetzt' NICHT erfolgreich ! 0.0 != "+ergb);
            }
            /* Modell zuruecksetzen */
            cm.reset();
            /* Operand2 leer bzw. nicht gesetzt */
            cm.addZiffer('5');
            cm.setOperator(PLUS);
            ergb = cm.berechne();
            if (ergb == 5) {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' erfolgreich! 5 == 5");
            } else {
                System.out.println("Test 'Operand2 leer bzw. nicht gesetzt' NICHT erfolgreich! 5 != "+ergb);
            }
            } catch (NullPointerException ex) {
                System.out.println("Die Methoden 'public void berechen()' und 'public void reset()' muessen implementiert werden!");
            }
            
            
            
        }
        
}
