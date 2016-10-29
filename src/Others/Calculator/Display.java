package Others.Calculator;

import Others.Calculator.types.*;

import java.util.regex.Pattern;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public final class Display {
    public static String getDouble(double operand) {
        String str = "";
        // Format the double correctly (without useless zeros)
        str = str + Double.toString(operand).replaceAll("\\.0$","");
        return str;
    }
    public static String getOperation(double[] operands, Operator operator) {
        String str = "";
        for (int i = 0; i < operands.length; i++) {
            // Format the double correctly (without useless zeros)
            str = str + getDouble(operands[i])
                    + (i < operands.length - 1 ? " " + operator + " ": "");
        }
        return str;
    }
}
