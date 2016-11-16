package Others.Calculator;

import java.util.Scanner;

/**
 * Created by dieterbiedermann on 25.10.16.
 */
public class Main {
    public static void main(String[] args) {

        String str;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Math Expression => ");
        str = scan.nextLine();

        try {
            Expression expr = new Expression(str);
            System.out.println("Result => ");
            System.out.println(expr.getAllExprStr());
            //System.out.println(expr.getSteps());
        } catch (IllegalArgumentException | ArithmeticException ex) {
            System.out.println("Error in Expression => " + ex.getMessage());
        }

    }
}
