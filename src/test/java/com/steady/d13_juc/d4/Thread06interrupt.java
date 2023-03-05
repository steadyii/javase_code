package com.steady.d13_juc.d4;

/**
 * Interrupt 打断正在运行或者正在阻塞的线程。
 * 1.如果目标线程在调用 Object class 的 wait()、wait(long)或 wait(long, int)方法、join()、
 * join(long,int)或 sleep(long, int)方法时被阻塞，那么 Interrupt 会生效，该线程的中断状态将被清除，
 * 抛出 InterruptedException 异常。
 * 2.如果目标线程是被 I/O 或者 NIO 中的 Channel 所阻塞，同样 I/O操作会被中断或者返回特
 * 殊异常值。达到终止线程的目的。
 * 如果以上条件都不满足，则会设置此线程的中断状态
 */
public class Thread06interrupt {
    private final Object object = new Object();
    public Thread print() {
        return new Thread(() -> {
            synchronized (object) {
                System.out.println("1");
                try {
                    object.wait(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2");
            }
        });
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread06interrupt thread06 = new Thread06interrupt();
        Thread thread = thread06.print();    //封装方法,返回一个执行线程
        thread.start();
        try {
            Thread.sleep(3000);
            thread.interrupt();      //打断阻塞,继续运行
        } catch (Exception ignored) {}
    }
}