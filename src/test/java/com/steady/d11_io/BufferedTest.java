package com.steady.d11_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferedTest {
    public static void main(String[] args) {

    }
}

class videoCopy{
    public static void main(String[] args) {
        String dir = "C:\\Users\\1617149493\\Desktop\\Test";
        String origin = "20221022112520.mp4";
        String target = "img\\copy.mp4";

        File file = new File(dir, origin);
        try (InputStream is = Files.newInputStream(file.toPath())){
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dir + File.separator +target));

            byte[] bytes = new byte[512];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            System.out.println("�ļ��쳣");
        }

    }
}

class Copy{
    public static void main(String[] args) {
        String path = "C:\\Users\\1617149493\\Desktop\\demox\\box.txt";

        try {
            BufferedInputStream bis =
                    new BufferedInputStream(Files.newInputStream(Paths.get(path)));

            BufferedOutputStream bos =
                    new BufferedOutputStream(Files.newOutputStream(Paths.get("C:\\Users\\1617149493\\Desktop\\demox\\copy.txt")));

            int size;
            byte[] buf =new byte[256];
            while ((size=bis.read(buf))!=-1){
                bos.write(buf,0,size);
            }
            bos.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Reader{
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\1617149493\\Desktop\\demox\\box.html";

        BufferedReader reader=new BufferedReader(new FileReader(path));
        if (!reader.ready()){
            System.out.println("not-ready");
            return;
        }
        int size;
        char[] buf=new char[1024];
        while ((size= reader.read(buf,0, buf.length))!=-1){
            System.out.println(new String(buf,0,size));
        }
    }
}

class writer{
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\1617149493\\Desktop\\demox\\b.txt";

        BufferedWriter writer=new BufferedWriter(new FileWriter(path));

        char ch='x';
        writer.write(ch);

        String o="adhjegaega";
        writer.write(o.toCharArray(),0,o.length());
        writer.close();
    }
}
