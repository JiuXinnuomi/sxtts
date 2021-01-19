package sct_test;

/**
 * 测试String类字符串常用方法
 */

public class TestStringMethod {

    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3)); //提取下标为3的字符
        System.out.println(s2.length()); //字符串长度

        System.out.println(s1.equals(s2)); //比较2个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2)); //比较2个字符串，忽略大小写

        System.out.println(s1.indexOf("Java")); //字符串s1是否包含Java

        String s = s1.replace(" ","&"); //将s1中的空格替换为&，s1本身不发生改变
        System.out.println("result is:" + s);

        /*-------------------------分割线--------------------------*/

        String u = "";
        String u1 = "How are you?";

        System.out.println(s1.startsWith("How")); //是否以How开头
        System.out.println(s1.endsWith("you")); //是否以you结尾

        u = u1.substring(4);  //提取字符串，从下标为4开始到字符串结尾为止
        System.out.println(u);
        u = u1.substring(4,7); //提取字符串，下标[4,7)
        System.out.println(u);

        s = s1.toLowerCase(); //转换成小写
        s = s1.toUpperCase(); //转换成大写

        String u2 = " How old are you ";
        u = u2.trim(); //去除首尾字符串的空格。
        System.out.println(u);


    }
}
