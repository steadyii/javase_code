package com.steady.d10_generic;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.TypeVariable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * �ڴ�������ʱȷ��һ������,���㿪��,ʹ�÷���<br>
 * <br>
 * �����û�з������Ͷ���<br>
 * ������������ƵĴ���,����T/U ��Ϊ�޶�(Closable)����/Object <br>
 *
 * C++ ��ÿ��ģ���ʵ����������ͬ�����ͣ���һ�����Ϊ ��ģ��������ˡ�,Java�������������
 */
@SpringBootTest
public class GenericTest {
    @Test
    void use() throws IOException {
        ArrayList<Integer> integers = new ArrayList<>();
        //...
        Pair<Integer, String> pair = new Pair<>(12,"xxx");
        //
        //���þ�̬���ͷ���,���Ϳ��ƶϳ�,���Ժ���
        Pair.<InputStream>get(Files.newInputStream(Paths.get("xx")));
    }
    
    @Test
    void array() throws Exception {
        //�޷�����ָ�����͵ķ�������
        //Pair<String,Integer>[] pairs = new Pair<>[1];
        
        //����������ͨ�������,Ȼ��cast
        Pair<String,Integer>[] pairs = (Pair<String, Integer>[]) new Pair<?,?>[1];
        pairs[0] = new Pair<>("123",123);
        System.out.println(Arrays.toString(pairs));
    }
    
    
    /**
     * ������з��ͱ�����,��������Ȼ�������͵������Ϣ<br>
     * ͨ��������Բ鿴
     */
    @Test
    void testMsg(){
        Pair<Integer, String> entity = new Pair<>();
        Class<? extends Pair> aClass = entity.getClass();
        System.out.println(aClass.getTypeName());  //com.steady.d10_generic.Pair
    
        TypeVariable<? extends Class<? extends Pair>>[] type =
                aClass.getTypeParameters();
        for (TypeVariable<? extends Class<? extends Pair>> typeVariable : type) {
            System.out.println(typeVariable.getName()); // T / U
            System.out.println(typeVariable.getGenericDeclaration());
            System.out.println(Arrays.toString(typeVariable.getAnnotatedBounds()));
        }
    }
}

/**
 * ����ʱ���Ͳ�ѯֻ��õ�ԭʼ����<br>
 * ���ܴ���ʵ������������,Pair<String>[10]  .. Error
 */
@Data
class Pair <T,U>{
    private T first;
    private U second;
    
    //�ڴ�������ʱȷ������,�޷�������̬���ͱ���
    //private static T te;
    
    public Pair(){
        first = null;
        second = null;
    }
    public Pair(T t,U u){
        first = t;
        second = u;
    }
    
    /**
     * �������ͺ�,����object,Ȼ����Ҫǿ������ת��
     */
    public static <T extends Closeable> T get(T t){
        return t;
    }
}