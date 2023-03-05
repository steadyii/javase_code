package com.steady.d7_collection.LIST;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.Arrays;

/**
 * List 一些基本api
 */
@SpringBootTest
public class ListTest {
    @Test
    void asList(){
        //Arrays.asList,返回Arrays中的一个独有的ArrayList
        // 固不可以做结构性改变,可以set修改值
        Integer[] array = new Integer[]{1,5,2,4,7,3,6};
        
        List<Integer> list = Arrays.asList(array);
        list.set(0,8);
//        list.add(1,8);

        System.out.println(list.get(3));
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
