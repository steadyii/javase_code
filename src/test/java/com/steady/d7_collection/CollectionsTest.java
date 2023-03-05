package com.steady.d7_collection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
public class CollectionsTest {
    @Test
    void testApi() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.reverse(list);
        System.out.println(list);
    }
    
    @Test
    void shuffle() {
        
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "e", "b", "c", "d");
        System.out.println(list);
        
        Collections.shuffle(list);
        System.out.println(list);
    }
    
    @Test
    void sort() {
        ArrayList<Integer> ai = new ArrayList<>();
        ai.add(3);
        ai.add(2);
        ai.add(7);
        System.out.println(ai);
    
        Collections.sort(ai, (o1, o2) -> o1 - o2);  //lambda

//        Collections.sort(ai, new Comparator<Integer>() {    //使用Collection中的sort
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        ai.sort(new Comparator<Integer>() {               //集合对象的sort
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

//        ai.sort(Comparator.comparingInt(o -> o));
    
    
        System.out.println(ai);
    }
    
    @Test
    void sortObj() {
        ArrayList<Student> alist = new ArrayList<>();
        alist.add(new Student(19, "ss"));
        alist.add(new Student(17, "sdj"));
        alist.add(new Student(20, "dk"));
    
        Collections.sort(alist);      //student实现comparable ,定义了比较规则
        System.out.println(alist);
    
        alist.sort((o1, o2) -> o2.getAge() - o1.getAge());
    
        System.out.println(alist);
    }
}