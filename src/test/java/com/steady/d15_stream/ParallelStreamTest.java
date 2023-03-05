package com.steady.d15_stream;

import com.steady.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过使用并行流,快速对数据进行操作
 */
@SpringBootTest(classes = Application.class)
public class ParallelStreamTest {
    @Test
    void array() {
        
        int[] ints = new int[]{3, 4, 5, 2, 8, 3, 2, 9, 22};
        //并不改变原始数据,操作后需要收集结果
        Arrays.stream(ints)
                .parallel()
                        .distinct()
                                .filter(i -> i >7)
                                        .forEach(System.out::println);
        
        System.out.println(Arrays.toString(ints));
    
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
    
    @Test
    void list() {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );
        list
                .parallelStream()    //获取并行流进行操作
                .filter(i -> i > 2)
                .distinct()
                .forEach(i -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(i);
                });
        
        Thread t = Thread.currentThread();
        System.out.println(t);
    }
    
}
