package com.steady.d11_io.IOstream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class videoCopy {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\Users\\1617149493\\Desktop\\Test";
        String origin = "20221022112520.mp4";
        String target = "img\\copy.mp4";
    
        File file = new File(dir, origin);
        try (BufferedInputStream bis =
                     new BufferedInputStream(Files.newInputStream(file.toPath()));
            BufferedOutputStream bos =
                    new BufferedOutputStream(
                            Files.newOutputStream(Paths.get(dir + File.separator + target)))
        ){
            byte[] bytes = new byte[512];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        }
    }
}

/**
 * FileIO
 */
class copyFile{
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\Chang");
        File target = new File("C:\\Users\\1617149493\\Desktop\\InnerClassTest\\xx");
        boolean m = target.mkdir();
        System.out.println(m);

        for (File f : Objects.requireNonNull(file.listFiles())){
            try (
                    FileInputStream fis = new FileInputStream(f);
                    
                    FileOutputStream fos =
                         new FileOutputStream(target.getPath() + "/" + f.getName())
            ) {

                byte[] bytes = new byte[256];
                int a;
                while ((a = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, a);
                }
                fos.flush();
            }
        }
    }
    
}