package sct_test;

/**
 * String类 编译细节
 */

public class TestString2 {
    public static void main(String[] args) {

        //编译器在编译时会将字符串直接拼接进行优化
        String str1 = "hello" + "java";
        String str2 = "hellojava";
        System.out.println(str1 == str2);

        String str3 = "hello";
        String str4 = "java";
        //编译不知道变量存储的是什么，没办法编译时优化
        String str5 = str3 + str4;
        System.out.println(str2 == str5);

    }
}
