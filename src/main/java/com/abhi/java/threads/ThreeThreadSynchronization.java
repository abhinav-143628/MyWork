package com.abhi.java.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhdogra1 on 12/3/2018.
 */
public class ThreeThreadSynchronization {

    private volatile int counter = 0;
    private volatile int counter1 = 0;
    private volatile int fixed = 3;

    public void printSequentially() {

        while (counter < 20) {
            synchronized (this) {
                if (counter % fixed == 0 && Thread.currentThread().getName().equals("first"))
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                else if (counter % fixed == 1 && Thread.currentThread().getName().equals("second"))
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                else if (counter % fixed == 2 && Thread.currentThread().getName().equals("third"))
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
            }
        }

    }

    class Sequential implements Runnable{
        private int threadValue;
        public Sequential(int remainder){
            this.threadValue = remainder;
        }

        @Override
        public void run() {

        }
    }
    /*public void printSequentiallyWithoutName() throws InterruptedException {

        while (counter1 < 20) {
            synchronized (this) {
                if (counter % fixed == 0) {
                    System.out.println(Thread.currentThread().getName() + " " + counter1++);
                    Thread.currentThread().sleep(1000);
                } else if (counter % fixed == 1) {
                    System.out.println(Thread.currentThread().getName() + " " + counter1++);
                    Thread.currentThread().sleep(1000);
                } else if (counter % fixed == 2) {
                    System.out.println(Thread.currentThread().getName() + " " + counter1++);
                    Thread.currentThread().sleep(1000);
                }
                notifyAll();
            }
        }

    }
*/
    public static void main(String[] args) {
        ThreeThreadSynchronization obj = new ThreeThreadSynchronization();

        Thread t1 = new Thread(() -> {
            obj.printSequentially();
        });

        Thread t2 = new Thread(() -> {
            obj.printSequentially();
        });

        Thread t3 = new Thread(() -> {
            obj.printSequentially();
        });

        t1.setName("first");
        t2.setName("second");
        t3.setName("third");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t4 = new Thread(() -> {
//            try {
//          //      obj.printSequentiallyWithoutName();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        Thread t5 = new Thread(() -> {
//            try {
//           //     obj.printSequentiallyWithoutName();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        Thread t6 = new Thread(() -> {
//            try {
//             //   obj.printSequentiallyWithoutName();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        System.out.println("Without name");
        t4.start();
        t5.start();
        t6.start();

        try {
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
