package sct_internetTcp;

/**
 * 请求响应式 服务器
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTwoWayServer {
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
        String uname = "";
        String upwd = "";

        //分析
        String[] dataArray = datas.split("&");
        for (String info: dataArray){
            String[] userinfo = info.split("=");
            if (userinfo[0].equals("uname")){
                System.out.println("你的用户名为：" + userinfo[1]);
                uname = userinfo[1];
            }else if (userinfo[0].equals("upwd")){
                System.out.println("你的密码为：" + userinfo[1]);
                upwd = userinfo[1];
            }
        }

        //输出
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        if (uname.equals("huangyu") && upwd.equals("19990203")){
            dos.writeUTF("欢迎回来");
        }else {
            dos.writeUTF("用户名或密码错误,登录失败");
        }



        //4、释放资源
        dis.close();
        client.close();

        server.close();

    }
}
