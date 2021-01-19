package sct_test;

/**
 * 测试匿名内部类
 */

public class TestAnonoymousInnerClass {

    public static void test01(AA a){
        System.out.println("$$$$$$$$$$$$");
        a.aa();
    }

    public static void main(String[] args) {

        /*匿名内部类实例化接口类，仅使用一次*/
        TestAnonoymousInnerClass.test01(new AA() {
            @Override
            public void aa() {
                System.out.println(" 创建实例成功");
            }
        });

    }

}

interface AA{
    void aa();
}


