package com.steady.d3_inheritance;

/**
 * 多态中的转型<br>
 *
 */
public class TransitionTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        System.out.println(dog.age);
        System.out.println(dog.weight);
        
        Animal a =new Dog();  //向上转型,可以访问父类方法,如果子类有重写 则优先调用子类的
        a.eat();         //dog-eat
        
//      a.sleep();     子类特有的方法,向上转型后不能访问
        
        System.out.println(a.age);     // 20,向上转型可以直接访问父类公有字段,但不能访问子类字段
//        System.out.println(a.weight);    向上转型不能直接访问子类字段
    }
}
class Animal {
    public int age = 20;
    public void eat(){
        System.out.println("Animal-eat");
    }
}
class Dog extends Animal {
    
    public int age =10;
    public int weight =30;
    @Override
    public void eat() {
        System.out.println("dog-eat");
    }
    
    public void sleep(){
        System.out.println("dog-sleep");
    }
}