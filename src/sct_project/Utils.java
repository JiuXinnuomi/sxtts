package sct_project;

import java.io.Closeable;
import java.io.IOException;

/**
 * 在线聊天室的工具类
 */

public class Utils {

    /*释放资源
    * 继承了Closeable类的都可以使用
    * */
    public static void close(Closeable... targets){
        for (Closeable target:targets){
            try{
                if (null != target){
                    target.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
