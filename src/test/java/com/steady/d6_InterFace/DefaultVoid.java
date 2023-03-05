package com.steady.d6_InterFace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 在接口中写静态方法/默认方法
 */
public interface DefaultVoid {
    
    default void print1(){
        System.out.println("inter-default");
    }
    
    static void print(){
        System.out.println("static");
    }
}
interface testOver extends DefaultVoid {
    default void print1(){
        System.out.println("default-InnerClassTest-over");
    }
}
class Entity implements DefaultVoid{
    public void print1(){
        System.out.println("entity-default");
    }
}
@SpringBootTest
class MainTest {   //直接获得接口的默认方法
    @Test
    public void test() {
        DefaultVoid.print();
        new Entity().print1();
    }
    
    /**
     * 两个继承接口的default方法冲突,子接口的方法覆盖
     */
    @Test
    void over() {
        testOver test = new testOver() {};
        test.print1();
    }
    /**
     *接口中的default方法和实现类方法冲突,超类优先
     */
    @Test
    void over1(){
        new Entity().print1();
    }
}