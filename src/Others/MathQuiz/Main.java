package Others.MathQuiz;

import java.util.Scanner;

/**
 * Created by dieterbiedermann on 28.08.16.
 */
public class Main {
    public static void main (String[] args) {

/*        Dog dogObj = new Dog("Strolch");
        Cat catObj = new Cat("Susi");

        dogObj.makeSound();

        catObj.makeSound();
*/
        int score = 0;
        String input;

        Scanner scan = new Scanner(System.in);
        Stats statsObj = new Stats();

        for (int i = 1; i <= 10; i++) {
            Calc calcObj = new Calc();
            System.out.print(calcObj.getCalc() + " = ");

            input = scan.nextLine();
            // input validation
            while (input.isEmpty() || !input.matches("^-?\\d+$")) {
                System.out.println(" --> input is empty or not an integer");
                input = scan.nextLine();
            }

            // check input
            if (calcObj.checkResult(Integer.valueOf(input), statsObj)) {

                System.out.println(" --> correct ");
            } else {
                System.out.println(" --> false (correct answer: " + calcObj.getResult() + ")");
            }

        }
        System.out.println("You made " + statsObj.getScore() + " Scores!");

        System.out.println("Check your calculations:");
        for (Calc c : statsObj.calcList) {
            if (c.getAnswerCorrect()) {
                System.out.println(c.getCalc() + " = " + c.getAnswer() + " --> correct");
            } else {
                System.out.println(c.getCalc() + " = " + c.getAnswer() + " --> false (correct answer: " + c.getResult() + ")");
            }
        }
    }
}
