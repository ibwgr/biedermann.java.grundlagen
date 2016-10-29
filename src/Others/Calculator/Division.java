package Others.Calculator;

import Others.Calculator.types.Operator;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class Division extends Operation {

    public Division(double[] operands) {
        super(operands, Operator.DIVISION);
    }

    public double calculate(double operand1, double operand2) {
        return operand1 / operand2;
    }

}
