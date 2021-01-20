package sct_io;

import java.io.*;

/**
 * 测试输入输出字节缓冲流
 */

public class TestBufferedByte {

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        //1.创建源
        File src = new File("src/sct_io/images/pigu.mp4");
        File dest = new File("src/sct_io/images/pigu2.mp4");
        copyByte(src,dest);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }

    /*加入字节缓冲流提高运行效率，同时优化释放资源*/
    public static void copyByte(File srcPath, File destPath){

        //2.选择流 同时加入缓冲流
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))
            ) {
            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = bis.read(flush)) != -1){
                bos.write(flush,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
