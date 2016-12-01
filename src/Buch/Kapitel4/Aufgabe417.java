package A4;

import Prog1Tools.IOTools;

public class Aufgabe417 {
	public static void main(String args[]) {
		int i = 20;
		while(i > 0) {
			System.out.println(i);
			i -= 2;
		}

		for(int j = 20; j > 0; j -= 2) {
			System.out.println(j);
		}
	}
}