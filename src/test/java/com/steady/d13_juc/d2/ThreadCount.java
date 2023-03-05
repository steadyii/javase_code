package com.steady.d13_juc.d2;

public class ThreadCount implements Runnable {
    private static int count = 100;
    
    /**
     * 如何保证线程一直在运行状态 死循环控制
     */
    @Override
    public void run() {
        while (true) {
            //运行状态----休眠状态--cpu的执行权让给其他的线程
            // 休眠----运行状态
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cal();
        }
    }

    /**
     * 1.如果synchronized 在实例方法上 ，则使用this锁
     * 2.如果synchronized  在静态方法上 ，类名.class
     */
    public static void cal() {
        synchronized (ThreadCount.class) {
            if (count > 1) {
                count--;
                System.out.println(Thread.currentThread().getName() + "," + count);
            }
        }
    }

    public static void main(String[] args) {
        ThreadCount threadCount1 = new ThreadCount();
        ThreadCount threadCount2 = new ThreadCount();
        new Thread(threadCount1).start();    //此时创建两个线程 ,调用cal() 对count进行操作
        new Thread(threadCount1).start();
        new Thread(threadCount2).start();
    }
}
