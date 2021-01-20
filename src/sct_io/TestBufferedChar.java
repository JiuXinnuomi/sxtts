package sct_io;

import java.io.*;

/**
 * 测试输入输出字符缓冲流
 */

public class TestBufferedChar {

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        //1.创建源
        File src = new File("src/sct_io/images/abc2.txt");
        File dest = new File("src/sct_io/images/abc.txt");
        copyChar(src,dest);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

    }

    /*加入字符缓冲流提高运行效率，同时优化释放资源*/
    public static void copyChar(File srcPath, File destPath){

        //2.选择流
        try(
                BufferedReader br = new BufferedReader(new FileReader(srcPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))
            ) {

            //3.操作(逐行读取)
            String line = null;
            while ((line = br.readLine()) != null){
                bw.write(line);  //逐行写出
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
