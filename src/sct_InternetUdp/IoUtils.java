package sct_InternetUdp;

import java.io.*;

/**
 * 测试图片存入字节数组，再由字节数组输出为图片 ★★★★★
 */

public class IoUtils {

    /*图片读取到字节数组
    * 图片到程序 FileInputStream
    * 程序到字节数组 ByteArrayOutputStream  */
    public static byte[] fileToByteArray(String filePath){

        //1.创建源与目的地
        File src = new File(filePath);
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        //2.选择流
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();

            //3.操作(分段读取)
            byte[] flush = new byte[1024];  //缓冲容器
            int len = -1;  //接收长度大小,设置为-1方便循环条件判断
            while ((len = is.read(flush)) != -1){  //while会重复执行()内的条件语句
                baos.write(flush,0,len);

            }
            baos.flush();
            return baos.toByteArray();

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
        return null;

    }

    /*字节数组写出到图片
    * 字节数组到程序 ByteArrayInputStream
    * 程序到文件 FileOutputStream  */
    public static void byteArrayToFile(byte[] src,String filePath){

        //1.创建源
        File dest = new File(filePath);

        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);

            //3.操作
            byte[] flush = new byte[10];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //4.释放资源
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
