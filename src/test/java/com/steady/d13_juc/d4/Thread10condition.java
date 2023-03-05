package com.steady.d13_juc.d4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition 可以完成 wait notify 操作
 */
public class Thread10condition {
     private final ReentrantLock lock = new ReentrantLock();
     private final Condition condition = lock.newCondition();
     
     public static void main(String[] args) {
         Thread10condition thread10 = new Thread10condition();
         try {
             thread10.print();
             Thread.sleep(3000);
             thread10.signal();     //唤醒print 线程
         } catch (Exception ignored) {
         }
     }
     
     
     public void print() {
         new Thread(() -> {
             try {
                lock.lock();
                 System.out.println(Thread.currentThread().getName() + ",1");
                 condition.await();    // 释放锁 同时当前线程阻塞
                 System.out.println(Thread.currentThread().getName() + ",2");
             } catch (Exception e) {
                e.printStackTrace();
             } finally {
                 lock.unlock();
             }
         }).start();
     }
     public void signal() {
         try {
            lock.lock();
            condition.signal();     //封装一个锁内signal
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }
}
