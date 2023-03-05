package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * 有些时候,需要由较短的字符串构建字符串
 * 采用字符串连接的方式达到此目的效率比较低。
 * 每次连接字符串， 都会构建一个新的 String 对象,既耗时,又浪费空间<br>
 * 使用 StringBuildei类就可以避免这个问题的发生<br>
 * 在需要构建字符串时就凋用 toString 方法,将可以得到一个 String对象,其中包含了构建器中的字符序列
 */
@SpringBootTest
public class StringBuilderTest {
    @Test
    void use(){
        //创建StringBuilder对象,支持基本的增删改查功能,支持链式编程
        StringBuilder builder = new StringBuilder();
        builder
                .append(12)
                .append(12.3f)
                .append('A')
                .append(new Date())
                .insert(0,'a');
        System.out.println(builder.toString());
    }
}
