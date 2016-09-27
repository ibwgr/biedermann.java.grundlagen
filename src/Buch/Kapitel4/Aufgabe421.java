package A4;

import Prog1Tools.IOTools;

public class Aufgabe421 {
	public static void main(String args[]) {
		for(int i = 0; i < 8; i++) {
			for(int j = 1; j < 9; j++) {
				System.out.printf((i+j > 9 ? " " : "  ") + (i+j));
			}
			System.out.println();
		}
	}
}