package Others.Calculator;

import Others.Calculator.exceptions.ExpressionFormatException;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public final class ExpressionParser {

    public enum States { NOTFOUND, STARTED, FINISHED }

    public static Boolean validate(String str) throws ExpressionFormatException{

        // check correct characters: +,-,*,/,(,)
        if (!str.matches("(\\d|\\.|\\s|\\+|-|\\*|/|\\(|\\))*")) {
            throw new ExpressionFormatException("wrong characters in expression");
        }

        // check parentheses
        {
            int counter = 0;
            for (int i = 0; i < str.length(); i++) {
                char cTemp = str.charAt(i);
                switch (cTemp) {
                    case '(': {
                        counter++;
                        break;
                    }
                    case ')': {
                        counter--;
                        break;
                    }
                }
            }
            if (counter != 0) {
                throw new ExpressionFormatException("uneven number of parentheses in expression");
            }
        }

        if (str.matches(".*(\\.|\\+|\\*|/|-)\\s*(\\.|\\+|\\*|/|--).*")) {
            throw new ExpressionFormatException("wrong order of operators in expression");
        }


        return true;
    }

    public static String getFirstParentheses(String str)
    {
        States state = States.NOTFOUND;
        int counter = 0;
        StringBuffer temp = new StringBuffer("");

        for (int i = 0; i < str.length() ; i++)
        {
            char cTemp = str.charAt(i);
            switch (cTemp)
            {
                case '(':
                {
                    counter++;
                    if (state == States.NOTFOUND) {
                        state = States.STARTED;
                    } else if (state == States.STARTED) {
                        temp.append(cTemp);
                    }
                    break;
                }
                case ')':
                {
                    counter--;
                    if (state == States.NOTFOUND)
                    {  /* this is an error */ }
                    else if (state == States.STARTED)
                    {
                        if (counter == 0) {
                            state = States.FINISHED;
                        } else {
                            temp.append(cTemp);
                        }
                    }
                    break;
                }
                default:
                {
                    if (state == States.STARTED) {
                        temp.append(cTemp);
                    }
                }
            }
            if (state == States.FINISHED) {
                str = "";
            }
        }
        return temp.toString();
    }
}
