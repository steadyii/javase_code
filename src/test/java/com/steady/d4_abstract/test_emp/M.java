package com.steady.d4_abstract.test_emp;

public class M {
    public static void main(String[] args) {
        
        /*
            向上转型,子类特有的方法不能被访问
         */
        Employee m1 =new Manager("ccc",12,24000,2000);

        m1.work();
        System.out.println("name" + m1.getName());
        System.out.println("num" + m1.getNum());
        System.out.println("salary" + m1.getSalary());
    
        Manager m11 = (Manager) m1;
        
        System.out.println(m11.getBonus());  //作为em 转型,无法访问

        Employee h =new Header("ddd",15,18000);
        System.out.println(h.getName());
        System.out.println(h.getNum());
        System.out.println(h.getSalary());
    }
}
