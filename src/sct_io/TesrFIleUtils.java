package sct_io;

import java.io.*;

/**
 * 测试封装IO流
 */

public class TesrFIleUtils {

    public static void main(String[] args) {

        /*文件拷贝IO流封装*/
//        try {
//            InputStream is = new FileInputStream("src/sct_io/images/abc.txt");
//            OutputStream os = new FileOutputStream("src/sct_io/images/abc2.txt");
//            fileCopy(is,os);
//
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        byte[] datas = null;
        /*文件到字节数组IO流封装*/
//        try {
//            InputStream is = new FileInputStream("src/sct_io/images/nuomi.png");
//            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            fileCopy(is,os);
//            datas = os.toByteArray();
//            System.out.println(datas.length);
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        /*字节数组到文件IO流封装*/
//        try {
//            InputStream is = new ByteArrayInputStream(datas);
//            OutputStream os = new FileOutputStream("src/sct_io/images/nuomi2.png");
//            fileCopy(is,os);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    /*IO字节流文件拷贝的封装 + 自动释放资源 ★★★*/
    public static void fileCopy(InputStream is, OutputStream os){

        /* try(InputStream is = new FileInputStream(src);
               OutputStream os = new FileOutputStream(dest)  )*/
        try(is;os) {   //自动释放资源
            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源，分别关闭,先打开的后关闭
            close(is,os);
        }
    }

    /*IO流释放的封装*/
//    public static void close(InputStream is, OutputStream os){
//
//        try {
//            if (os != null) {
//                os.close();
//            }
//            if (is != null){
//                is.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /*IO流释放的封装优化 ★★★★★*/
    public static void close(Closeable... ios){  //可变参数

        for (Closeable io: ios){
            try{
                if (io != null){
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
