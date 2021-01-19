package sct_test;

/**
 * 测试String类
 */

public class TestString {

    public static void main(String[] args) {

        String str = "abc";
        String str2 = new String("def");

        String str3 = "abc" + "def";
        String str4 = "18" + 19;
        System.out.println(str4);

        System.out.println("#################");
        //直接初始化字符串是缓存在常量池里面
        String str10 = "gaoqi";
        String str11 = "gaoqi";
        String str12 = new String("gaoqi");

        System.out.println(str10 == str11);
        //str10和str12不是相同的对象
        System.out.println(str10 == str12);
        //字符串比较时，使用equals
        System.out.println(str10.equals(str12));

    }
}
