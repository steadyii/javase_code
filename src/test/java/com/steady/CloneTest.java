package com.steady;

import com.steady.d8_reflection.EmpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 实现Cloneable接口   提供.clone(); 实现对象的克隆
 */
@SpringBootTest
public class CloneTest {
    /**
     * 默认的 clone(); -> 浅拷贝<br>
     * 拷贝后子对象共享...<br>
     * 如果子对象不可变,则没有影响,如Math/String(修改操作基于复制后执行)<br>
     * 引用同一个地址,有安全问题
     */
    @Test
    void easyCopy(){
        EmpEntity emp = new EmpEntity();
        emp.setName("xxxx");
        EmpEntity clone = emp.clone();
        System.out.println(clone.getName());
    }
    
    /**
     * 深拷贝,根据要拷贝的子对象重写 clone(); 方法
     */
    @Test
    void deepCopy(){
        //
    }
}
