package sct_test;

/**
 * 测试Math数学类常用方法
 */

public class TestMath {

    public static void main(String[] args) {
        /*取整相关操作*/
        System.out.println(Math.ceil(3.2)); //向上取整
        System.out.println(Math.floor(3.2));  //向下取整
        System.out.println(Math.round(3.2));  //四舍五入
        System.out.println(Math.round(3.8));
        /*绝对值、开方、a的b次幂等操作*/
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5,2));
        System.out.println(Math.pow(2,5));

        System.out.println(Math.random());
    }
}
