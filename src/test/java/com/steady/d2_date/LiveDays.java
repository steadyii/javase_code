package com.steady.d2_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输出活了多少天
 */
public class LiveDays {
    public static void main(String[] args) throws ParseException {

        System.out.println("请输入生日:yyyy-MM-dd");
        String birString = new Scanner(System.in).next();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Date birDate = sdf.parse(birString);      //出生时间
        long birTime= birDate.getTime();

        Date todayDate =new Date();           //获取当前时间
        long todayTime=todayDate.getTime();

        long timex=todayTime-birTime;
        System.out.println(timex/1000/3600/24);
    }
}
