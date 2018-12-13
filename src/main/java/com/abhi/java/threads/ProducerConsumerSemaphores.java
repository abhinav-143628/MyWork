package com.abhi.java.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created by abhdogra1 on 12/11/2018.
 */
public class ProducerConsumerSemaphores {

    private Queue<Integer> queue = new LinkedList<>();

    class Procuder implements Runnable{

        Semaphore producer;
        Semaphore consumer;

        public Procuder(Semaphore producer,Semaphore consumer){
            this.producer = producer;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Producer has acquired semaphore");
                    producer.acquire();
                    for (int i = 0; i < 5; i++) {
                        queue.add(i);
                        System.out.println("value added- " + i);
                    }
                    System.out.println("Producer has produced the values");
                    consumer.release();
                    System.out.println("Consumer release called. This is increment consumer count");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    class Consumer implements Runnable{

        Semaphore producer;
        Semaphore consumer;

        public Consumer(Semaphore producer,Semaphore consumer){
            this.producer = producer;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("consumer has acquired semaphore");
                    consumer.acquire();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Values consumed - "+ queue.poll());
                    }
                    System.out.println("consumer has taken the values");
                    producer.release();
                    System.out.println("producer release called. This is increment consumer count");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        ProducerConsumerSemaphores obj = new ProducerConsumerSemaphores();
        Semaphore semComsume = new Semaphore(0);
        Semaphore semProduce = new Semaphore(1);

        Consumer consumer = obj.new Consumer(semProduce,semComsume);
        Procuder procuder = obj.new Procuder(semProduce,semComsume);

        Thread t1 = new Thread(procuder,"Producer Thread");
        Thread t2 = new Thread(consumer,"Consumer Thread");

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
