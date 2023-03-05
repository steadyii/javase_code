package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * BigInteger 和 BigDecimal 这两个类可以处理包含任意长度数字序列的数值<br>
 * BigInteger 类实现了任意精度的整数运算<br>
 * BigDecimal 实现了任意精度的浮点数运算
 *
 */
@SpringBootTest
public class BigTest {
    @Test
    void use(){
        BigInteger bigInteger = BigInteger.valueOf(1234567891L);
        BigDecimal bigDecimal = BigDecimal.valueOf(12345.12345D);
        //add,multiply,divide,mod
        //只能使用对应计算方法,相同的BigInteger/BigDecimal 中使用
    }
}
