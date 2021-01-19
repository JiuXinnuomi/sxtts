package sct_exception;

/**
 * 测试运行时异常处理
 */

public class TestRuntimeException {

    public static void main(String[] args) {

        /*ArithmeticException异常*/
        int a = 0;
        int b = 1;
        if (a != 0){
            System.out.println(b/a);
        }

        /*NullPointerException异常*/
        String str = null;
        if (str != null){
            System.out.println(str.length());
        }

        /*ClassCastException异常*/
        Animal d = new Dog();
        if (d instanceof Cat){
            Cat c = (Cat)d;
        }

        /*ArrayIndexOutOfBoundsException异常*/
        int[] arr = new int[5];
        int a2 = 5;
        if (a2 < arr.length){
            System.out.println(arr[a]);
        }

        /*NumberFormatException异常*/
        String str2 = "12345abcd";
        System.out.println(Integer.parseInt(str2)); //用正则处理

    }
}

class Animal{

}
class Dog extends Animal{

}
class Cat extends Animal{

}
