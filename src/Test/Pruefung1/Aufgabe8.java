package Test.Pruefung1;

/**
 * Created by dieterbiedermann on 15.09.16.
 */
// Biedermann
// Aufgabe 8
public class Aufgabe8 {
    public static void main(String[] args) {
        boolean[] boolList = new boolean[4];

        boolList[0] = true;
        boolList[1] = false;
        boolList[2] = false;
        boolList[3] = true;

        for (int i = 0; i < boolList.length; i++) {
            System.out.println(boolList[i] ? "Wahr" : "Falsch");
        }
    }
}
