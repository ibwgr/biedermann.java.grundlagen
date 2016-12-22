package Others.Sudoku;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Sudoku {

    public static boolean isNumberUniqueInRowColumnArea(int[][] quad, int x, int y, int checkNumber, boolean ignoreEmptyFields) {
        int q = 9, startX, endeX, startY, endeY;
        boolean isUnique = true;

        // ist Zahl bereits in Bereich, Spalte oder Zeile vorhanden
        for (int i = 0; i < q; i++) {
            if (!ignoreEmptyFields || quad[x][i] != 0) {
                if (y != i && quad[x][i] == checkNumber) {
                    isUnique = false;
                    break;
                }
            }
            if (!ignoreEmptyFields || quad[i][y] != 0) {
                if (x != i && quad[i][y] == checkNumber) {
                    isUnique = false;
                    break;
                }
            }
        }
        if (isUnique) {
            // bereich suche
            startX = x / 3 * 3;
            endeX = startX + 2;
            startY = y / 3 * 3;
            endeY = startY + 2;
            for (int i = startX; i <= endeX; i++) {
                for (int j = startY; j <= endeY; j++) {
                    if (!ignoreEmptyFields || quad[i][j] != 0) {
                        if (x != i && y != j && quad[i][j] == checkNumber) {
                            isUnique = false;
                            break;
                        }
                    }
                }
            }
        }
        return isUnique;
    }

    public static boolean check(int[][] quadCheck) {
        int q = 9;
        int neueZahl, startX, endeX, startY, endeY;
        boolean isUnique = true;

        for (int x = 0; x < quadCheck.length; x++) {
            for (int y = 0; y < quadCheck.length; y++) {

                neueZahl = quadCheck[x][y];
                if (neueZahl == 0) {
                    isUnique = false;
                    break;
                }

                if (!isNumberUniqueInRowColumnArea(quadCheck, x, y, neueZahl, false)) {
                    isUnique = false;
                    break;
                }

            }
        }


        return isUnique;
    }

    public static int[] getNextField(int[] oldField, int q, int[][] quadEmpty) {
        int[] newField = oldField;
        do {
            newField[1] = newField[1] + 1;
            if (newField[1] > q - 1) {
                if (newField[0] == 8) {
//                    throw new IllegalArgumentException("at the end of the area");
                    return new int[] {8,8};
                }
                newField[1] = 0;
                newField[0] = newField[0] + 1;
                if (newField[0] > q - 1) {
                    newField[0] = q - 1;
                }
            }
        } while (quadEmpty[newField[0]][newField[1]] == 0);
        return newField;
    }

    public static int[] getPreviousField(int[] oldField, int q, int[][] quadEmpty) {
        int[] newField = oldField;
        do {
            if (newField[1] == 0) {
                if (newField[0] == 0) {
                    return new int[] {0,0};
                } else {
                    newField[0] = newField[0] - 1;
                }
            } else {
                newField[1] = newField[1] - 1;
            }
        } while (quadEmpty[newField[0]][newField[1]] == 0);
        return newField;
    }

    public static int[][] solve(int[][] quad, int[][] quadHide) {
        int q = 9, neueZahl, tryCount;
        boolean isQuadSolved, numberTried, alreadyFound;
        ArrayList<int[][]> quadSolvedList = new ArrayList<>();
        int[][] quadTemp = new int[q][q];
        int[][] quadSolved = new int[q][q];
        int[][][] quadTry = new int[q][q][q];
        int[] field = new int[2], oldField;
        int[] startField = new int[2];
        int[][][] startQuadTry = new int[q][q][q];
        boolean bereitsVorhanden;
        int startX, endeX, startY, endeY;
        int[] fullRandomNumbers = {1,2,3,4,5,6,7,8,9};
                
        for (int x = 0; x < quad.length; x++) {
            for (int y = 0; y < quad.length; y++) {
                if (quadHide[x][y] == 0) {
                    quadTemp[x][y] = quad[x][y];
                }
            }
        }

        for (int count = 0; count < 5; count++) {
            quadSolved = quadTemp;
            field = startField;
            //field[1] = field[1] + count;
            quadTry = startQuadTry;

            isQuadSolved = false;
            int x = 0;
            int y = 0;
            while (!isQuadSolved) {

                if (quadHide[x][y] == 1) {
                    tryCount = 0;
                    for (int i = 0; i < 9; i++) {
                        if (quadTry[x][y][i] != 0) {
                            tryCount++;
                        }
                    }
                    int numbersLeft = 9-tryCount;
                    int numberCount = numbersLeft - 1;
                    int[] randomNumbers = new int[numbersLeft];
                    if (numbersLeft == 9) {
                        randomNumbers = fullRandomNumbers;
                    } else {
                        for (int i = 0; i < fullRandomNumbers.length; i++) {
                            boolean isInQuadTry = false;
                            for (int j = 0; j < q; j++) {
                                if (quadTry[x][y][j] == fullRandomNumbers[i]) {
                                    isInQuadTry = true;
                                    break;
                                }
                            }
                            if (!isInQuadTry) {
                                randomNumbers[numberCount--] = fullRandomNumbers[i];
                            }
                        }
                    }
                    if (numbersLeft == 0) {
                        neueZahl = 0;
                    } else if (numbersLeft == 1) {
                        neueZahl = randomNumbers[0];
                    } else {
                        boolean isOK = false;
                        do {
                            neueZahl = (int) (Math.random() * 10);
                            if (neueZahl > 8) {
                                neueZahl = 8;
                            }
                            for (int i = 0; i < numbersLeft; i++) {
                                if (randomNumbers[i] == neueZahl) {
                                    isOK = true;
                                    break;
                                }
                            }
                        } while (!isOK);
                    }
                    // ist Zahl bereits in Merkliste
/*
                    numberTried = false;
                    for (int i = 0; i < 9; i++) {
                        if (quadTry[x][y][i] == neueZahl) {
                            numberTried = true;
                            break;
                        }
                    }
*/
//                    if (!numberTried) {
                    if (numbersLeft > 0) {
                        quadTry[x][y][tryCount] = neueZahl;
                        // ist Zahl bereits in Bereich, Spalte oder Zeile vorhanden
                        bereitsVorhanden = false;
                        for (int i = 0; i < q; i++) {
                            if (quadSolved[x][i] == neueZahl || quadSolved[i][y] == neueZahl) {
                                bereitsVorhanden = true;
                                break;
                            }
                        }
                        if (!bereitsVorhanden) {
                            // bereich suche
                            startX = x / 3 * 3;
                            endeX = startX + 2;
                            startY = y / 3 * 3;
                            endeY = startY + 2;
                            for (int i = startX; i <= endeX; i++) {
                                for (int j = startY; j <= endeY; j++) {
                                    if (quadSolved[i][j] == neueZahl) {
                                        bereitsVorhanden = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!bereitsVorhanden) {
                            quadSolved[x][y] = neueZahl;

//                            System.out.println("("+x+","+y+") - neue Zahl: "+neueZahl);

                            if (x == q - 1 && y == q - 1) {
                                isQuadSolved = true;
                            } else {
                                // Feld vor
                                y = y + 1;
                                if (y > q - 1) {

/*
                                for (int i = 0; i < q; i++) {
                                    for (int j = 0; j < q; j++) {
                                        int zahl = quadSolved[i][j];
                                        System.out.print((zahl > 9 ? " " : "  ") + zahl);
                                    }
                                    System.out.println();
                                }
                                System.out.println("vorher -> x:"+x+", y:"+y);
*/

                                    y = 0;
                                    x = x + 1;
                                }
                            }
                        }
                    } else {
                        // Ist die Merkliste bereits voll
                        if (tryCount >= q) {
                            quadSolved[x][y] = 0;
                            for (int i = 0; i < 9; i++) {
                                quadTry[x][y][i] = 0;
                            }
                            // ein Feld zurück
                            do {
                                if (y == 0) {
                                    x = x - 1;
                                    if (x < 0) {
                                        x = 0;
                                    }
                                    for (int j = 1; j < q; j++) {
                                        if (quadHide[x][j] == 1) {
                                            quadSolved[x][j] = 0;
                                        }
                                        for (int i = 0; i < 9; i++) {
                                            quadTry[x][j][i] = 0;
                                        }
                                    }
                                } else {
                                    y = y - 1;
                                }
                            } while (quadHide[x][y] == 0 && x >= 0);
                        }
                    }
                } else {
                    if (x == q - 1 && y == q - 1) {
                        isQuadSolved = true;
                    }
                    // Feld vor
                    y = y + 1;
                    if (y > q - 1) {

/*
                        for (int i = 0; i < q; i++) {
                            for (int j = 0; j < q; j++) {
                                int zahl = quadSolved[i][j];
                                System.out.print((zahl > 9 ? " " : "  ") + zahl);
                            }
                            System.out.println();
                        }
                        System.out.println("vorher -> x:"+x+", y:"+y);
*/

                        y = 0;
                        x = x + 1;
                    }
                }


/*                if (field[0] > q - 1) {
                    field[0] = 0;
                }
                if (field[1] > q - 1) {
                    field[1] = 0;
                }
                // bereits gefüllte Felder ignorieren
                if (quadHide[field[0]][field[1]] == 1) {
                    tryCount = 0;
                    for (int i = 0; i < 9; i++) {
                        if (quadTry[field[0]][field[1]][i] != 0) {
                            tryCount++;
                        }
                    }
                    neueZahl = (int) (Math.random() * 10);
                    if (neueZahl == 0) {
                        neueZahl = 1;
                    }
                    // ist Zahl bereits in Merkliste
                    numberTried = false;
                    for (int i = 0; i < 9; i++) {
                        if (quadTry[field[0]][field[1]][i] == neueZahl) {
                            numberTried = true;
                            break;
                        }
                    }
                    if (!numberTried) {
                        quadTry[field[0]][field[1]][tryCount] = neueZahl;
                        // ist Zahl bereits in Bereich, Spalte oder Zeile vorhanden
                        if (isNumberUniqueInRowColumnArea(quadSolved, field[0], field[1], neueZahl, true)) {
                            quadSolved[field[0]][field[1]] = neueZahl;
                            if (field[0] == q - 1 && field[1] == q - 1) {
                                isQuadSolved = true;
                            } else {
                                field = getNextField(field,q,quadHide);
                            }
                        }
                    } else {
                        // Ist die Merkliste bereits voll
                        if (tryCount >= q) {
                            quadSolved[field[0]][field[1]] = 0;
                            for (int i = 0; i < 9; i++) {
                                quadTry[field[0]][field[1]][i] = 0;
                            }
                            oldField = field;
                            field = getPreviousField(field, q, quadHide);

                            if (field[0] < 0) {
                                throw new IllegalArgumentException("no solution found");
                            }

                            for (int r = oldField[0]; r > field[0]; r--) {
                                for (int j = 1; j < q; j++) {
                                    if (quadHide[r][j] != 1) {
                                        quadSolved[r][j] = 0;
                                    }
                                    for (int i = 0; i < 9; i++) {
                                        quadTry[r][j][i] = 0;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (field[0] == q - 1 && field[1] == q - 1) {
                        isQuadSolved = true;
                    }
                    field = getNextField(field,q,quadHide);
                }*/
            }

            alreadyFound = true;
            for (int[][] solved : quadSolvedList) {
                for (int i = 0; i < quadSolved.length; i++) {
                    for (int j = 0; j < quadSolved.length; j++) {
                        if (solved[i][j] != quadSolved[i][j]) {
                            alreadyFound = false;
                        }
                    }
                }
/*
                if (Arrays.deepEquals(quadSolved, solved)) {
                    alreadyFound = true;
                }
*/
            }
            if (!alreadyFound || quadSolvedList.isEmpty()) {
                quadSolvedList.add(quadSolved);
            }
        }

        if (quadSolvedList.size()==0) {
            throw new IllegalArgumentException("Found no solution: "+quadSolvedList.size());
        }
        if (quadSolvedList.size() > 1) {
            throw new IllegalArgumentException("Found too many solutions: "+quadSolvedList.size());
        }

        return quadSolvedList.get(quadSolvedList.size()-1);
    }


    public static int[][] createHide(int[][] quad, int level) {
        int q = 9, rnd, count;
        int[][] quadHide = new int[q][q];
        int numberCount;
        ArrayList<Integer> numberList = new ArrayList<>();

        // eine Zahl fix entfernen
        // Level: 1 - 75
        // Level 1 - 20: 1 Zahlen entfernen
        // Level 21 - 40: 2 Zahlen enternen
        // Level 41 - 60: 3 Zahlen entfernen
        // Level 61 - 75: 4 Zahlen entfernen

/*
        for (int i = 0; i < numberCount; i++) {
            int x;
            do {
                x = (int) (Math.random() * 10);
                if (x > 9) {
                    x = 1;
                }
            } while (numberList.contains(x));
            numberList.add(x);
        }
*/

        numberCount = (int) (Math.random() * 10) + 1;
        if (numberCount > 9) {
            numberCount = 1;
        }
        for (int x = 0; x < quad.length; x++) {
            for (int y = 0; y < quad.length; y++) {
                if (quad[x][y] == numberCount) {
                    quadHide[x][y] = 1;
                }
            }
        }

        switch (level) {
            case 1: numberCount = 15; break;
            case 2: numberCount = 25; break;
            case 3: numberCount = 35; break;
            case 4: numberCount = 45; break;
        }
        for (int i = 0; i <= level+2; i++) {
            do {
                rnd = (int) (Math.random() * 10) + 1;
                if (rnd > 9) {
                    rnd = 1;
                }
            } while (rnd == numberCount && numberList.contains(rnd));
            numberList.add(rnd);
        }

        for (int i = 0; i < q; i++) {
            for (int j = 0; j < q; j++) {
                int zahl = quad[i][j];
                System.out.print((zahl > 9 ? " " : "  ") + zahl);
            }
            System.out.println();
        }
        System.out.println("---");

        count = 1;
        for (Integer number : numberList) {
            for (int i = 0; i <= level+count; i++) {
                int x, y;
                boolean isOK;
                do {
                    isOK = true;
                    x = (int) (Math.random() * 10);
                    if (x > 8) {
                        x = 0;
                    }
                    y = (int) (Math.random() * 10);
                    if (y > 8) {
                        y = 0;
                    }

                    // check fehlen bereits zwei gleiche nummern in spalte, kolonne
                    // und zu diesen feldern (spalte, kolonne) fehlt die aktuelle zahl?
                    if (quad[x][y] == number) {
                        for (int c1 = 0; c1 < 9; c1++) {
                            for (int c2 = 0; c2 < 9; c2++) {
                                if (x != c2 && y != c1
                                        //&& quadHide[x][c1] == 1
                                        && quad[x][c1] == quad[c2][y]
                                        ) {

                                    for (int c3 = 0; c3 < 9; c3++) {
                                        if (quad[c3][c1] == number && quadHide[c3][c1] == 1) {
                                            isOK = false;
                                        }
                                        if (quad[c2][c3] == number && quadHide[c2][c3] == 1) {
                                            isOK = false;
                                        }
                                    }

                                }
                            }
                        }
                    }

                } while (quad[x][y] != number && quadHide[x][y] == 1 && !isOK);
                quadHide[x][y] = 1;
            }
            count = count + 1;
        }

        /*
        rnd = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < numberCount; i++) {
            if (i % (numberCount / 7) == 0) {
                rnd = (int) (Math.random() * 10) + 1;
                if (rnd > 9) {
                    rnd = 1;
                }
            }

            do {
                x = (int) (Math.random() * 10);
                if (x > 8) {
                    x = 0;
                }
                y = (int) (Math.random() * 10);
                if (y > 8) {
                    y = 0;
                }
            } while (quad[x][y] != rnd && quadHide[x][y] == 1);
            quadHide[x][y] = 1;
        }
*/

/*
        for (int i = 0; i < numberCount; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * 10);
                if (x > 8) {
                    x = 0;
                }
                y = (int) (Math.random() * 10);
                if (y > 8) {
                    y = 0;
                }
            } while (quadHide[x][y] == 1);
            quadHide[x][y] = 1;
        }
*/

        return quadHide;
    }

    public static int[][] create() {
        int q = 9;
        int[][] quad = new int[q][q];
        int[][] quadPre = new int[q][q];
        int[][][] quadVersuche = new int[q][q][q];
        boolean istFeldVoll = false, bereitsVorhanden;
        int neueZahl, x, y, v, startX, endeX, startY, endeY;

        // fill first fix numbers
        // setze Felder
        // 100
        // 010
        // 001
        for (int i = 3; i <= q; i = i + 3) {
            do {
                x = (int) (Math.random() * 10) - 1;
            } while (x < i - 3 || x > i - 1);
            do {
                y = (int) (Math.random() * 10) - 1;
            } while (y < i - 3 || y > i - 1);

            for (int n = 1; n <= 9; n++) {
                // 1: x = 1, y = 2
                // 2: x = 0, y = 0
                // ...
                quad[x][y] = n;
                quadPre[x][y] = 1;
                x--;
                y++;
                if (x < i - 3) {
                    x = i - 1;
                }
                if (y == i) {
                    y = i - 3;
                }
                if (quad[x][y] != 0) {
                    x++;
                    y++;
                    if (x == i) {
                        x = i - 3;
                    }
                    if (y == i) {
                        y = i - 3;
                    }
                }

            }
        }

        x = 0;
        y = 0;
        while (!istFeldVoll) {
            // vorher gefüllte Felder ignorieren
            if (quadPre[x][y] == 0) {
                v = 0;
                for (int i = 0; i < 9; i++) {
                    if (quadVersuche[x][y][i] != 0) {
                        v++;
                    }
                }
                neueZahl = (int) (Math.random() * 10);
                if (neueZahl == 0) {
                    neueZahl = 1;
                }
                // ist Zahl bereits in Merkliste
                bereitsVorhanden = false;
                for (int i = 0; i < 9; i++) {
                    if (quadVersuche[x][y][i] == neueZahl) {
                        bereitsVorhanden = true;
                        break;
                    }
                }
                if (!bereitsVorhanden) {
                    quadVersuche[x][y][v] = neueZahl;
                    // ist Zahl bereits in Bereich, Spalte oder Zeile vorhanden
                    bereitsVorhanden = false;
                    for (int i = 0; i < q; i++) {
                        if (quad[x][i] == neueZahl || quad[i][y] == neueZahl) {
                            bereitsVorhanden = true;
                            break;
                        }
                    }
                    // bereich suche
                    startX = x / 3 * 3;
                    endeX = startX + 2;
                    startY = y / 3 * 3;
                    endeY = startY + 2;
                    for (int i = startX; i <= endeX; i++) {
                        for (int j = startY; j <= endeY; j++) {
                            if (quad[i][j] == neueZahl) {
                                bereitsVorhanden = true;
                                break;
                            }
                        }
                    }
                    if (!bereitsVorhanden) {
                        quad[x][y] = neueZahl;
                        if (x == q - 1 && y == q - 1) {
                            istFeldVoll = true;
                        } else {
                            // Feld vor
                            y = y + 1;
                            if (y > q - 1) {
/*
                                for (int i = 0; i < q; i++) {
                                    for (int j = 0; j < q; j++) {
                                        int zahl = quad[i][j];
                                        System.out.print((zahl > 9 ? " " : "  ") + zahl);
                                    }
                                    System.out.println();
                                }
                                System.out.println("vorher -> x:"+x+", y:"+y);
*/

                                y = 0;
                                x = x + 1;
                            }
                        }
//                        continue;
                    }
                } else {
                    // Ist die Merkliste bereits voll
                    if (v >= q) {
                        quad[x][y] = 0;
                        for (int i = 0; i < 9; i++) {
                            quadVersuche[x][y][i] = 0;
                        }
                        // ein Feld zurück
                        if (y == 0) {
                            x = x - 1;
                            for (int j = 1; j < q; j++) {
                                if (quadPre[x][j] != 1) {
                                    quad[x][j] = 0;
                                }
                                for (int i = 0; i < 9; i++) {
                                    quadVersuche[x][j][i] = 0;
                                }
                            }
                        } else {
                            do {
                                if (y == 0) {
                                    x = x - 1;
                                    for (int j = 1; j < q; j++) {
                                        if (quadPre[x][j] != 1) {
                                            quad[x][j] = 0;
                                        }
                                        for (int i = 0; i < 9; i++) {
                                            quadVersuche[x][j][i] = 0;
                                        }
                                    }
                                } else {
                                    y = y - 1;
                                }
                            } while (quadPre[x][y] == 1 && x > 2);
                        }
                    }
                }
            } else {
                if (x == q - 1 && y == q - 1) {
                    istFeldVoll = true;
                }
                // Feld vor
                y = y + 1;
                if (y > q - 1) {
                    y = 0;
                    x = x + 1;
                }
            }
        }

        return quad;
    }

    public static void main(String[] args) {
        int[][] quad, quadHide, quadSolved;

        quad = create();
        quadHide = createHide(quad, 2);

        for (int i = 0; i < quad.length; i++) {
            for (int j = 0; j < quad.length; j++) {
                if (quadHide[i][j] == 1) {
                    System.out.print("  _");
                } else {
                    int zahl = quad[i][j];
                    System.out.print((zahl > 9 ? " " : "  ") + zahl);
                }
            }
            System.out.println();
        }

        System.out.println("---");

        quadSolved = solve(quad,quadHide);

        for (int i = 0; i < quadSolved.length; i++) {
            for (int j = 0; j < quadSolved.length; j++) {
                int zahl = quadSolved[i][j];
                System.out.print((zahl > 9 ? " " : "  ") + zahl);
            }
            System.out.println();
        }
        System.out.println("---");
        if (check(quadSolved)) {
            System.out.println("solved => true");
        } else {
            System.out.println("solved => false");
        }

        for (int i = 0; i < quad.length; i++) {
            for (int j = 0; j < quad.length; j++) {
                System.out.print(" " + quadSolved[i][j] + "|" + quad[i][j]);
                if (quadSolved[i][j] != quad[i][j]) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
