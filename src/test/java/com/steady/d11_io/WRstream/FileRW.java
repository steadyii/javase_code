package com.steady.d11_io.WRstream;

import java.io.*;

/**
 * FileWriter...FileReader
 */
public class FileRW {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("C:\\Users\\1617149493\\Desktop\\Test\\a.html");
                FileWriter fw = new FileWriter("C:\\Users\\1617149493\\Desktop\\Test\\m.txt")
        ) {
            int len;
            char[] chars = new char[128];
            while ((len = fr.read(chars)) != -1){
                fw.write(chars,0,len);
            }
        } catch (IOException e) {
            System.out.println("exp");
        }
    }
}
class BufferedWR{
    public static void main(String[] args) {
        try (
                BufferedReader br = new
                        BufferedReader(new FileReader("C:\\Users\\1617149493\\Desktop\\Test\\a.html"));
                BufferedWriter bw =
                        new BufferedWriter(new FileWriter("C:\\Users\\1617149493\\Desktop\\Test\\m.txt"))
        ) {
            int len;
            char[] chars = new char[128];
            while ((len = br.read(chars)) != -1){
                bw.write(chars,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}














