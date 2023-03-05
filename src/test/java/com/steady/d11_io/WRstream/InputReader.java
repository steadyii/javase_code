package com.steady.d11_io.WRstream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 通过InputStreamReader,读取
 */
public class InputReader {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\1617149493\\Desktop\\InnerClassTest\\box.txt";
        InputStreamReader isr;
        try (FileInputStream in = new FileInputStream(path)) {
            System.out.println(in.available());

            isr = new InputStreamReader(in, StandardCharsets.UTF_8);
        }
        BufferedReader reader=new BufferedReader(isr);

        String line ;
        while(null != (line = reader.readLine())){               //bufferedReader
            System.out.println(line);
        }
    }
}