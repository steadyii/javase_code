package com.steady.d7_collection;

import lombok.*;


@AllArgsConstructor
@Data
public class Student implements Comparable<Student>{
    private int age;
    private String name;

    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }
}
