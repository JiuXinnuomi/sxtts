package sct_algorithm;

import java.io.File;

/**
 * 测试递归打印目录结构
 */

public class TestPrintFileTree {

    public static void main(String[] args) {

        File f = new File("E:/Idea_file");
        printFile(f,0);

    }

    /*递归打印文件下的所有文件☆☆☆☆☆*/
    static void printFile (File file, int level){

        //输出层数
        for (int i=0; i<level; i++){
            System.out.print("-");
        }

        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();

            for (File temp: files){
                printFile(temp,level+1);
            }
        }
    }

}
