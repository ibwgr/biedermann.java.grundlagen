package Others.Test;

/**
 * Created by dieterbiedermann on 30.08.16.
 */

public class Test {
    public static void main(String args[]) {
/*
        short a = 1;
        short b = 2;
        short c = (short) (a + b);
*/

        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println("a == b > " + (a == b ? "true" : "false")); // Literal Pool
        System.out.println("a.equals(b) > " + (a.equals(b) ? "true" : "false"));
        System.out.println("a == c > " + (a == c ? "true" : "false"));
        System.out.println("a.equals(c) > " + (a.equals(c) ? "true" : "false"));

/*
        int i;
        i = IOTools.readInteger();
*/

/*
        {
            int x = 4;
        }
        System.out.println(x);
*/




    }
}
