package com.steady.d13_juc.d4;

public class Thread02notify extends Thread {  //用对象.start 启动run方法,创建一个线程执行
     @Override
     public void run() {
         try {
            synchronized (this) {
                System.out.println(
                        Thread.currentThread().getName() + ">>当前线程等待，同时释放锁!<<");
              this.wait();
            }
            System.out.println(">>run()<<");
         } catch (InterruptedException ignored) {}
     }

     public static void main(String[] args) {
         Thread02notify thread = new Thread02notify();
         thread.start();
         try {
            Thread.sleep(3000);
         } catch (Exception ignored) {}
         
         synchronized (thread) {  //锁对象内,才能使用notify,唤醒对应锁对象等待的线程
         // 唤醒正在阻塞的线程
             thread.notify();  //wait,notify 要在synchronized 中使用
         }
     }
} 
