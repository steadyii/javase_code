package com.steady.d7_collection.MAP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
public class ToArrayTest {
    @Test
    void toMap(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
    
        ArrayList<String> strings = new ArrayList<>();
        strings.add("xx");
        strings.add("ll");
        strings.add("mm");
        
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("xxx");
        strings1.add("lll");
        strings1.add("mmm");
    
        map.put("list1",strings);
        map.put("list2",strings1);
    
        for (String s : map.keySet()) {
            System.out.println(s + "->"+map.get(s));
        }
    }
    
    @Test
    void toArray() {
    
        ArrayList<HashMap<String,Integer>> arrays = new ArrayList<>();
    
        //创建三个hashmap,然后将其放入list
        HashMap<String,Integer> map = new HashMap<>();
        map.put("xx",1);
        map.put("vv",2);
        map.put("yy",9);
        
        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("ll",3);
        map1.put("kk",4);
        
        HashMap<String,Integer> map2 = new HashMap<>();
        map2.put("oo",9);
        map2.put("pp",8);
    
    
        arrays.add(map);
        arrays.add(map1);
        arrays.add(map2);
    
        for (HashMap<String, Integer> hashMap : arrays) {
            System.out.println(hashMap);
        }
    }
}
