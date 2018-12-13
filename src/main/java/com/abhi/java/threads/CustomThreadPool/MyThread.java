package com.abhi.java.threads.CustomThreadPool;

/**
 * Created by abhdogra1 on 12/10/2018.
 */
public class MyThread extends Thread {
    MyBlockingQueue<Task> queue;
    volatile boolean killFlag;
    public MyThread(MyBlockingQueue<Task> queue, boolean flag) {

        this.queue = queue;
        this.killFlag = flag;
    }

    @Override
    public void run(){
        while (true){
            while(queue.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Task t = null;
                try {
                    t = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.run();

                if(this.killFlag)
                    this.interrupt();
            }
        }
    }

}
