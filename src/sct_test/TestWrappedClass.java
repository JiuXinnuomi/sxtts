package sct_test;

/**
 * 测试包装类
 */

public class TestWrappedClass {
    public static void main(String[] args) {
        //基本数据类型转成包装对象
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(3);

        //包装类对象转成基本数据类型
        int c = b.intValue();
        double d = b.doubleValue();

        //字符串转成包装类对象
        Integer e = new Integer("9999");
        Integer f = Integer.parseInt("9999");

        //包装类对象转成字符串
        String str = f.toString();

        //常见的常量
        System.out.println("int类型最大的整数：" +Integer.MAX_VALUE);
    }
}
