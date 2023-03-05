package com.steady.d3_inheritance;

/**
 * ��ļ̳�
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
    private int salary;   //private ��Ϊ protected,���� manager����ֱ�ӷ�����
    
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
    public Manager(int salary,int bonus){     //�ڹ��캯���з��� super.salary
        super(salary);
        this.bonus = bonus;
    }
    //���಻��ֱ�ӷ��ʸ����˽���ֶ�  ����ֱ��ʹ�� salary����
    private int bonus;
    
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    public int getBonus() {
        return bonus;
    }
    
    //������д����ķ���
    @Override
    public int getSalary() {
        return bonus + super.getSalary();
    }
    
    @Override
    public String toString() {        //toString �̳и���,��д�͵��ø����
        return "Manager{" +
                "bonus=" + bonus + ";" +
                "salary" + getSalary() +
                '}';
    }
}
