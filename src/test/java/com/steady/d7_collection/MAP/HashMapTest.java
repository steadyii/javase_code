package com.steady.d7_collection.MAP;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class HashMapTest {
    @Test
    void testApi() {
        HashMap<String,String> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    
        map.remove("key3");
    
        System.out.println(map);
        System.out.println(map.get("key2"));

//        boolean ic=map.containsKey("key2");
//        System.out.println(ic);
//        System.out.println(map.containsValue("value1"));
    
        Collection<String> collection=map.values();  //返回 值集
        System.out.println(collection);



//        map.keySet().forEach(System.out::println);          //forEach+lam
    
        Iterator<String> it =map.keySet().iterator();       //iterator
        while(it.hasNext()){
            String s=it.next();  //从第一个开始
        
            String value=map.get(s);
            System.out.print(s + value + " ");
        }
    
        Set<Map.Entry<String,String>> entrySet=map.entrySet();     //使用entrySet

        /*for (Map.Entry entry:entrySet){
            System.out.print(entry.getValue());
            System.out.println(entry.getKey());
        }*/
        entrySet.forEach(entry -> {
            System.out.print(entry.getValue() + entry.getKey() + " ");   //foreach
        });
    }
    
    @Test
    void main() {
        Scanner s = new Scanner(System.in);
        String str =s.next();
        HashMap<Character,Integer> map=new HashMap<>();

        for (char c:str.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c,1);
            }else {
                Integer value =map.get(c);
                value++;
                map.put(c,value);
            }
        }
        System.out.println(map);
    }
}
