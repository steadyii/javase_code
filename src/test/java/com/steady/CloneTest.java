package com.steady;

import com.steady.d8_reflection.EmpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ʵ��Cloneable�ӿ�   �ṩ.clone(); ʵ�ֶ���Ŀ�¡
 */
@SpringBootTest
public class CloneTest {
    /**
     * Ĭ�ϵ� clone(); -> ǳ����<br>
     * �������Ӷ�����...<br>
     * ����Ӷ��󲻿ɱ�,��û��Ӱ��,��Math/String(�޸Ĳ������ڸ��ƺ�ִ��)<br>
     * ����ͬһ����ַ,�а�ȫ����
     */
    @Test
    void easyCopy(){
        EmpEntity emp = new EmpEntity();
        emp.setName("xxxx");
        EmpEntity clone = emp.clone();
        System.out.println(clone.getName());
    }
    
    /**
     * ���,����Ҫ�������Ӷ�����д clone(); ����
     */
    @Test
    void deepCopy(){
        //
    }
}
