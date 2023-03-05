package com.steady.d3_inheritance;

/**
 * 类的继承
 */
public class ExtendsTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setSalary(12345);
        manager.setBonus(500);
        System.out.println(manager);
    }
}

class Employee {
    public Employee(){}
    public Employee(int salary){
        this.salary = salary;
    }
    private int salary;   //private 改为 protected,子类 manager就能直接访问了
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getSalary() {
        return salary;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }
}

class Manager extends Employee {
    public Manager(){}
    public Manager(int salary,int bonus){     //在构造函数中访问 super.salary
        super(salary);
        this.bonus = bonus;
    }
    //子类不能直接访问父类的私有字段  不能直接使用 salary属性
    private int bonus;
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public int getBonus() {
        return bonus;
    }
    
    //可以重写父类的方法
    @Override
    public int getSalary() {
        return bonus + super.getSalary();
    }
    
    @Override
    public String toString() {        //toString 继承父类,重写就调用父类的
        return "Manager{" +
                "bonus=" + bonus + ";" +
                "salary" + getSalary() +
                '}';
    }
}
