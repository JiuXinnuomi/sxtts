package sct_io;

import java.io.*;

/**
 * 理解Io读取流操作步骤
 */

public class TestIo01 {

    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/sct_io/images/abc.txt");
//        ioPlay01(src);
//        ioPlay02(src);
//        ioPlay03(src);
//        ioPlay04(src);
        ioPlay05();


    }

    /*IO字节流基本操作 字节读取*/
    public static void ioPlay01(File src){

        //2.选择流
        try {
            InputStream  is = new FileInputStream(src);
            //3.操作
            int data1 = is.read();
            int data2 = is.read();
            int data3 = is.read();
            System.out.println(data1);
            System.out.println((char) data2);
            System.out.println(data3);
            //4.释放资源
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*IO字节流操作优化版 字节读取*/
    public static void ioPlay02(File src){

        InputStream  is = null;
        //2.选择流
        try {
            is = new FileInputStream(src);
            //3.操作  ★★★
            int temp;
            while ((temp = is.read()) != -1){  //while会重复执行()内的条件语句
                System.out.println((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*IO字节流基本操作分段读取 字节读取*/
    public static void ioPlay03(File src){

        InputStream  is = null;
        //2.选择流
        try {
            is = new FileInputStream(src);

            //3.操作(分段读取)
            byte[] flush = new byte[5];  //缓冲容器
            int len = -1;  //接收长度大小,设置为-1方便循环条件判断
            while ((len = is.read(flush)) != -1){  //while会重复执行()内的条件语句
                //字节数组---→字符串 (解码)
                String str = new String(flush,0,len);
                System.out.println(str);
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.释放资源
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*IO字符流 字符数组读取*/
    public static void ioPlay04(File src){

        //2.选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);

            //3.操作 字符流读取不会乱码
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1){
                System.out.println(flush);
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.关闭流
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*IO字节数组流 字节数组读取*/
    public static void ioPlay05(){
        //1.创建流
        byte[] src = "talk is cheap show me the code".getBytes();

        //2.选择流
        InputStream is = new ByteArrayInputStream(src);

        //3.操作(分段读取)
        try {
            byte[] flush = new byte[5];  //缓冲容器
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //字节数组---→字符串(解码)
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }//4. 不用释放流
    }

}
