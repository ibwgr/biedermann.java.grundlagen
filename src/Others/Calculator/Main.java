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

        Expression expr = new Expression(str);

        System.out.println("Result => ");
        System.out.println(expr.getSteps());

    }
}
