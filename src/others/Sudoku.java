package others;

import java.util.Arrays;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Sudoku {

    public static void main(String[] args) {
        int q = 9;
        boolean result = false, found;

/*
        while (n < 2 || n > 10 || n % 2 == 0) {
            System.out.print("Quadrat Groesse: ");
            n = IOTools.readInteger();
        }
*/

        int[][] quad = new int[q][q];
        int[][] quadPre = new int[q][q];
        int zeile, spalte;

        do {
            result = true;
            // setze Felder
            // 100
            // 010
            // 001
            for (int x = 3; x <= q; x = x + 3) {
/*
                for (int y = 3; y <= q; y = y + 3) {
*/
                    do {
                        zeile = (int) (Math.random() * 10) -1;
                    } while (zeile < x - 3 || zeile > x - 1);

                    do {
                        spalte = (int) (Math.random() * 10) -1;
                    } while (spalte < x - 3 || spalte > x - 1);

                    for (int i = 1; i <= 9; i++) {
                        // 1: zeile = 1, spalte = 2
                        // 2: zeile = 0, spalte = 0
                        // ...
                        quad[zeile][spalte] = i;
                        quadPre[zeile][spalte] = 1;
                        zeile--;
                        spalte++;
                        if (zeile < x - 3) {
                            zeile = x - 1;
                        }
                        if (spalte == x) {
                            spalte = x - 3;
                        }
                        if (quad[zeile][spalte] != 0) {
                            zeile++;
                            spalte++;
                            if (zeile == x) {
                                zeile = x - 3;
                            }
                            if (spalte == x) {
                                spalte = x - 3;
                            }
                        }

                    }
/*
                }
*/
            }

/*
            for (int i = 0; i < q; i++) {
                for (int j = 0; j < q; j++) {
                    int zahl = quadPre[i][j];
                    System.out.print((zahl > 9 ? " " : "  ") + zahl);
                }
                System.out.println();
            }
*/

            // mit Backtracking restliche Felder befüllen
            boolean istFeldVoll = false, bereitsVorhanden;
            int neueZahl, x = 0, y = 0, v, startX, endeX, startY, endeY;
            int[][][] quadVersuche = new int[q][q][9];
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
                        v++;
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
//
for (int i = 0; i < q; i++) {
    for (int j = 0; j < q; j++) {
        int zahl = quad[i][j];
        System.out.print((zahl > 9 ? " " : "  ") + zahl);
    }
    System.out.println();
}
System.out.println("vorher -> x:"+x+", y:"+y);
//

                                    y = 0;
                                    x = x + 1;
                                }
                            }
                            continue;
                        }
                    }
                    if (v >= q - 1) {
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


/*
            // alt
            int neueZahl, cnt, cntV = -1, x = 0, y = 0, tempX, tempY;
            boolean istZahlVorhanden, istFeldFix, bereitsVersucht;
            int[][][] quadVersuche = new int[q][q][8];
            int[][] quadVersucheCnt = new int[q][q];
            while (x < q) {
                y = 0;
                while (y < q) {
                    if (quadPre[x][y] == 0) {
                        cnt = 0;
                        // löschen von vorangehendem Feld
                        tempY = y + 1;
                        tempX = x;
                        if (tempY > q - 1) {
                            tempY = 0;
                            tempX = tempX + 1;
                        }
                        for (int i = 0; i < 8; i++) {
                            quadVersuche[tempX][tempY][i] = 0;
                        }
                        quadVersucheCnt[tempX][tempY] = 0;
                        // suche neue Zahl
                        do {
                            istZahlVorhanden = false;
                            bereitsVersucht = false;
                            neueZahl = (int) (Math.random() * 10);
                            if (neueZahl == 0) {
                                neueZahl = 1;
                            }
                            for (int v = 0; v < 8; v++) {
                                if (quadVersuche[x][y][v] == neueZahl) {
                                    bereitsVersucht = true;
                                    break;
                                }
                            }
                            for (int y2 = 0; y2 < q; y2++) {
                                if (quad[x][y2] == neueZahl || quad[y2][y] == neueZahl) {
                                    istZahlVorhanden = true;
                                    break;
                                }
                            }
                        } while (istZahlVorhanden & cnt++ < 50 & bereitsVersucht);
                        if (cnt < 50 && quadVersucheCnt[x][y] < 7) {
                            // neue Zahl gefunden
                            quad[x][y] = neueZahl;
                            quadVersuche[x][y][quadVersucheCnt[x][y]] = neueZahl;
                            quadVersucheCnt[x][y]++;
                            y++;
                        } else {
                            // keine Möglichkeit gefunden
                            // -> Feld zurück und neue Zahl ausprobieren
                            do {
                                istFeldFix = false;
                                y = y - 1;
                                if (y < 0) {
                                    y = q - 1;
                                    x = x - 2;
                                    if (x < 0) {
                                        x = q - 2;
                                    }
                                    if (quadPre[x+1][y] == 1) {
                                        istFeldFix = true;
                                    }
                                } else {
                                    if (quadPre[x][y] == 1) {
                                        istFeldFix = true;
                                    }
                                }
                            } while (istFeldFix);
                        }
                    } else {
                        y++;
                    }
                }
                x++;
            }
*/

/*
            for (int x = 0; x < q; x++) {
                int[] checkList = new int[9];
                int i = 0;
                for (int y = 0; y < q; y++) {
                    found = false;
                    for (int j = 0; j < i; j++) {
                        if (checkList[j] == quad[x][y]) {
                            found = true;
                        }
                    }
                    if (!found) {
                        checkList[i] = quad[x][y];
                        i++;
                    } else {
                        result = false;
                        break;
                    }
                }
            }
*/

/*            for (int y = 0; y < q; y++) {
                int[] checkList = new int[9];
                int i = 0;
                for (int x = 0; x < q; x++) {
                    found = false;
                    for (int j = 0; j < i; j++) {
                        if (checkList[j] == quad[x][y]) {
                            found = true;
                        }
                    }
                    if (!found) {
                        checkList[i] = quad[x][y];
                        i++;
                    } else {
                        result = false;
                        break;
                    }
                }
            }*/
        } while (result == false);

        for (int i = 0; i < q; i++) {
            for (int j = 0; j < q; j++) {
                int zahl = quad[i][j];
                System.out.print((zahl > 9 ? " " : "  ") + zahl);
            }
            System.out.println();
        }
    }
}
