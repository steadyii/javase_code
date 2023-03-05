package com.steady.d13_juc.threadpool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 频繁的开启线程或者停止线程，线程需要从新被 cpu 从就绪到运行状态调度，cpu频繁上下文切换，效率非常低。
 */
@SpringBootTest
public class ThreadCreateTest {
    /**
     * newCachedThreadPool 0-无限多线程,复用差,一般不使用<br>
     * 但并不是每一次都创建一个新的线程
     */
    @Test
    void cachedPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <200; i++) {
            int finalI = i;
            executorService.execute(
                    () -> System.out.println(Thread.currentThread().getName() + "--" + finalI)
            );
        }
    }
    
    /**
     * newFixedThreadPool 创建固定个数线程池,一般使用
     */
    @Test
    void test3(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <200; i++) {
            int finalI = i;
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + "--" + finalI));
        }
    }
}
/*
ThreadPoolExecutor 核心参数
    corePoolSize:核心线程数量 一直正在保持运行的线程
    maximumPoolSize:最大线程数，线程池允许创建的最大线程数。
    keepAliveTime:超出 corePoolSize 后创建的线程的存活时间。
    unit:keepAliveTime 的时间单位。
    workQueue:任务队列，用于保存待执行的任务。
    threadFactory:线程池内部创建线程所用的工厂。
    handler:任务无法执行时的处理器。
 */
