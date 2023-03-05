package com.steady.d11_io;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * File APi
 */
@SpringBootTest
public class FileTest {
    @Test
    void testApi() throws Exception {
//        System.out.println(File.separator);                \
//        System.out.println(File.pathSeparator);            ;
        
        //createNewFile 父路径必须存在
//        File file = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\mk.java");
//        System.out.println(file.createNewFile());
   
        //mkdir 只能创建一级目录
        File file1 = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\vv");
        System.out.println(file1.mkdir());

//        mkdirs 可以创建多级目录
        File file2 = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\demo\\ll\\xnh");
        System.out.println(file2.mkdirs());

//        System.out.println(file.isFile());        //true  判断当前file类是否存在
//        System.out.println(file.isDirectory());

//        System.out.println(file.isAbsolute());     //true,是否是绝对路径
//        System.out.println(file.exists());      // true ,是否存在->file/dic
//
//        //delete 删除操作,返回是否成功
//        System.out.println(file1.delete());
    }
    
    /**
     * 遍历文件夹下文件
     */
    @Test
    void iter(){
        File file=new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest");
        System.out.println(Arrays.toString(file.list()));  //file是目录,输出所有子级文件
    
        File[] files=file.listFiles();
        for (File file1 : Objects.requireNonNull(files)) {
            System.out.println(file1);
            System.out.println(file1.getName());
        }
        System.out.println("--------------------");
        File f = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\Test");
    
        bl(f);
    }
    public static void bl(File file){
        if (file == null) return;
        if (file.isFile()) {
            System.out.println(file.getPath());
        }
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files == null){
                System.out.println(file.getPath());
            }else {
                for (File file1 : files) {
                    bl(file1);
                }
            }
        }
    }
}











