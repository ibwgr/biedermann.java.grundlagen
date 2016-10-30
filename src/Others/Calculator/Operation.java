package Others.Calculator;

import Others.Calculator.types.Operator;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public abstract class Operation extends Arithmetic{
    private double[] operands;
    private Operator operator;

    public Operation(double[] operands, Operator operator) {
        this.operands = operands;
        this.operator = operator;
        if (operands.length >= 2) {
            this.setResult(calculate(operands[0], operands[1]));
            for (int i = 2; i < operands.length; i++) {
                this.setResult(calculate(this.getResult(), operands[i]));
            }
        } else if (operands.length == 1) {
            this.setResult(operands[0]);
        } else {
            this.setResult(0);
        }
    }

    public abstract double calculate(double operand1, double operand2);

    @Override
    public String toString() {
        return Display.getOperation(operands, operator) + " = " + Display.getDouble(getResult());
    }

}
