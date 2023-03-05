package com.steady.d4_abstract.test_emp;

public class Header extends Employee {

    @Override
    public void work() {
        System.out.println("header_work");
    }

    public Header(String name, int num, int salary) {
        super(name, num, salary);
    }
}
