package com.steady.d6_InterFace.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class A_impl implements Jump {
    
    private int age;
    private String name;
    
    @Override
    public void jump() {
        System.out.println("A impl jump");
    }
    
    public abstract void eat();
}
