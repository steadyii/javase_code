package com.steady.d2_date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

/**
 * LocalDate �ṩ������ʾ�� (�� �� ��)
 */
@SpringBootTest
public class LocalDateTest {
    @Test
    void api(){
        LocalDate now = LocalDate.now(); //Ĭ��ʹ�ñ���zone,���Ի�ȡ��ͬ����time
        System.out.println(now); //2023-02-23
        
        System.out.println(now.getDayOfYear());
        //ʹ��api��LocalDate ���в���
        LocalDate aft = now.plusDays(1000);
        System.out.println(aft);
        //�ṩ������,����localDate����
        LocalDate date = LocalDate.of(1966, 11, 23);
        
    }
}
