package Others.Calculator;

import Others.Calculator.types.*;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class Addition extends Operation {

    public Addition(double[] operands) {
        super(operands, Operator.ADDITION);
    }

    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }

}
