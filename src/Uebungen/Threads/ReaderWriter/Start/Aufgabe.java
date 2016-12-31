package Uebungen.Threads.ReaderWriter.Start;

public class Aufgabe {

	public static void main(String[] args) {
		Data data = new Data(10);
		Writer w1 = new Writer(data, 100);	// 100: wait 0-99 ms before writing
		Reader r1 = new Reader(data, 10);	// -1: read without waiting
		
		r1.start();
		w1.start();
	}
}
