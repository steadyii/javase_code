package com.steady.d9_lambda;

import java.util.function.Supplier;

/**
 * Supplier ->通过引用对象的构造函数,创建对象
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Student> s = Student::new;

        Student student = s.get();
        student.print();
    }
}
class Student {
    String name;
    public void print(){
        System.out.println("xx");
    }
}
