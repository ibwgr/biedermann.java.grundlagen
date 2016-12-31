package Uebungen.Threads.ReaderWriter.Start;

import java.util.Random;

public class Reader extends Thread {
	Data data;
	int sleepTime;
	Reader(Data data, int sleepTime) {
		this.data = data;
		this.sleepTime = sleepTime;
	}
	public void run() {
		Random random = new Random();
		while (true) {
			StringBuffer buf = new StringBuffer();
			for (int j=0; j < data.values.length; j++) {
				buf.append(data.values[j]);
				buf.append(", ");
			}
			System.out.println(buf.toString());
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
