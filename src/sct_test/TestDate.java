package sct_test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试Date类的常见用法
 */

public class TestDate {

    public static void main(String[] args) throws ParseException {

        //不传参数等同于获取当前时间
        Date d = new Date();   //System.currentTimeMillis()
        System.out.println(d);
        System.out.println(d.getTime());

        TestDateFormat();

    }
/*测试时间对象和字符串之间的互相转换,DateFormat抽象类和SimpleDateFormat*/
    public static void TestDateFormat() throws ParseException {

        //可以在API文档查时间格式
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

/* 将 */
        //将时间对象按照“时间格式”转换成相应的字符串,时间以毫秒为单位
        String str = df.format(new Date(40000000));
        System.out.println(str);

        //将字符串按照“时间格式”转换成相应的时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = df2.parse("1983-05-10 10:45:59");
        System.out.println(date);

        //测试其它的格式字符
        DateFormat df3 = new SimpleDateFormat("D");
        String str3 = df3.format(new Date());
        System.out.println(str3);

    }
}
