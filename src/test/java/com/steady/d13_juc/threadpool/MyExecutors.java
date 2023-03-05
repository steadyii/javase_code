package com.steady.d13_juc.threadpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 简单手写一个线程池
 */
public class MyExecutors {
    public BlockingDeque<Runnable> runnables;       //存放任务的队列
    private volatile Boolean isRun = true;
  
    public MyExecutors(int dequeSize, int nThreads) {
        runnables = new LinkedBlockingDeque<>(dequeSize);
        for (int i = 0; i < nThreads; i++) {
            WorkThread workThread = new WorkThread(); workThread.start();
        }
    }
    public void execute(Runnable runnable) {
        runnables.offer(runnable);
    }
 
    class WorkThread extends Thread {
        @Override
        public void run() {
            while (isRun||runnables.size()>0) {
                Runnable runnable = runnables.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }
    public static void main(String[] args) {
        MyExecutors myExecutors = new MyExecutors(10, 2);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            myExecutors.execute(new Runnable() {
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName() + ":," + finalI);
                }
            });
        }
        myExecutors.isRun=false;
    }
}
