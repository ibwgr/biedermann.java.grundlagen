package Uebungen.Threads.ReaderWriter.StartAlternative;

public class Data {

	int[] values;
	private volatile int noReaders = 0;
	private volatile int noWriters = 0;

	Data(int size) {
		values = new int[size];
	}

	synchronized public void requestRead() throws InterruptedException {
		while (noWriters != 0) {
			wait();
		}
		noReaders++;
	}

	synchronized public void releaseRead() {
		noReaders--;
		if (noReaders == 0) {
			notifyAll();
		}
	}

	synchronized public void requestWrite() throws InterruptedException {
		while (noReaders != 0 || noWriters != 0) {
			wait();
		}
		noWriters++;
	}

	synchronized public void releaseWrite() {
		noWriters--;
		if (noWriters == 0) {
			notifyAll();
		}
	}

}
