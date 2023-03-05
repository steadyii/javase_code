package com.steady.d4_abstract.test_emp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Employee {
    private String name;
    private int num;
    private int salary;

    public abstract void work();
}
