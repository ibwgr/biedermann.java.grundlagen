package Uebungen.Threads.CircularBuffer;

public class Aufgabe {

	public static void main(String[] args) {
		CircularBuffer buffer = new CircularBuffer(5);
		Producer producer = new Producer(buffer, 20);	// 100: wait 0-99 ms before producing
//		Producer producer2 = new Producer(buffer, 30);	// 100: wait 0-99 ms before producing
		Consumer consumer = new Consumer(buffer, 10);	// -1: consume without waiting
		Consumer consumer2 = new Consumer(buffer, 20);	// -1: consume without waiting
		Consumer consumer3 = new Consumer(buffer, 30);	// -1: consume without waiting
		producer.start();
//		producer2.start();
		consumer.start();
		consumer2.start();
		consumer3.start();
	}
}
