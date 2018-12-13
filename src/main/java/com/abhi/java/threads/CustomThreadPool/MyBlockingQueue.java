package com.abhi.java.threads.CustomThreadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhdogra1 on 12/10/2018.
 */
public class MyBlockingQueue<T> {
    List<T> blockingQueue = new ArrayList<T>();
    private int fixedSize;

    public MyBlockingQueue(int size) {
        this.fixedSize = size;
    }

    public boolean isEmpty() {
        return blockingQueue.size() == 0 ? true : false;
    }

    public boolean isFull() {
        return blockingQueue.size() == this.fixedSize ? true : false;
    }

    public int size() {
        return blockingQueue.size();
    }

    public synchronized T dequeue() throws InterruptedException {
        if (isEmpty())
            wait();
        notifyAll();
        return blockingQueue.get(0);
    }

    public synchronized void enqueue(T t) throws InterruptedException {
        if (isFull())
            wait();
        blockingQueue.add(t);
        notifyAll();

    }
}
