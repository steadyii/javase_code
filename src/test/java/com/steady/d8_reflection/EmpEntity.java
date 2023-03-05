package com.steady.d8_reflection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
public class EmpEntity implements Cloneable{
    private String name;
    public String test_set_name;
    private int id;
    
    private Date date;
    
    public EmpEntity(){
        System.out.println("emp-noargs-constructor");
    }

    public EmpEntity(String name, int id) {
        System.out.println("emp-allargs-constructor");
        this.name = name;
        this.id = id;
    }
    
    public void print(){
        System.out.println("emp-print-method");
    }
    public String string(String s){
        System.out.println("emp-string" + s);
        return "res-of-method-string";
    }
    
    @Override
    public EmpEntity clone() {
        try {
            EmpEntity clone = (EmpEntity) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            //分别拷贝子对象并赋值
            clone.date = (Date) date.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}