package com.steady.d2_date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * LocalDate 提供日历表示法 (年 月 日)
 */
@SpringBootTest
public class LocalDateTest {
    @Test
    void api(){
        LocalDate now = LocalDate.now(); //默认使用本地zone,可以获取不同地区time
        System.out.println(now); //2023-02-23
        
        System.out.println(now.getDayOfYear());
        //使用api对LocalDate 进行操作
        LocalDate aft = now.plusDays(1000);
        System.out.println(aft);
        //提供年月日,创建localDate对象
        LocalDate date = LocalDate.of(1966, 11, 23);
        
    }
}
