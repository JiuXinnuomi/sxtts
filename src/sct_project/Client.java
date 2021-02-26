package sct_project;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室 客户端
 */

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("--------Client--------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String name = br.readLine();
        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",7777);

        //2、客户端发送消息
        new Thread(new Send(client,name)).start();

        //3、获取消息
        new Thread(new Receive(client)).start();
    }
}
