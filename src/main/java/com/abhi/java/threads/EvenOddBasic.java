package com.abhi.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abhdogra1 on 12/3/2018.
 */
public class EvenOddBasic {
    AtomicInteger counter = new AtomicInteger(0);

    public void printEvenOdd(){
        while(true){
          //  synchronized (this){
                if(counter.get() % 2 == 0 && Thread.currentThread().getName().equals("Even")){
                    System.out.println("Even: "+ counter.getAndIncrement());
                }else if(counter.get() % 2 != 0 && Thread.currentThread().getName().equals("Odd")){
                    System.out.println("Odd: "+counter.getAndIncrement());
                }
         //   }
        }
    }

    public static void main(String[] args){
        EvenOddBasic obj = new EvenOddBasic();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEvenOdd();
            }
        });
        Thread t2 = new Thread(()->{
            obj.printEvenOdd();
        });

        t1.setName("Even");
        t2.setName("Odd");

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
