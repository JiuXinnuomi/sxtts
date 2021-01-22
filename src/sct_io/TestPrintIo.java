package sct_io;

import java.io.*;

/**
 * 测试打印流
 */

public class TestPrintIo {
    public static void main(String[] args) throws FileNotFoundException {

        /*PrintStream*/
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/sct_io/images/abc2.txt")),true);
        ps.println("打印流");
        ps.println(true);
        ps.close();
//        ps.flush();

        //重定向输出端
        System.setOut(ps);
        System.out.println("change");
        //重定向回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("i am backed");

        /*PrintWriter用法与PrintStream相同*/
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("src/sct_io/images/abc2.txt")),true);
        pw.println("另一打印流");
        pw.println(true);
        pw.close();

    }


}
