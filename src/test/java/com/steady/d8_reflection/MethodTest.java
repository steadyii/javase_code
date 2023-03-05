package com.steady.d8_reflection;

import java.lang.reflect.Method;

/**
 * ʹ�� method����ʵ������..����ʵ�ֺ���ָ�����
 */
public class MethodTest {
    public static void main(String[] args) throws Exception {
        Method square = MethodTest.class.getMethod("square", int.class);
        print(square,10);
        Method abs = Math.class.getMethod("abs", int.class);
        print(abs,-100);
        
        //�Ǿ�̬������Ҫ�ṩ�����ʵ�ֶ���
//        MethodTest methodTest = new MethodTest();
        MethodTest methodTest = MethodTest.class.newInstance();
        
        Method objSquare = MethodTest.class.getMethod("objSquare", int.class);
        print(objSquare,10,methodTest);
    }
    public static int square(int x){
        return x * x;
    }
    public int objSquare(int x){
        return x * x;
    }
    
    /**
     * invoke ����,��Ҫ����ִ�ж���Ͳ���<br>
     * ����Ǿ�̬�������Դ�����Ϊnull
     */
    public static void print(Method method,int value) throws Exception{
        int invoke = (int) method.invoke(null, value);
        System.out.println(invoke);
    }
    public static void print(Method method,int value,Object obj) throws Exception{
        int invoke = (int) method.invoke(obj, value);
        System.out.println(invoke);
    }
}
