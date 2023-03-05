package com.steady.d9_lambda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 函数式接口的本质就是一个方法,因此可以直接由方法实例化
 */
@SpringBootTest
public class MethodTest {
    @Test
    void test1() {
        InvokeTest(3,4, Integer::sum);  //参数同,两个整数
    }
    private static void InvokeTest(int a, int b, Calculator c){
        int result=c.calc(a,b);
        System.out.println(result);
    }
    
    
    @Test
    void test(){
        Inter1 inter = MethodTest::add;  //参数类型一样,返回类型一样 lambda替换为方法引用
    }
    static Integer add(int x,int y){
        return x + y;
    }
}
interface Calculator {
    int calc(int a, int b);
}
interface Inter1 {
    Integer add(int a,int b);
}
