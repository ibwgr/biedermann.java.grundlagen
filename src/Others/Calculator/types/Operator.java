package Others.Calculator.types;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public enum Operator {
    MULTIPLICATION, DIVISION, ADDITION, SUBTRACTION;

    public String toString() {
        String str = "";
        switch (this) {
            case MULTIPLICATION:    str = "*"; break;
            case DIVISION:          str = "/"; break;
            case ADDITION:          str = "+"; break;
            case SUBTRACTION:       str = "-"; break;
        }
        return str;
    }
}
