package Others.Calculator;

import Others.Calculator.types.Operator;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class Multiplication extends Operation {

    public Multiplication(double[] operands) {
        super(operands, Operator.MULTIPLICATION);
    }

    public double calculate(double operand1, double operand2) {
        return operand1 * operand2;
    }

}
