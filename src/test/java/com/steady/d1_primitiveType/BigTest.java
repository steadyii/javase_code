package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger �� BigDecimal ����������Դ���������ⳤ���������е���ֵ<br>
 * BigInteger ��ʵ�������⾫�ȵ���������<br>
 * BigDecimal ʵ�������⾫�ȵĸ���������
 *
 */
@SpringBootTest
public class BigTest {
    @Test
    void use(){
        BigInteger bigInteger = BigInteger.valueOf(1234567891L);
        BigDecimal bigDecimal = BigDecimal.valueOf(12345.12345D);
        //add,multiply,divide,mod
        //ֻ��ʹ�ö�Ӧ���㷽��,��ͬ��BigInteger/BigDecimal ��ʹ��
    }
}
