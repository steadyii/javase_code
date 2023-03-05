package com.steady.d8_reflection;

import java.lang.reflect.Method;

/**
 * 使用 method方法实例对象..可以实现函数指针操作
 */
public class MethodTest {
    public static void main(String[] args) throws Exception {
        Method square = MethodTest.class.getMethod("square", int.class);
        print(square,10);
        Method abs = Math.class.getMethod("abs", int.class);
        print(abs,-100);
        
        //非静态方法需要提供具体的实现对象
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
     * invoke 方法,需要传入执行对象和参数<br>
     * 如果是静态方法可以传对象为null
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
