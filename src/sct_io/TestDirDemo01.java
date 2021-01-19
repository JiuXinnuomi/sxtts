package sct_io;

import java.io.File;

/**
 * 测试创建目录
 * 列出下一级
 */

public class TestDirDemo01 {

    public static void main(String[] args) {
        File dir = new File("E:/Idea_file/sxtts/src/sct_io/images/dir/test");

        boolean flag = dir.mkdir();  //确保上级目录存在，不存在则创建失败
        System.out.println(flag);
        flag = dir.mkdirs();
        System.out.println(flag);

        //列出下级名称
        File dir2 = new File("E:/Idea_file/sxtts/src/sct_io/images");
        String[] subName = dir2.list();
        for (String s: subName){
            System.out.println(s);
        }

        //列出下级对象
        File[] subFiles = dir2.listFiles();
        for (File e: subFiles){
            System.out.println(e.getAbsolutePath());
        }

        //列出本地所有盘符
        File[] roots = dir2.listRoots();
        for (File r: roots){
            System.out.println(r.getAbsolutePath());
        }

        File src = new File("E:/Idea_file/sxtts/src");
//        printName(src,0);
        count(src);
        System.out.println(len);
    }

    /*打印子孙级目录和文件名称  ☆☆☆☆*/
    public static void printName(File src, int deep){

        for (int i=0; i<deep; i++){
            System.out.print("-");
        }

        System.out.println(src.getName());
        if (src == null || !src.exists()){  //递归头
            return ;
        }else if (src.isDirectory()){  //递归体
            for (File s: src.listFiles()){
                printName(s, deep+1);
            }
        }
    }

    private static long len = 0;
    /*统计文件夹的大小*/
    public static void count(File src){

        if (src != null && src.exists()){  //递归头
            if (src.isFile()){
                len += src.length();
            }else {
                for (File s: src.listFiles()){  //递归体
                    count(s);
                }
            }
        }
    }


}
