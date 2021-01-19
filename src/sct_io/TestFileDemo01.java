package sct_io;

import java.io.File;
import java.io.IOException;

/**
 * 测试构建File对象
 * 相对路径和绝对路径: 有无盘符
 */

public class TestFileDemo01 {

    public static void main(String[] args) throws IOException {

        String path = "E:/Idea_file/sxtts/src/sct_io/images/nuomi.png";

        //构建File对象1
        File src = new File(path);
        System.out.println(src.length());
        //构建File对象2
        src = new File("E:/Idea_file/sxtts/src/sct_io/images","nuomi.png");
        //构建File对象3
        src = new File(new File("E:/Idea_file/sxtts/src/sct_io/images"),"nuomi.png");
        System.out.println(src.length());

        //相对路径 ☆☆☆
        System.out.println(System.getProperty("user.dir"));
        src = new File("src/sct_io/images/nuomi.png");
        System.out.println(src.length());  //文件长度long

        /*基本信息*/
        System.out.println("名称："+src.getName());
        System.out.println("路径："+src.getPath());  //返回相对or绝对
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径："+src.getParent());
        System.out.println("父对象："+src.getParentFile().getName());

        /*文件状态*/
        System.out.println("是否存在："+src.exists());
        System.out.println("是否文件："+src.isFile());
        System.out.println("是否目录："+src.isDirectory());

        /*文件状态标准代码*/
        src = new File("xxx");
        if (null == src || !src.exists()){
            System.out.println("文件不存在");
        }else {
            if (src.isFile()){
                System.out.println("文件操作");
            }else {
                System.out.println("文件夹操作");
            }
        }

        /*其他信息*/
        File src2 = new File("E:/Idea_file/sxtts/src/sct_io/images/io.txt");
        boolean flag = src2.createNewFile();  //只创建文件
        //补充：con，com3...操作系统设备名，不能正确创建文件
        System.out.println(flag);
        src2.delete();
        System.out.println(flag);


    }
}
