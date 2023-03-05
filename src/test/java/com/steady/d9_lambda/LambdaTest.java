package com.steady.d9_lambda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 使用lambda接口的几种方式
 */
@SpringBootTest
public class LambdaTest {
    @Test
    void test(){
        new Inter<String>(){
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        }.print("xxx");
        
        ((Inter<String>) s -> System.out.println(s)).print("xxx");
    
        ((Inter<String>) System.out::println).print("xxx");
        
        
        
        Inter<String> inter = i ->{
            System.out.println(i);
        };
        Inter<String> inter1 = System.out::println;
        inter1.print("xxx");
    }
}
@FunctionalInterface
interface Inter <V>{
    void print(V v);
}
