package sct_test;

/**
 * 测试二维数组
 */

public class TestDimensionArray {

    public static void main(String[] args) {
        //动态初始化二维数组
        int[][] a = new int[3][];

        a[0] = new int[]{20,30};
        a[1] = new int[]{50,60};
        a[2] = new int[]{40,70};

        //静态初始化二维数组
        int[][] b = {
                {20,30,40},
                {2,3},
                {111,30,45}
        };
        System.out.println(b[2][1]);


    }
}
