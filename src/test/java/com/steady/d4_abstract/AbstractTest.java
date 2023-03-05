package com.steady.d4_abstract;

/**
 * 抽象类可以写具体方法被子类直接继承使用<br>
 * 也可以写抽象方法让子类重写<br>
 * 子类也直接继承变量
 */
public class AbstractTest {
    public static void main(String[] args) {
        A a = new D(5);   //向上转型 a,d 都会初始化
        a.show();
        
        
    }
}

/**
 * 包含抽象方法的类,必须被声明为 abstract类
 */
abstract class A {
    private int age;
    
    public A(){
        System.out.println("a-noargs-init");
    }
    public A(int age){
        this.age=age;
        System.out.println("a-args-init");
    }
    
    public abstract void eat();
    
    public void show(){
        System.out.println(age + "   a-show");
    }
}

class D extends A {        //继承属性age
    
    public D(){}  //默认调用父类无参构造,实例化两个对象
    public D(int age){
        super(age);
        System.out.println("d-init");
    }
    
    @Override
    public void eat() {
        System.out.println("d-eat");
    }
}

