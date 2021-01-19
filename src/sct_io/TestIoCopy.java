package sct_io;

import java.io.*;

/**
 * 测试IO流文件拷贝 ★★★
 */

public class TestIoCopy {

    public static void main(String[] args) {

        //1.创建源
        File abc = new File("src/sct_io/images/abc.txt");
        File dest = new File("src/sct_io/images/dest.txt");
//        fileCopy(abc,dest);

        try {
            Reader reader = new FileReader(abc);
            Writer writer = new FileWriter(dest);
            fileCopy02(reader,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*IO字节流文件拷贝 ★★★*/
    public static void fileCopy(File srcPath, File destPath){

        //2.选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(srcPath);
            os = new FileOutputStream(destPath);

            //3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4.释放资源，分别关闭,先打开的后关闭
            try {
                if (os != null) {
                    os.close();
                }
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*文件夹的拷贝*/
    public static void folderCopy(){

    }

    /*IO字符流文件拷贝*/
    public static void fileCopy02(Reader reader,Writer writer){

        //3.操作
        try(reader;writer) {
            char[] flush = new char[20];
            int len = -1;
            while ((len = reader.read(flush)) != -1){
                writer.write(flush,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
