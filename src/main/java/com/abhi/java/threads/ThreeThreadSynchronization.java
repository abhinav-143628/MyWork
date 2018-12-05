package com.abhi.java.threads;

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

    private Object mutex = new Object();
    private volatile int number = 0;
    class Sequential implements Runnable {
        private int threadValue;

        private volatile  int constant = 3;

        public Sequential(int remainder) {
            this.threadValue = remainder;
        }

        @Override
        public void run() {
            while(number < 20){
                synchronized (mutex){
                    if(number % constant == this.threadValue)
                        System.out.println(Thread.currentThread().getName()+" - "+number++);
                }
            }
        }
    }

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

        Sequential task1 = obj.new Sequential(0);
        Sequential task2 = obj.new Sequential(1);
        Sequential task3 = obj.new Sequential(2);

        Thread t4 = new Thread(task1, "One");
        Thread t5 = new Thread(task2,"Two");
        Thread t6 = new Thread(task3,"Three");

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
