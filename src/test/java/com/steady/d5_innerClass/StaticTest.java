package com.steady.d5_innerClass;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * 类内部类的使用方法
 */
@SpringBootTest
public class StaticTest {
    
    @Test
    void testStatic(){
        OuterEntity outerEntity = new OuterEntity();
        
    }
    //局部内部类,在方法中写一个类,作用域限定在方法中
    @Test
    void areaClass(){
        class areaInner{
            public void print(){
                System.out.println("area-print");
            }
        }
        areaInner areaInner = new areaInner();
        areaInner.print();
    }
    
}
class OuterEntity{
    int age;
    
    /**
     * 有时候,使用内部类只是为了把一个类隐藏在另外一个类的内部，并不需要内部类引用
     * 外围类对象。可以将内部类声明为 static, 以便取消产生的引用。
     * <br><br>
     * 静态内部类,作用像一个组件,LinkedList中的node节点,static方便实用<br>
     * 修饰符为 public时,可以被外界直接调用
     */
    @Data
    public static class InnerEntity{
        int age;
        public void print(){
            System.out.println("entity-static-print");
        }
    }
}
