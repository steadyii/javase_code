package com.steady.d13_juc.d1;

import java.util.concurrent.Callable;

/**
 * Callable 可以实现创建线程返回结果
 */
public class ThreadCallable implements Callable<Integer> {
    /**
     * 当前线程需要执行的代码 并且可以返回结果
     */
    @Override
    public Integer call() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始执行..");
        
        Thread.sleep(3000);
        
        System.out.println(Thread.currentThread().getName() + "返回1");
        return 1;
    }
}
