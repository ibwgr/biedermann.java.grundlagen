package Others.Sudoku;

/**
 * Created by dieterbiedermann on 31.08.16.
 */
public class Sudoku {

    public static int[][] createHide() {
        int q = 9, n;
        int[][] quadHide = new int[q][q];
        int x, y, startY, endeY;

        for (int i = 0; i < 63; i++) {
            do {
                x = (int) (Math.random() * 10);
                if (x > 8) {
                    x = 1;
                }
                y = (int) (Math.random() * 10);
                if (y > 8) {
                    y = 0;
                }
            } while (quadHide[x][y] == 1);
            quadHide[x][y] = 1;
        }

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
        int[][] quad, quadHide;

        quad = create();
        quadHide = createHide();

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
    }
}
