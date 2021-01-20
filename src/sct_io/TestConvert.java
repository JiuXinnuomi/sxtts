package sct_io;

import java.io.*;
import java.net.URL;

/**
 * 测试转换流 ☆☆☆☆☆
 * InputStreamReader，OutputStreamReader
 * 1. 以字符流的形式操作字节流
 * 2. 指定字符集
 */

public class TestConvert {

    public static void main(String[] args) {

//        convertSystem();
        convertInternet();

    }

    /*操作System.in和System.out*/
    public static void convertSystem(){

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            //循环获取键盘的输入(exit退出)，输出此内容
            String msg = "";
            while (!msg.equals("exit")){
                msg = reader.readLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();  //强制刷新，让缓冲区的内容提前输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*操作网络流,下载百度源码 ☆☆☆☆☆*/
    public static void convertInternet(){

        try(
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        new URL("http://www.baidu.com").openStream(),"UTF-8"));  //指定字符集
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("src/sct_io/images/baidu.html"),"GBK"))
            ) {
            //3.操作(读取)
            String msg;
            while ((msg = reader.readLine()) != null){
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();

        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }


}
