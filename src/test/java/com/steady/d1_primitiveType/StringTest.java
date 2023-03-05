package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class StringTest {
    //String 类的 substring 方法可以从一个较大的字符串提取出一个子串
    @Test
    void substring(){
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        System.out.println(s);
    }
    @Test
    void codePoints(){
        String greeting = "Hello";
        //多数常见字符char都是一个码点,少数多个,codePointXCount 获取具体码点数量
        System.out.println(greeting.codePointCount(0, greeting.length()));
        //遍历码点
        int[] ints = greeting.codePoints().toArray();
        System.out.println(Arrays.toString(ints));
    }
    @Test
    void api(){
        //boolean .equalsIgnoreCase(String other )
        //boolean .startsWith(String prefix )
        //boolean .endsWith(String suffix )
        
        //String .trim( )
        //返回一个新字符串。这个字符串将删除了原始字符串头部和尾部的空格
    }
    
    @Test
    void hash(){
        /*
          与大多数类不同,string重写了hashcode方法
          哈希值由字符串决定
         */
        String s = "ok";
        String s1 = new String("ok");
        System.out.println(s.hashCode() + " " + s1.hashCode());
    }
    
}
