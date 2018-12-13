package com.abhi.java.threads;

/**
 * Created by abhdogra1 on 12/11/2018.
 */
public class SemaphoreCustom {

    private volatile int permits;

    public SemaphoreCustom(int permits) {
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        if (permits > 0) {
            permits--;
        } else {
            //if acquire is called and value of permit is less than 0 or negative then thread is in waiting state forever then
            // it just waits for other thread to call release on same semaphore object
            this.wait();
            permits--;
        }
    }

    public synchronized void release() throws InterruptedException {
        permits++;
        if (permits > 0) {
            this.notifyAll();
        }
    }

    //taken because we want Increment thread to increase the value and decrement thread to decrease the value on same variable
    static int SharedValue = 0;

    public static void main(String[] args) {
        SemaphoreCustom semaphore = new SemaphoreCustom(1);
        System.out.println("Semaphore with 1 permit has been created");

        IncrementThread incrementThread = new IncrementThread(semaphore);
        DecrementThread decrementThread = new DecrementThread(semaphore);

        new Thread(incrementThread, "incrementThread").start();
        new Thread(decrementThread, "decrementThread").start();
    }


    static class IncrementThread implements Runnable {

        SemaphoreCustom semaphoreCustom;

        public IncrementThread(SemaphoreCustom semaphoreCustom) {
            this.semaphoreCustom = semaphoreCustom;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() +
                    " is waiting for permit");
            try {
                semaphoreCustom.acquire();
                System.out.println(Thread.currentThread().getName() +
                        " has got permit");

                for (int i = 0; i < 5; i++) {
                  //  Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() +
                            " > " + SemaphoreCustom.SharedValue++);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() +
                    " has released permit");
            try {
                semaphoreCustom.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    static class DecrementThread implements Runnable {

        SemaphoreCustom semaphoreCustom;

        public DecrementThread(SemaphoreCustom semaphoreCustom) {
            this.semaphoreCustom = semaphoreCustom;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() +
                    " is waiting for permit");

            try {
                semaphoreCustom.acquire();
                System.out.println(Thread.currentThread().getName() +
                        " has got permit");

                for (int i = 0; i < 5; i++) {
                   // Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() +
                            " >" + SemaphoreCustom.SharedValue--);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() +
                    " has released permit");
            try {
            //    semaphoreCustom.release();
                semaphoreCustom.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
