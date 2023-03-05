package com.steady.d5_innerClass;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnonymousTest {
    /**
     * 匿名内部类的使用,为了实现抽象方法..
     */
    @Test
     void use(){
        new C() {    // 匿名内部类实现抽象类
            @Override
            public void C_void() {
            }
        }.C_void();
        
        B b12= new B() {          //匿名内部类实现接口
            @Override
            public void B_show() {
                System.out.println("B_inner_unnamed");
            }
        };
        b12.B_show();
        
        //lambda
        B b = () -> System.out.println("B_area_unnamed");
        b.B_show();
    }
    
    
}
interface B {
    void B_show();
}
abstract class C {
    public abstract void C_void();
}
