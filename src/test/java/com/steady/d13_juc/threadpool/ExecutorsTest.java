package com.steady.d13_juc.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executors JDK提供的线程池
 */
public class ExecutorsTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new ThreadImpl());
        
        String res = "resr";
        Future<String> submit = es.submit(new RunnableImpl(), res);
        System.out.println(submit.get());
        es.shutdown();
    }
}
class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println("runImpl" + Thread.currentThread().getName());
    }
}
class ThreadImpl extends Thread{
    @Override
    public void run() {
        System.out.println("threadImpl" + Thread.currentThread().getName());
    }
}