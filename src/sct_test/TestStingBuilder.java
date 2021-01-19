package sct_test;

/**
 * 测试StringBuilder、StringBuffer
 * 方法用法
 */

public class TestStingBuilder {

    public static void main(String[] args) {

        //StringBuilder是可变字符串，线程不安全,效率高(一般使用它)、StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("abcdefg");

        //打印地址
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2,'M'); //更改指定下标字符
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

/*--------------------------分割线----------------------*/

        TestStingBuilderMethod();
    }

    public static void TestStingBuilderMethod(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<26; i++){
            char temp = (char)('a'+i);
            sb.append(temp); //在字符序列后追加字符
        }
        sb.reverse(); //倒序
        sb.insert(0,'我');
        sb.insert(0,'我').insert(6,'爱').insert(10,'它'); //链式调用，该方法调用了return this
        sb.delete(20,23);  //同样也可以链式调用
        System.out.println(sb);

    }
}
