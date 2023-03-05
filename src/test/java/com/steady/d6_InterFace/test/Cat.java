package com.steady.d6_InterFace.test;

public class Cat extends A_impl {
    
    public Cat() {
    }
    
    public Cat(int age, String name) {
        super(age, name);
    }
    
    @Override
    public void jump() {
        System.out.println("cat jump");
    }
    
    @Override
    public void eat() {
        System.out.println("cat eat");
    }
}
