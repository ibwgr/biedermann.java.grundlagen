package Uebungen.Threads.CircularBuffer;

import java.util.Random;

public class Producer extends Thread {
	CircularBuffer data;
	int sleepTime;
	Producer(CircularBuffer data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		int value = 0;
		while (true) {
			synchronized (data) {
				if (!data.isFull()) {
			try {
					data.put(value);
			} catch (InterruptedException ex) {}
				}
			}
			value++;
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
