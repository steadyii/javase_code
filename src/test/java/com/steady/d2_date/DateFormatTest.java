package com.steady.d2_date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class DateFormatTest {
    @Test
    void test() {
        SimpleDateFormat sd = new SimpleDateFormat();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        Date date =new Date();
        
        String time1=sd.format(date);
        String time=s.format(date);
        
        
        System.out.println(time1);   //2023-02-23 22-27-47
        System.out.println(time);   //23-2-23 下午10:27
        
    }

    @Test
    void test1() throws ParseException {
        String date = "2022-10-16 09-38-48";
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date d;
        
        d = s.parse(date);
        
        System.out.println(d);   // Sun Oct 16 09:38:48 CST 2022
    }
}
