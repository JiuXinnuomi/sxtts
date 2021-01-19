package sct_test;

/**
 * 测试自动装箱，自动拆箱
 */

public class TestAutoBox {

    public static void main(String[] args) {
        Integer a = 234; //自动装箱。Integer a = Integer.valueOf(234)

        int b = a;  //自动拆箱。编译器会修改成: int b = a.intValue()

        Integer c = null;
        if (c != null){
            int d = c; //自动拆箱: 调用了c.intValue()
        }

        //已经缓存[-128,127]之间的数字对象,实际就是系统初始时创建了一个缓存数组
        Integer in1 = 1234;
        Integer in2 = 1234;
        System.out.println(in1 == in2);
        System.out.println(in1.equals(in2));


    }
}
