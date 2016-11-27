package Others.Calculator;

import Others.Calculator.exceptions.ExpressionFormatException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dieterbiedermann on 26.10.16.
 *
 * Expression for basic math operations (+, -, *, /)
 *
 */
public class Expression extends Arithmetic {
    private ArrayList<Arithmetic> arithmetics = new ArrayList<>();
    private ArrayList<String> exprStrings = new ArrayList<>();
    private String input;

    public Expression(String str) { // example 1 + 2 + 3
        String tempStr = str.replaceAll("\\s", "");
        input = str;

        // Validation
        try {
            Boolean check = ExpressionParser.validate(str);
        } catch (ExpressionFormatException e) {
//            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }

        // Calculate
        // 1. parentheses
        // 2. *, /
        // 3. +, -
        // find parentheses with parser
        exprStrings.add(tempStr);
        String parenthesesStr = ExpressionParser.getFirstParentheses(tempStr);
        while (!parenthesesStr.isEmpty()) {
            arithmetics.add(new Expression(parenthesesStr));
            parenthesesStr = "(" + parenthesesStr + ")";
            tempStr = tempStr.replaceFirst(parenthesesStr.replaceAll(
                    "[<(\\[{\\\\\\^\\-=$!|\\]\\})‌​?*+.>]", "\\\\$0")
                    , Display.getDouble(arithmetics.get(arithmetics.size()-1).getResult()));
            exprStrings.add(tempStr);
            parenthesesStr = ExpressionParser.getFirstParentheses(tempStr);
        }
        while (!tempStr.matches("^-?\\d*\\.?\\d*E*\\d*$")) {
            // find *,/
            Pattern pattern2 = Pattern.compile("(^|\\s*)-?\\d+\\.?\\d*\\s*(\\*|/)\\s*-?\\d+\\.?\\d*($|\\s*)");
            Matcher matcher2 = pattern2.matcher(tempStr);
            while (matcher2.find()) {
                String matchStr = matcher2.group();
                String[] s = matchStr.replaceAll("(\\s*|^|$)", "").split("\\s*(\\*|/)\\s*");
                double[] d = {Double.valueOf(s[0]), Double.valueOf(s[1])};
                if (matchStr.matches(".*\\*.*")) {
                    arithmetics.add(new Multiplication(d));
                } else {
                    arithmetics.add(new Division(d));
                }
                tempStr = tempStr.replaceFirst(matchStr.replaceAll(
                        "[<(\\[{\\\\\\^\\-=$!|\\]\\})‌​?*+.>]", "\\\\$0")
                        , Display.getDouble(arithmetics.get(arithmetics.size()-1).getResult()));
                exprStrings.add(tempStr);
                //this.setResult(arithmetics.get(arithmetics.size()-1).getResult());
            }
            // find +,-
            Pattern pattern3 = Pattern.compile("(^|\\s*)-?\\d+\\.?\\d*\\s*(\\+|-)\\s*-?\\d+\\.?\\d*($|\\s*)");
            Matcher matcher3 = pattern3.matcher(tempStr);
            while (matcher3.find()) {
                String matchStr = matcher3.group();
                String[] s = matchStr.replaceAll("(\\s*|^|$)", "").split("\\s*(\\+|(?<=\\d)-)\\s*");
                double[] d = {Double.valueOf(s[0]), Double.valueOf(s[1])};
                if (matchStr.matches(".*\\+.*")) {
                    arithmetics.add(new Addition(d));
                } else {
                    arithmetics.add(new Subtraction(d));
                }
                tempStr = tempStr.replaceFirst(matchStr.replaceAll(
                        "[<(\\[{\\\\\\^\\-=$!|\\]\\})‌​?*+.>]", "\\\\$0")
                        , Display.getDouble(arithmetics.get(arithmetics.size()-1).getResult()));
                exprStrings.add(tempStr);
                //this.setResult(arithmetics.get(arithmetics.size()-1).getResult());
            }
        }
        this.setResult(Double.valueOf(tempStr));
        //System.out.println("Result => "+this);
        //System.out.println(this.getSteps());

    }

    public String getSteps() {
        String str = "";

        //str = str + "Size:"+arithmetics.size() + "\n";
        for (Arithmetic a : arithmetics) {
            if (a instanceof Expression) {
                str = str + ((Expression) a).getSteps();
            } else {
                str = str + a + "\n";
            }
        }
        return str;
    }

    public String getAllExprStr() {
        String str = "";
/*
        for (String s : exprStrings) {
            str = str + s + "\n";
        }
*/

        for (int i = 0; i < exprStrings.size(); i++) {
            str = str + exprStrings.get(i) + "\n";
            if (i < arithmetics.size()
                    && arithmetics.get(i) != null) {
                if (arithmetics.get(i).getClass() == Expression.class) {
                    str = str + ((Expression) arithmetics.get(i)).getAllExprStr();
//                } else {
//                    str = str + arithmetics.get(i) + "\n"; // rechnung anzeigen
                }
            }
        }

        if (str.isEmpty()) {
            str = Display.getDouble(getResult());
        }
        return str;
    }

    public ArrayList<String> getAllExpr() {
        return exprStrings;
    }

    @Override
    public String toString() {
        return input + " = " + Display.getDouble(getResult());
    }

}
