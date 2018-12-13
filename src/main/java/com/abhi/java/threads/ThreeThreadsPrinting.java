package com.abhi.java.threads;

/**
 * Created by abhdogra1 on 12/10/2018.
 */
public class ThreeThreadsPrinting implements Runnable {

    String value;
    int threadNumber;

    static Object mutex = new Object();
    static volatile int counter = 0;

    public ThreeThreadsPrinting(String value, int threadNumber) {
        this.value = value;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {

        while (counter < 20) {
            synchronized (mutex) {
                //make it if and you will see jumbled up printing by threads. Example of spruios wake up of threads
                while (counter % 3 != threadNumber) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("ThreadName " + threadNumber + "  printing - " + value);
                counter++;
                mutex.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ThreeThreadsPrinting task1 = new ThreeThreadsPrinting("Hello", 0);
        ThreeThreadsPrinting task2 = new ThreeThreadsPrinting("My", 1);
        ThreeThreadsPrinting task3 = new ThreeThreadsPrinting("Name", 2);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        ;
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
