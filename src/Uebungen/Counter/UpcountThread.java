package Uebungen.Counter;

/**
 * Created by dieterbiedermann on 08.12.16.
 */
class UpcountThread extends Thread {
    static int count = 0;
    int maxCount, threadNo;
    String lock;
    public UpcountThread(String lock, int no, int maxCount) {
        this.threadNo = no;
        this.maxCount = maxCount;
        this.lock = lock;
    }
    public void run() {
        synchronized (System.out) {
            System.out.println("Thread " + threadNo + " gestartet");
            System.out.println("Thread " + threadNo + " lock erhalten");
        }
        while (count < maxCount) {
            synchronized (System.out) {
                if (count < maxCount) {
                    System.out.print("Thread " + threadNo + ": " + count);
                    count++;
                    System.out.println(" -> " + count);
                }
            }
        }
        synchronized (System.out) {
            System.out.println("Thread " + threadNo + " beendet");
        }
    }
}
