package com.steady.d6_InterFace.test;

public class M {
    public static void main(String[] args) {
        A_impl c1 =new Cat(5,"er");  //如果用Jump接,  c1.eat();访问不了
        c1.eat();
        c1.jump();

        Jump c2 = new Cat(7,"ad");
        c2.jump();

        System.out.println(c1.getAge());
        System.out.println(c1.getName());
    }
}
