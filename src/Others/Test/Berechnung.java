package Others.Test;

/**
 * Created by dieterbiedermann on 23.08.16.
 */
public class Berechnung {

    public static void main(String[] args) {

        int d, z, m = 1;
        int d2, z2, m2 = 1;
        int[] zList = new int[10];
        int i = 0;
        int number1 = 252;
        int number2 = 12;
        String operator = "/";
        String str = "";

        if (number1 > 10 || number2 > 10) {
            switch (operator) {
                case "+":
                    d = number2;
                    str = str + number1;
                    while (d > 0) {
                        z = (d % 10) * m;
                        d /= 10;
                        m *= 10;
                        zList[i++] = z;
                    }
                    for (int j = i-1; j >= 0; j--) {
                        if (zList[j] > 0) {
                            str = str + " " + operator + " " + zList[j];
                        }
                    }
                    str = str + " = ___";
                    break;
                case "-":
                    d = number2;
                    str = str + number1;
                    while (d > 0) {
                        z = (d % 10) * m;
                        d /= 10;
                        m *= 10;
                        zList[i++] = z;
                    }
                    for (int j = i-1; j >= 0; j--) {
                        if (zList[j] > 0) {
                            str = str + " " + operator + " " + zList[j];
                        }
                    }
                    str = str + " = ___";
                    break;
                case "x":
                    d = number1;
                    while (d > 0) {
                        z = (d % 10) * m;
                        d /= 10;
                        m *= 10;
                        d2 = number2;
                        m2 = 1;
                        while (d2 > 0) {
                            z2 = (d2 % 10) * m2;
                            d2 /= 10;
                            m2 *= 10;
                            if (z > 0 && z2 > 0) {
                                str = str + z + " " + operator + " " + z2 + " = ___" + "\n";
                            }
                        }
                    }
                    break;
                case "/":
                    // 144 / 12 ???
                    z = 0;
                    d = number1;
                    for (int j = 10; d >= (number2 * j); j += 10) {
                        z = j;
                    }
                    if (z > 0) {
                        z = number2 * z;
                        str = str + z + " " + operator + " " + number2 + " = ___" + "\n";
                        d = d - z;
                    }
                    if (d > 0) {
                        str = str + d + " " + operator + " " + number2 + " = ___" + "\n";
                    }
                    break;
            }
        }

        System.out.println(number1 + " " + operator + " " + number2);
        System.out.println("--------------------");
        System.out.println(str);

    }


}
