package com.steady.d13_juc.d1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread02 {
    public static void main(String[] args) throws Exception {
        
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(threadCallable);
        
//        new Thread(integerFutureTask).start();    //开始执行ThreadCallable中的 run 方法
        
        System.out.println("main 等待返回结果");
        //主线程继续执行  .get() 获取不到结果 会阻塞
        Integer result1 = integerFutureTask.get();  //获取返回值
        System.out.println(Thread.currentThread().getName() + "," + result1);
        
        
        // juc 并发中
//        Thread thread01 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是子线程开始");
//                LockSupport.park();
//                System.out.println("我是子线程结束");
//            }
//        });
//        thread01.start();
//
//        Thread.sleep(3000);
//        LockSupport.unpark(thread01);
    }
}
