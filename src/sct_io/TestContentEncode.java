package sct_io;

import java.io.UnsupportedEncodingException;

/**
 * 测试：字符串---→字节
 */

public class TestContentEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /*编码：字符串---→字节*/
        String msg = "性命a";  //默认使用工程字符集
        byte[] datas = msg.getBytes();  //字节数组
        System.out.println(datas.length);

//        datas = msg.getBytes("UTF-16LE");  //使用其他字符集
//        System.out.println(datas.length);

        /*解码：字节---→字符串*/
        msg = new String(datas,0,datas.length,"utf8");
        System.out.println(msg);
    }
}
