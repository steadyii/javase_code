package com.steady.d8_reflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * �ڳ��������ڼ䣬Java ����ʱϵͳʼ��Ϊ���еĶ���ά��һ������Ϊ����ʱ�����ͱ�ʶ<br>
 * �����Ϣ������ÿ�������������ࡣ �������������ʱ������Ϣѡ����Ӧ�ķ���ִ�С�<br>
 * ����ͨ��ר�ŵ� Java �������Щ��Ϣ��������Щ��Ϣ���౻��Ϊ Class
 */
@SpringBootTest
public class ClassTest {
    
    /**
     * ͨ�����䴴������<br>
     *
     */
    @Test
    void testCreate() throws Exception {
        //ͨ��·����������,��������޲ι��췽��,����޲ι����޷������򱨴�
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        EmpEntity emp = (EmpEntity) class1.newInstance();
        emp.setName("emp.name");
        System.out.println(emp.getName());
        
        //����,ʹ���вι��캯����ֵ,��������
        Constructor<?> constructor =
                class1.getConstructor(String.class, int.class);
        EmpEntity emp1 = (EmpEntity) constructor.newInstance("xx", 12);
        System.out.println(emp1);
    }
    
    /**
     * �������,�ڼ�⵽����new��ʱ��,ȥjvm����Ƿ����,�������ֱ�ӵ���..<br>
     * ���������,�� EmpEntity.java ����� EmpEntity.class���ص�jvm��<br>
     */
    @Test
    void testCreate1() throws ClassNotFoundException {
        EmpEntity entity = new EmpEntity();
        //new �����Ժ�,jvm���Ѿ����� EmpEntity.class �ļ�
        Class<EmpEntity> class2 = EmpEntity.class;
        
        Class<? extends EmpEntity> class3 = entity.getClass();
        System.out.println(class3);   //true ֻ��һ��class�����ص�JVM,·����ַ��ͬ
        System.out.println(class2);
        Class<?> class4 = Class.forName("com.steady.d8_reflection.EmpEntity");
        System.out.println(class4);
    }
    
    /**
     * ����,����Ա���Ը�ֵ,��ȡ��Ա����
     */
    @Test
    void testField() throws Exception {
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        Field name = class1.getDeclaredField("test_set_name"); //�������ƻ�ȡ �ֶ�·��
        System.out.println(name);   //�����ֶε�����·����Ϣ
        
        //��ȡ����public�ֶε�ֵ
        Field[] fields = class1.getFields();
        
        //Ϊ���Ը�ֵ,�����private�����޸�/��ֵ ,��Ҫ���÷���Ȩ��
        //������Ҫ��class�ֽ����ļ�,����ʵ������
        EmpEntity emp = (EmpEntity) class1.newInstance();
        
        Field name1 = class1.getDeclaredField("name");
        name1.setAccessible(true);
        name1.set(emp, "xxx");
        System.out.println(emp.getName());
    }
    
    /**
     * ͨ��������÷���
     */
    @Test
    void testVoid() throws Exception{
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        Method[] methods = class1.getMethods();   //��ȡ���й��з���,�����̳е�
        for (Method method : methods) {
            System.out.println(method);
            //��ӡ�����ľ�����Ϣpublic java.lang.String com.steady.Empl.EmpEntity.getName()
            System.out.println(method.getName());     //getName()
        }
        
        System.out.println(class1.getMethod("print").getName());
    
        //��ȡ�вκ���,��Ҫָ�������б������
        Method string = class1.getMethod("string", String.class);
        //��ȡ����,�����޲ι���,����ʵ��
        EmpEntity o = (EmpEntity) class1.newInstance();
        String res = (String) string.invoke(o,"xxx");  //Method#invoke ִ�з���
        System.out.println(res);
        
        
    }
    
}
