package com.steady.d7_collection.SET;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class HashsetTest {
    @Test
    void testApi() {
        Set<String> set = new HashSet<>();
        set.add("jack");
        set.add("tom");
        set.add("harry");
    
        for (String str : set) {
            System.out.println(str);
        }
        Iterator<String> iterator = set.iterator();
    
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
    
        set.forEach(i -> System.out.println(set));
        System.out.println(set);
    }
    
    @Test
    void linked() {
        LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.add("www");
        linkedHashSet.add("aba");
        linkedHashSet.add("yyy");
        System.out.println(linkedHashSet);
    }
}
