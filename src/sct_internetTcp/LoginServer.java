package sct_internetTcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录，服务器处理
 * 1、指定端口,使用ServerSocket创建服务器
 * 2、阻塞式的连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */

public class LoginServer {

    public static void main(String[] args) throws IOException {

        System.out.println("--------Server--------");

        //1、指定端口,使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(7777);

        //2、阻塞式的连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");

        //3、操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        //分析
        String[] dataArray = datas.split("&");
        for (String info: dataArray){
            String[] userinfo = info.split("=");
            if (userinfo[0].equals("uname")){
                System.out.println("你的用户名为：" + userinfo[1]);
            }else if (userinfo[0].equals("upwd")){
                System.out.println("你的密码为：" + userinfo[1]);
            }
        }

        //4、释放资源
        dis.close();
        client.close();

        server.close();

    }
}
