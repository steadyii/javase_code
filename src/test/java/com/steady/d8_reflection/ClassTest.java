package com.steady.d8_reflection;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 在程序运行期间，Java 运行时系统始终为所有的对象维护一个被称为运行时的类型标识<br>
 * 这个信息跟踪着每个对象所属的类。 虚拟机利用运行时类型信息选择相应的方法执行。<br>
 * 可以通过专门的 Java 类访问这些信息。保存这些信息的类被称为 Class
 */
@SpringBootTest
public class ClassTest {
    
    /**
     * 通过反射创建对象<br>
     *
     */
    @Test
    void testCreate() throws Exception {
        //通过路径创建对象,调用类的无参构造方法,如果无参构造无法访问则报错
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        EmpEntity emp = (EmpEntity) class1.newInstance();
        emp.setName("emp.name");
        System.out.println(emp.getName());
        
        //反射,使用有参构造函数赋值,创建对象
        Constructor<?> constructor =
                class1.getConstructor(String.class, int.class);
        EmpEntity emp1 = (EmpEntity) constructor.newInstance("xx", 12);
        System.out.println(emp1);
    }
    
    /**
     * 类加载器,在检测到对象被new的时候,去jvm检查是否存在,如果存在直接调用..<br>
     * 如果不存在,将 EmpEntity.java 编译成 EmpEntity.class加载到jvm中<br>
     */
    @Test
    void testCreate1() throws ClassNotFoundException {
        EmpEntity entity = new EmpEntity();
        //new 对象以后,jvm中已经存在 EmpEntity.class 文件
        Class<EmpEntity> class2 = EmpEntity.class;
        
        Class<? extends EmpEntity> class3 = entity.getClass();
        System.out.println(class3);   //true 只有一个class被加载到JVM,路径地址相同
        System.out.println(class2);
        Class<?> class4 = Class.forName("com.steady.d8_reflection.EmpEntity");
        System.out.println(class4);
    }
    
    /**
     * 反射,给成员属性赋值,获取成员属性
     */
    @Test
    void testField() throws Exception {
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        Field name = class1.getDeclaredField("test_set_name"); //根据名称获取 字段路径
        System.out.println(name);   //保存字段的类型路径信息
        
        //获取所有public字段的值
        Field[] fields = class1.getFields();
        
        //为属性赋值,如果是private不能修改/赋值 ,需要设置访问权限
        //首先需要由class字节码文件,创建实例对象
        EmpEntity emp = (EmpEntity) class1.newInstance();
        
        Field name1 = class1.getDeclaredField("name");
        name1.setAccessible(true);
        name1.set(emp, "xxx");
        System.out.println(emp.getName());
    }
    
    /**
     * 通过反射调用方法
     */
    @Test
    void testVoid() throws Exception{
        Class<?> class1 = Class.forName("com.steady.d8_reflection.EmpEntity");
        Method[] methods = class1.getMethods();   //获取所有公有方法,包括继承的
        for (Method method : methods) {
            System.out.println(method);
            //打印方法的具体信息public java.lang.String com.steady.Empl.EmpEntity.getName()
            System.out.println(method.getName());     //getName()
        }
        
        System.out.println(class1.getMethod("print").getName());
    
        //获取有参函数,需要指定参数列表的类型
        Method string = class1.getMethod("string", String.class);
        //获取对象,调用无参构造,创建实例
        EmpEntity o = (EmpEntity) class1.newInstance();
        String res = (String) string.invoke(o,"xxx");  //Method#invoke 执行方法
        System.out.println(res);
        
        
    }
    
}
