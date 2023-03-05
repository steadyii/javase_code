package com.steady.d5_innerClass;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

/**
 * ���ڲ����ʹ�÷���
 */
@SpringBootTest
public class StaticTest {
    
    @Test
    void testStatic(){
        OuterEntity outerEntity = new OuterEntity();
        
    }
    //�ֲ��ڲ���,�ڷ�����дһ����,�������޶��ڷ�����
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
     * ��ʱ��,ʹ���ڲ���ֻ��Ϊ�˰�һ��������������һ������ڲ���������Ҫ�ڲ�������
     * ��Χ����󡣿��Խ��ڲ�������Ϊ static, �Ա�ȡ�����������á�
     * <br><br>
     * ��̬�ڲ���,������һ�����,LinkedList�е�node�ڵ�,static����ʵ��<br>
     * ���η�Ϊ publicʱ,���Ա����ֱ�ӵ���
     */
    @Data
    public static class InnerEntity{
        int age;
        public void print(){
            System.out.println("entity-static-print");
        }
    }
}
