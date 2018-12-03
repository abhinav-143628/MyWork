package com.abhi.java.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by abhdogra1 on 12/3/2018.
 */
public class ProducerConsumerBasic {

    private Queue<Integer> queue = new LinkedList<>();
    private final int counter = 5;
    private volatile int add = 0;

    public void producer(){
        while (true){
            synchronized (this){
                while(queue.size() >= counter){
                    try {
                        System.out.println("Queue full");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Queue adding");
                queue.add(add++);
                notifyAll();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void consumer(){

        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue empty");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Queue remove");
                queue.poll();
                notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        ProducerConsumerBasic obj = new ProducerConsumerBasic();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                obj.producer();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                obj.consumer();
            }
        });

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
