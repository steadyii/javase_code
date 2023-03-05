package com.steady.d1_primitiveType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * ��Щʱ��,��Ҫ�ɽ϶̵��ַ��������ַ���
 * �����ַ������ӵķ�ʽ�ﵽ��Ŀ��Ч�ʱȽϵ͡�
 * ÿ�������ַ����� ���ṹ��һ���µ� String ����,�Ⱥ�ʱ,���˷ѿռ�<br>
 * ʹ�� StringBuildei��Ϳ��Ա����������ķ���<br>
 * ����Ҫ�����ַ���ʱ�͵��� toString ����,�����Եõ�һ�� String����,���а����˹������е��ַ�����
 */
@SpringBootTest
public class StringBuilderTest {
    @Test
    void use(){
        //����StringBuilder����,֧�ֻ�������ɾ�Ĳ鹦��,֧����ʽ���
        StringBuilder builder = new StringBuilder();
        builder
                .append(12)
                .append(12.3f)
                .append('A')
                .append(new Date())
                .insert(0,'a');
        System.out.println(builder.toString());
    }
}
