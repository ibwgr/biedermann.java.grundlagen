package Uebungen.Threads.ReaderWriter.StartAlternative;

import java.util.Random;

public class Writer extends Thread {
	Data data;
	int sleepTime;

	Writer(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		while (true) {
			int value = random.nextInt();
			try {
				data.requestWrite();
			} catch(InterruptedException ex) {

			}
//			synchronized (data) {
				for (int j=0; j < data.values.length; j++) {
					data.values[j] = value;
					Thread.yield();
				}
//			}
			data.releaseWrite();
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
