package sct_thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 实现多线程下载图片  ☆☆☆
 */

public class TestWebDownloder {

    /*图片存放地址*/
    public void download(String url,String name) {

        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));


        } catch (MalformedURLException e) {
            System.out.println("不合法的URL路径！");
        } catch (IOException e) {
            System.out.println("图片下载失败！");
        }

    }

}
