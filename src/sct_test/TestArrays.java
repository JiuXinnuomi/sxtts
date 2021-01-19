package sct_test;


import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 */

public class TestArrays {
    public static void main(String[] args) {

        int[] a = {100,20,30,5,25,87};

        System.out.println(Arrays.toString(a)); //打印数组内容
        Arrays.sort(a); //从小到大排序
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,30)); //二分法查找元素

    }
}
