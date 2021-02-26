package sct_InternetUdp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫 下载数据
 *
 */

public class TestWebSpider {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("http://www.4399.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while ((msg=br.readLine()) != null){
            System.out.println(msg);
        }
        br.close();
        //分析数据
        //处理数据

    }
}
