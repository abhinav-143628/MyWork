package com.abhi.java.threads;

import static java.lang.Thread.sleep;

/**
 * Created by abhdogra1 on 12/17/2018.
 */
public class LockingTest {

    public void m1() throws InterruptedException { System.out.println("m1"); sleep(1000); }
    public void m2() throws InterruptedException { System.out.println("m2"); sleep(1000);}

    public synchronized void m3() throws InterruptedException { System.out.println("m3"); sleep(1000);}
    public synchronized void m4() throws InterruptedException { System.out.println("m4"); sleep(1000);}

    public static synchronized void m5() throws InterruptedException { System.out.println("m5"); Thread.currentThread().sleep(1000);}
    public static synchronized void m6() throws InterruptedException { System.out.println("m6"); Thread.currentThread().sleep(1000);}


    public static void main(String[] args)  {
        LockingTest test = new LockingTest();
        LockingTest test1 = new LockingTest();

        Thread t1 = new Thread(() -> {
            try {
                test.m3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                test.m4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                test1.m5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

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


    }

}


