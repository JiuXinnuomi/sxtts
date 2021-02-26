package sct_internetTcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录，多个客户端请求  ★★★★★
 * 1、指定端口,使用ServerSocket创建服务器
 * 2、阻塞式的连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */

public class LoginMultiServer {
    public static void main(String[] args) throws IOException {

        System.out.println("--------Server--------");

        //1、指定端口,使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(7777);
        boolean isRunning = true;

        //2、阻塞式的连接accept
        while (isRunning) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }

        server.close();

    }

    /*信息管道*/
    static class Channel implements Runnable{
        private Socket client;
        private DataInputStream dis;  //输入流
        private DataOutputStream dos;  //输出流


        public Channel(Socket client) {
            this.client = client;
            try {
                this.dis = new DataInputStream(client.getInputStream());  //输入
                this.dos = new DataOutputStream(client.getOutputStream());  //输出
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        /*接收数据*/
        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return datas;
        }

        /*发送数据*/
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*释放资源*/
        public void release(){
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {

            System.out.println("一个客户端建立了连接");

            //3、操作：输入输出流操作
            String uname = "";
            String upwd = "";
            //分析
            String[] dataArray = receive().split("&");
            for (String info : dataArray) {
                String[] userinfo = info.split("=");
                if (userinfo[0].equals("uname")) {
                    System.out.println("你的用户名为：" + userinfo[1]);
                    uname = userinfo[1];
                } else if (userinfo[0].equals("upwd")) {
                    System.out.println("你的密码为：" + userinfo[1]);
                    upwd = userinfo[1];
                }
            }

            //输出
            if (uname.equals("huangyu") && upwd.equals("19990203")){
                send("登录成功,欢迎回来");
            }else {
                send("用户名或密码错误,登录失败");
            }

            //4、释放资源
            release();

        }

    }

}
