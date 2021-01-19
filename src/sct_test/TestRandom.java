package sct_test;

/**
 * 测试Random类随机数生成
 */

import java.util.Random;

public class TestRandom {

    public static void main(String[] args) {
        Random rand = new Random();
        //随机生成[0,1)之间的double类型数据
        System.out.println(rand.nextDouble());
        //随机生成int类型允许范围内的整型数据
        System.out.println(rand.nextInt());
        //同上
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextBoolean());
        //随机生成[0,10)之间的int类型数据
        System.out.println(rand.nextInt(10));
        //随机生成[20,30)之间的int类型数据
        System.out.println(20 + rand.nextInt(10));
        //随机生成[20,30)之间的int类型数据 2
        System.out.println(20 + (int)(rand.nextDouble()*10));
    }
}
