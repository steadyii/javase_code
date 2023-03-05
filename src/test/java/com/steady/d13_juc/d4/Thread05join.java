package com.steady.d13_juc.d4;

//创建三个线程,确定执行顺序

public class Thread05join {
     public static void main(String[] args) throws InterruptedException {
         Thread t1 = new Thread(() -> {
             try {
                 Thread.sleep(3000);
                 
             } catch (Exception ignored) {
             }
             System.out.println(Thread.currentThread().getName() + ",线程执行");
         });
    
         Thread t2 = new Thread(() -> {
             try {
                t1.join();
             } catch (InterruptedException ignored) {}
             
             System.out.println(Thread.currentThread().getName() + ",线程执行");
         });
         Thread t3 = new Thread(() -> {
             try {
                t2.join();
             } catch (InterruptedException ignored) {}
             
             System.out.println(Thread.currentThread().getName() + ",线程执行");
         });
         t1.start();
         t2.start();
         t3.start();
     }
} 
