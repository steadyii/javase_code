package com.steady.d6_InterFace;

public class T {
    public static void main(String[] args) {
        System.out.println(A.a);
        
        A d = new Dimpl();
        System.out.println(d.a);
    }
}

/**
 * 接口中的default方法/变量  默认有public static 修饰,可以直接 接口名.方法名调用
 */
interface A {
    int a = 100;
    
    void eat();
    
    default void show() {
        System.out.println("default-show");
    }
}

class Dimpl implements A {

    public Dimpl() {
        super();
    }
    @Override
    public void eat() {
        System.out.println("d-eat");
    }
}
