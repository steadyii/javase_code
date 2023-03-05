package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class StringTest {
    //String ��� substring �������Դ�һ���ϴ���ַ�����ȡ��һ���Ӵ�
    @Test
    void substring(){
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        System.out.println(s);
    }
    @Test
    void codePoints(){
        String greeting = "Hello";
        //���������ַ�char����һ�����,�������,codePointXCount ��ȡ�����������
        System.out.println(greeting.codePointCount(0, greeting.length()));
        //�������
        int[] ints = greeting.codePoints().toArray();
        System.out.println(Arrays.toString(ints));
    }
    @Test
    void api(){
        //boolean .equalsIgnoreCase(String other )
        //boolean .startsWith(String prefix )
        //boolean .endsWith(String suffix )
        
        //String .trim( )
        //����һ�����ַ���������ַ�����ɾ����ԭʼ�ַ���ͷ����β���Ŀո�
    }
    
    @Test
    void hash(){
        /*
          �������಻ͬ,string��д��hashcode����
          ��ϣֵ���ַ�������
         */
        String s = "ok";
        String s1 = new String("ok");
        System.out.println(s.hashCode() + " " + s1.hashCode());
    }
    
}
