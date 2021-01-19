package sct_io;

import java.io.File;

/**
 * 使用面对对象方式统计文件夹大小
 */

public class TestDirCount {

    private long len;
    private String path;
    private File src;
    private int fileSize;
    private int dirSize;

    public TestDirCount(String path) {
        this.path = path;
        this.src = new File(path);
        countLength(this.src);

    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSize() {
        return dirSize;
    }

    /*统计文件夹大小*/
    private void countLength(File src){

        if (src != null && src.exists()){  //递归头
            if (src.isFile()){
                len += src.length();
                this.fileSize++;
            }else {
                dirSize++;
                for (File s: src.listFiles()){  //递归体，列出下级所有对象
                    countLength(s);
                }
            }
        }
    }


    public static void main(String[] args) {
        TestDirCount td = new TestDirCount("E:/Idea_file/sxtts/src");
        System.out.println(td.len);  //使用非静态变量需要new个对象
        System.out.println("文件数：" + td.getFileSize() + "\t" + "文件夹数：" + td.getDirSize());

    }

}
