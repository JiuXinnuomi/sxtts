package sct_exception;

import java.io.FileReader;
import java.io.IOException;

/**
 * 使用throws抛出声明异常
 */

public class TestCheckedExceptionw02 {

    public static void main(String[] args) {
        //调用者调用时出现异常，需要处理
        try {
            readMyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*将异常抛出给调用者*/
    public static void readMyFile() throws IOException {
        FileReader reader = null;
        reader = new FileReader("d:/bb.txt");
        System.out.println("step1");
        char c1 = (char) reader.read();
        System.out.println(c1);

        if (reader != null ){
            reader.close();
        }
    }
}
