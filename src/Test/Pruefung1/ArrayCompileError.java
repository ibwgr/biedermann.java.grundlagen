package Test.Pruefung1;

/**
 * Created by dieterbiedermann on 15.09.16.
 */
// Biedermann
// Aufgabe 7
public class ArrayCompileError {
    public static void main(String[] args) {
        int[] intArray = new int[3];
        intArray[0] = 23;
        intArray[1] = 78;
        intArray[2] = 90;
        for (int i = 0; i < 3; i++) {
            System.out.println(intArray[i]);
        }
    }
}
