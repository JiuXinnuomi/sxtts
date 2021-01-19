package sct_io;

import java.io.File;
import java.io.FileReader;

/**
 * 测试文件路径写法
 */
public class TestPathDemo01 {

    public static void main(String[] args) {

        String path = "E:\\Idea_file\\sxtts\\src\\sct_io\\images\\nuomi.png";

        //建议写法 1. /
        path = "E:/Idea_file/sxtts/src/sct_io/images/nuomi.png";
        //2. 常量拼接
        path = "E:"+ File.separator+"Idea_file"+ File.separator+"sxtts"+ File.separator+"src"+ File.separator+"sct_io"+ File.separator+"images"+ File.separator+"nuomi.png";

        System.out.println(path);
    }
}
