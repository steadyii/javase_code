package com.steady.d10_generic;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.TypeVariable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 在创建对象时确定一个类型,方便开发,使用方便<br>
 * <br>
 * 虚拟机没有泛型类型对象<br>
 * 经过类擦除机制的处理,泛型T/U 变为限定(Closable)类型/Object <br>
 *
 * C++ 中每个模板的实例化产生不同的类型，这一现象称为 “模板代码膨账”,Java不存在这个问题
 */
@SpringBootTest
public class GenericTest {
    @Test
    void use() throws IOException {
        ArrayList<Integer> integers = new ArrayList<>();
        //...
        Pair<Integer, String> pair = new Pair<>(12,"xxx");
        //
        //调用静态泛型方法,类型可推断出,可以忽略
        Pair.<InputStream>get(Files.newInputStream(Paths.get("xx")));
    }
    
    @Test
    void array() throws Exception {
        //无法创建指定泛型的泛型数组
        //Pair<String,Integer>[] pairs = new Pair<>[1];
        
        //可以先声明通配符数组,然后cast
        Pair<String,Integer>[] pairs = (Pair<String, Integer>[]) new Pair<?,?>[1];
        pairs[0] = new Pair<>("123",123);
        System.out.println(Arrays.toString(pairs));
    }
    
    
    /**
     * 虚拟机中泛型被擦除,但类中仍然保留泛型的相关信息<br>
     * 通过反射可以查看
     */
    @Test
    void testMsg(){
        Pair<Integer, String> entity = new Pair<>();
        Class<? extends Pair> aClass = entity.getClass();
        System.out.println(aClass.getTypeName());  //com.steady.d10_generic.Pair
    
        TypeVariable<? extends Class<? extends Pair>>[] type =
                aClass.getTypeParameters();
        for (TypeVariable<? extends Class<? extends Pair>> typeVariable : type) {
            System.out.println(typeVariable.getName()); // T / U
            System.out.println(typeVariable.getGenericDeclaration());
            System.out.println(Arrays.toString(typeVariable.getAnnotatedBounds()));
        }
    }
}

/**
 * 运行时类型查询只会得到原始类型<br>
 * 不能创建实例化类型数组,Pair<String>[10]  .. Error
 */
@Data
class Pair <T,U>{
    private T first;
    private U second;
    
    //在创建对象时确定泛型,无法声明静态泛型变量
    //private static T te;
    
    public Pair(){
        first = null;
        second = null;
    }
    public Pair(T t,U u){
        first = t;
        second = u;
    }
    
    /**
     * 擦除泛型后,返回object,然后需要强制类型转换
     */
    public static <T extends Closeable> T get(T t){
        return t;
    }
}