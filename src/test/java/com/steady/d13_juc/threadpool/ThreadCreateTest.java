package com.steady.d13_juc.threadpool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ƶ���Ŀ����̻߳���ֹͣ�̣߳��߳���Ҫ���±� cpu �Ӿ���������״̬���ȣ�cpuƵ���������л���Ч�ʷǳ��͡�
 */
@SpringBootTest
public class ThreadCreateTest {
    /**
     * newCachedThreadPool 0-���޶��߳�,���ò�,һ�㲻ʹ��<br>
     * ��������ÿһ�ζ�����һ���µ��߳�
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
     * newFixedThreadPool �����̶������̳߳�,һ��ʹ��
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
ThreadPoolExecutor ���Ĳ���
    corePoolSize:�����߳����� һֱ���ڱ������е��߳�
    maximumPoolSize:����߳������̳߳�������������߳�����
    keepAliveTime:���� corePoolSize �󴴽����̵߳Ĵ��ʱ�䡣
    unit:keepAliveTime ��ʱ�䵥λ��
    workQueue:������У����ڱ����ִ�е�����
    threadFactory:�̳߳��ڲ������߳����õĹ�����
    handler:�����޷�ִ��ʱ�Ĵ�������
 */
