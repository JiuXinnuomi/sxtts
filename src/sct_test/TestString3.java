package sct_test;

/**
 *  测试可变字符序列和不可变字符序列使用的陷阱
 *  ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
 */

public class TestString3 {

    public static void main(String[] args) {

        long num1 = Runtime.getRuntime().freeMemory(); //获取系统剩余内存空间
        long time1 = System.currentTimeMillis(); //获取系统的当前时间
        /*使用String进行字符拼接*/
        String str8 = "";
        for (int i = 0; i<100; i++){
            str8 = str8 + i;  //相当于产生了200个对象
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存： " + (num1-num2));
        System.out.println("String占用时间： " + (time2-time1));

        /*使用StringBuilder进行字符拼接*/
        StringBuilder sb1 = new StringBuilder("");
        for (int i = 0; i<100; i++){
            sb1.append(i);
        }
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        System.out.println("String占用内存： " + (num2-num3));
        System.out.println("String占用时间： " + (time3-time2));

    }
}
