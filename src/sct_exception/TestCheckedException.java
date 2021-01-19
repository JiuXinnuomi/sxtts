package sct_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用try-catch-finally捕获异常
 * 测试编译器异常（已检查异常）
 */

public class TestCheckedException {

    public static void main(String[] args) {

        /*捕获异常的一套完整规范☆☆☆☆☆*/
        FileReader reader = null;
        try {
            reader = new FileReader("d:/bb.txt");
            System.out.println("step1");
            char c1 = (char)reader.read();
            System.out.println(c1);

        //子类异常在父类异常前面
        } catch (FileNotFoundException e) {
            System.out.println("step2");
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("step3");
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
