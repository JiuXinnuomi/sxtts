package sct_io;

import java.io.*;

/**
 * 测试文件字节输出流
 */

public class TestIo02 {

    public static void main(String[] args) {
        //1.创建源
        File src = new File("src/sct_io/images/dest.txt");  //输出源时 文件不存在可以自动创建
//        ioOutputPlay(src);
//        ioOutputPlay02(src);
        ioOutputPlay03();

    }

    /*文件字节输出流基本操作*/
    public static void ioOutputPlay(File src){

        //2.选择流
        OutputStream os = null;
        try{
            os = new FileOutputStream(src,false);

            //3.操作(写出)
            String msg = "IO is so easy yes";
            byte[] datas = msg.getBytes();  //字符串---→字节数组(编码)
            os.write(datas,0,datas.length);
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.释放资源
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*文件字符输出流基本操作*/
    public static void ioOutputPlay02(File src){

        //2.选择字符流
        Writer writer = null;
        try{
            writer = new FileWriter(src);

            //3.操作(写出) 操作非字符文件时，文件会损坏
            String msg = "IO is so easy yes IO流十分简单";
            /*写法一*/
//            char[] datas = msg.toCharArray();  //字符串---→字符数组
//            writer.write(datas,0,datas.length);
            /*写法二*/
//            writer.write(msg);
//            writer.write("add");
            /*写法三*/
            writer.append(msg).append("作者是糯米");
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.释放资源
            try {
                if (writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*字节数组输出流*/
    public static void ioOutputPlay03(){
        //1.创建源,内部维护
        byte[] dest = null;

        //2.选择流,不关联源
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //3.操作(写出)
        String msg = "show me the code";
        byte[] datas = msg.getBytes();
        try {
            baos.write(datas,0,datas.length);
            baos.flush();
            //获取数据
            dest = baos.toByteArray();
            System.out.println(new String(dest,0,baos.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
