package com.steady.d6_InterFace;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * �ڽӿ���д��̬����/Ĭ�Ϸ���
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
class MainTest {   //ֱ�ӻ�ýӿڵ�Ĭ�Ϸ���
    @Test
    public void test() {
        DefaultVoid.print();
        new Entity().print1();
    }
    
    /**
     * �����̳нӿڵ�default������ͻ,�ӽӿڵķ�������
     */
    @Test
    void over() {
        testOver test = new testOver() {};
        test.print1();
    }
    /**
     *�ӿ��е�default������ʵ���෽����ͻ,��������
     */
    @Test
    void over1(){
        new Entity().print1();
    }
}