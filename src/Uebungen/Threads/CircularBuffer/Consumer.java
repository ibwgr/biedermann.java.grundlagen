package Uebungen.Threads.CircularBuffer;

import java.util.Random;

public class Consumer extends Thread {
	CircularBuffer buffer;

	int sleepTime;

	Consumer(CircularBuffer data, int sleepTime) {
		this.buffer = data;
		this.sleepTime = sleepTime;
	}

	public void run() {
		Random random = new Random();
		while (true) {
//			if (!buffer.isEmpty()) {
			try {
				int value = buffer.get();
				System.out.println(value);
			} catch (InterruptedException ex) {}
//			}
			if (sleepTime >= 0) {
				// wait for a random time between 0 and sleepTime
				try {
					Thread.sleep(random.nextInt(sleepTime));
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
