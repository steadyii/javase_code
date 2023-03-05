package com.steady.d4_abstract.test_emp;

public class Manager extends Employee {
    private int bonus;
    
    public Manager(String name, int num, int salary,int bonus) {
        super(name, num, salary);     //继承employee属性,好像在manager中写了一样
        this.bonus=bonus;
    }
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    @Override
    public void work() {
        System.out.println("manager_work");
    }

    public int getBonus() {
        return bonus;
    }
}
