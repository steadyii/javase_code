package com.steady.d2_date;

import java.util.Date;

/**
 * Date API
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        
        Date date = new Date();
        System.out.println(date);  //Sun Oct 16 01:21:15 CST 2022
        
        Date d1 = new Date(100000L);
        System.out.println(d1);       //Thu Jan 01 08:01:40 CST 1970
        
        Date d = new Date();
        long time = d.getTime(); //获取时间戳
        System.out.println(time);
    }
}
