package com.steady.d7_collection.LIST;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

@SpringBootTest
public class QueueTest {
    @Test
    void testQueue(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(123);
        queue.add(456);
        queue.offer(789);//如果队列已经满了,返回false,add 方法会抛异常
        
        System.out.println(queue);
    }
    @Test
    void testDeque(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(123);
        deque.offer(456);
        deque.addFirst(789);
        System.out.println(deque);
    }
    
    /**
     * PriorityQueue 在添加元素时,根据比较规则排序
     */
    @Test
    void priority() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        queue.offer(3);
        queue.offer(1);
        queue.offer(9);
        
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
