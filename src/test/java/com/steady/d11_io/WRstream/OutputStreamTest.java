package com.steady.IO_stream.WRstream;

import java.io.*;
import java.nio.charset.StandardCharsets;
public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        test1("C:\\Users\\1617149493\\Desktop\\Test\\m.txt");
    }
    public static void test1(String path) throws IOException {
        OutputStreamWriter osr =
                new OutputStreamWriter(new FileOutputStream(path,true), StandardCharsets.UTF_8);
        
        BufferedWriter br =new BufferedWriter(osr);
        String str="hja";
        br.write(str);
        br.flush();
    }
}

class write{
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\1617149493\\Desktop\\Test\\m.txt";

        OutputStreamWriter osr =
                new OutputStreamWriter(new FileOutputStream(path,false),StandardCharsets.UTF_8);

        osr.write('k');
        osr.write('\n');  //????

        char[] chars = new char[]{'h','l','g','u','\n'};
        osr.write(chars);
        osr.write("sjf?????\n");
        osr.close();
    }
}