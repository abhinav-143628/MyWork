package com.abhi.java.threads.CustomThreadPool;

/**
 * Created by abhdogra1 on 12/10/2018.
 */
public class Executor {
    MyBlockingQueue<Task> queue;
    private final int poolSize;
    volatile boolean killFlag = false;

    public Executor(int poolSize, int queueSize){
        this.poolSize = poolSize;
        this.queue    = new MyBlockingQueue<>(queueSize);
    }

    public void startExecutor(){
        for(int i = 0; i < this.poolSize; i++){
            MyThread t = new MyThread(queue,killFlag);
            t.setName("Name - "+ i);
            System.out.println("Thread Create: "+ t.getName());
            t.start();
        }
    }

    public void submitTask(Task t) throws InterruptedException {
        queue.enqueue(t);
    }

    public void destroy(){
        this.killFlag = true;
    }
}
