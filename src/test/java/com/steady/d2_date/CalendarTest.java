package com.steady.d2_date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

/**
 * Calendar API
 */
@SpringBootTest
public class CalendarTest {
    @Test
    void test(){
        Calendar c =Calendar.getInstance();  //通过工厂模式获取实例
        System.out.println(c);

        System.out.println(c.getTime());     // Sun Oct 16 09:41:48 CST 2022
        System.out.println(c.get(Calendar.YEAR));   //c.get(Calendar.YEAR)   2022
        System.out.println(c.get(Calendar.MONTH)+1);

        c.set(Calendar.YEAR,1111);
        System.out.println(c.get(Calendar.YEAR));

        c.add(Calendar.YEAR,2);
        System.out.println(c.get(Calendar.YEAR));

    }
}
