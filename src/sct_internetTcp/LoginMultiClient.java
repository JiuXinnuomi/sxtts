package sct_internetTcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求 ★★★★★
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 */

public class LoginMultiClient {

    public static void main(String[] args) throws IOException {

        System.out.println("--------Client--------");

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",7777);

        //2、操作：输入输出流操作
        new Send(client).send();
        //接收
        new Receive(client).receive();
        //3、释放资源
        client.close();

    }

    /*发送*/
    static class Send{

        private Socket client;
        private DataOutputStream dos;  //输出流
        BufferedReader console;
        String msg;

        public Send(Socket client) {

            console = new BufferedReader(new InputStreamReader(System.in));
            this.msg = init();
            this.client = client;
            try {
                this.dos = new DataOutputStream(client.getOutputStream());  //输出
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String init(){

            String uname = null;
            String upwd = null;
            try {
                System.out.println("请输入用户名:");
                uname = console.readLine();
                System.out.println("请输入密码:");
                upwd = console.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "uname=" + uname + "&" + "upwd=" + upwd;
        }

    }

    /*接收*/
    static class Receive{

        private Socket client;
        private DataInputStream dis;  //输入流

        public Receive(Socket client) {
            this.client = client;
            try {
                this.dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive(){
            String result;
            try {
                result = dis.readUTF();
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
