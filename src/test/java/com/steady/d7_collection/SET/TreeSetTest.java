package com.steady.d7_collection.SET;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TreeSet;

@SpringBootTest
public class TreeSetTest {
    @Test
    void main() {
        //treeSet 传入Comparator 比较器
        TreeSet<Integer> treeSet = new TreeSet<>((o1,o2) -> o2 - o1);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(5);
        System.out.println(treeSet);      //[1, 3, 5]
        treeSet.forEach(System.out::println);
    }
}
