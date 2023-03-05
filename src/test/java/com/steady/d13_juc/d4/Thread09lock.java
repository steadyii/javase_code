package com.steady.d13_juc.d4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread09lock implements Runnable {
     private int count = 100;
     private final Lock lock = new ReentrantLock();
     @Override
     public void run() {
         while (true) {
             try {
                Thread.sleep(30);
             } catch (Exception ignored) {}
             try {
                 // 获取锁
                 lock.lock();
                 if (count > 1) {
                     count--;
                     System.out.println(Thread.currentThread().getName() + "," + count);
                 }
             } catch (Exception e) {
                e.printStackTrace();
             } finally {
                 // 释放锁
                 lock.unlock();
             }
         }
     }
     public static void main(String[] args) {
         Thread09lock thread09 = new Thread09lock();
         Thread t1 = new Thread(thread09);
         Thread t2 = new Thread(thread09);
         t1.start();
         t2.start();
     }
}
