package com.steady.d13_juc.d1;

public class Thread01 extends Thread {
    
    /**
     * 线程执行的代码 就是在run方法中  执行完毕 线程死亡
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "<我是子线程>");
        try {
            // 当前线程阻塞3s 时间
            Thread.sleep(3000);
        } catch (Exception ignored) {

        }
        System.out.println(Thread.currentThread().getName() + "<阻塞完毕！>");
    }

    public static void main(String[] args) {
        
        // 启动线程 调用start方法而不是run方法
        System.out.println(Thread.currentThread().getName());
        // 调用start()线程是不是立即被cpu调度执行 就绪状态 ----等待cpu调度 线程从 就绪到运行状态
        new Thread01().start();
        new Thread01().start();
        System.out.println("主线程执行完毕!");
    }
}
class ThreadRunnable implements Runnable {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "<我是子线程>");
    }
    
    public static void main(String[] args) {
//        // 启动线程
//        new Thread(new ThreadRunnable()).start();
        // 2.使用匿名内部类的形式创建线程
        new Thread(() ->
                System.out.println(Thread.currentThread().getName() + "<我是子线程>")
                , "线程"
        ).start();

//      错误创建线程,当做普通方法执行
//        ThreadRunnable threadRunnable = new ThreadRunnable();
//        threadRunnable.run();
    
    }
}
