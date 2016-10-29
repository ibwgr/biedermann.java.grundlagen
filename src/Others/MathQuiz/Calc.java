package Others.MathQuiz;

import java.util.Random;

/**
 * Created by dieterbiedermann on 28.08.16.
 */
public class Calc {
    static Random random = new Random();

    int operand1, operand2, result, operator, answer;
    boolean isAnswerCorrect;

    Calc() {
        setOperator(random.nextInt(4)+1);
        switch (getOperator()) {
            case 1:
                setOperand1(random.nextInt(100));
                setOperand2(random.nextInt(100));
                setResult(getOperand1() + getOperand2());
                break;
            case 2:
                setOperand1(random.nextInt(100));
                setOperand2(random.nextInt(50));
                setResult(getOperand1() - getOperand2());
                break;
            case 3:
                setOperand1(random.nextInt(30));
                setOperand2(random.nextInt(10));
                setResult(getOperand1() * getOperand2());
                break;
            case 4:
                setOperand1(random.nextInt(600));
                setOperand2(random.nextInt(20));
                setResult(getOperand1() / getOperand2());
                break;
        }
    }

    public String getCalc() {
        String str = "";
        switch (getOperator()) {
            case 1:
                str = getOperand1() + " + " + getOperand2();
                break;
            case 2:
                str = getOperand1() + " - " + getOperand2();
                break;
            case 3:
                str = getOperand1() + " * " + getOperand2();
                break;
            case 4:
                str = getOperand1() + " : " + getOperand2();
                break;
        }
        return str;
    }

    public boolean checkResult(int input, Stats statsObj) {
        setAnswer(input);
        if (input == this.getResult()) {
            setAnswerCorrect(true);
            statsObj.addScore(1);
            statsObj.addCalcList(this);
            return true;
        } else {
            setAnswerCorrect(false);
            statsObj.addCalcList(this);
        }
        return false;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setAnswerCorrect(boolean answerCorrect) {
        isAnswerCorrect = answerCorrect;
    }

    public boolean getAnswerCorrect() {
        return isAnswerCorrect;
    }
}
