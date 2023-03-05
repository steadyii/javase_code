package com.steady.d11_io.IOstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImgsCopy {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\Users\\1617149493\\Desktop\\InnerClassTest";
        File file = new File(dir + "\\img");
        File[] files = file.listFiles();

        assert files != null;
        for (File fi : files) {
            String filename = fi.getName();
            copy(fi.getAbsolutePath(), dir + "\\img1\\" + filename);
        }
    }

    //传入..照片路径
    public static void copy(String from, String to) throws IOException {
        File targetDir = new File(new File(to).getParent());//from 直接读取,to可能创建文件夹
        if (!targetDir.exists()) {
            System.out.println(targetDir.mkdirs());
        }
        BufferedInputStream bis =
                new BufferedInputStream(Files.newInputStream(Paths.get(from)));
        
        BufferedOutputStream bos =
                new BufferedOutputStream(Files.newOutputStream(Paths.get(to)));

        int size;         //while中 bus一次读取的长度
        byte[] buf = new byte[256];
        while ((size = bis.read(buf)) != -1) {
            bos.write(buf, 0, size);
        }

        bos.flush();
        bis.close();
        bos.close();
    }
}


class copyImg{
    public static void main(String[] args) throws IOException {
        FileInputStream fis =
                new FileInputStream("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\img\\LinkedList.png");
        FileOutputStream fos =
                new FileOutputStream("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\LinkedList.png");
        
        int len;
        byte[] bytes = new byte[256];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}