package sct_test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类
 */

public class TestFile {

    public static void main(String[] args) throws IOException {

//      File f = new File("d:/a.txt");
        //new 一个文件对象存放文件地址
        File f = new File("D:\\a.txt");  //反斜杠 ‘\’ 作为转义字符
        System.out.println(f);
        f.renameTo(new File("D:/bb.txt"));  //新增一个文件覆盖原有文件,原有对象不变

        System.out.println(System.getProperty("user.dir"));

        File f2 = new File("gg.text");
        f2.createNewFile();

        System.out.println("File是否存在：" + f2.exists());
        System.out.println("File是否是目录：" + f2.isDirectory());
        System.out.println("File是否是文件：" + f2.isFile());
        System.out.println("File最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("File的大小：" + f2.length());
        System.out.println("File的文件名：" + f2.getName());
        System.out.println("File是目录路径：" + f2.getPath());
        System.out.println("File是目录路径：" + f2.getAbsolutePath());

        f2.delete();
        File f3 = new File("d:/电影/华语/大陆");
//        boolean flag = f3.mkdir();
        boolean flag = f3.mkdirs();
        System.out.println(flag);

        f3.delete();

    }
}
