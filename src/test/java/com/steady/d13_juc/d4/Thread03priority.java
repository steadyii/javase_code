package com.steady.d13_juc.d4;

public class Thread03priority {
     public static void main(String[] args) {
         Thread t1 = new Thread(() -> {
             int count = 0;
             for (; ; ) {
                System.out.println(Thread.currentThread().getName() + "," + count++);
             }
         }, "t1 线程:");
         Thread t2 = new Thread(() -> {
             int count = 0;
             for (; ; ) {
                System.out.println(Thread.currentThread().getName() + "," + count++);
             }
         }, "t2 线程:");
         t1.setPriority(Thread.MIN_PRIORITY);
         t1.setPriority(Thread.MAX_PRIORITY);
         t1.start();
         t2.start();
     }
}