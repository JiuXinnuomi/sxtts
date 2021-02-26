package sct_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室 服务端
 * 封装 使用多线程 实现多个客户 可以正常收发信息
 * 目标：加入容器实现群聊
 */

public class Chat {
    static private CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();

    public static void main(String[] args) throws IOException {

        System.out.println("--------Server--------");

        //1、指定端口,使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(7777);

        //2、阻塞式的连接accept
        while (true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);  //管理所有的成员
            new Thread(c).start();
        }

    }

    /*一个客户代表一个Channel*/
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        /*初始化服务器
        * 在每个服务器连接时初始化添加介绍信息
        * 可以操作连接成功时的信息
        * */
        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                this.name = receive();
                //欢迎加入群里
                this.send("欢迎你的到来");
                sendOthers(this.name + "来到了聊天室",true);
            } catch (IOException e) {
                System.out.println("-------1-------");
                release();
            }
        }

        /*接收信息*/
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("-------2-------");
                release();
            }

            return msg;
        }

        /*发送信息*/
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("-------3-------");
                release();
            }
        }

        /*群聊，发送给其他人
        * 私聊：约定数据格式：@xxx：msg
        * */
        private void sendOthers(String msg, boolean isSys){
            //私聊
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate){
                //获取目标和数据
                int idx = msg.indexOf(":");
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for (Channel other:all){
                    if (other.name.equals(targetName)){  //锁定目标
                        other.send(this.name + " 悄悄对你说：" + msg);
                        break;
                    }
                }

            }else {
                //群聊
                for (Channel other : all) {
                    if (other == this) {
                        continue;
                    }
                    if (!isSys) {
                        other.send(this.name + " 对所有人说：" + msg);  //群聊消息
                    } else {
                        other.send(msg);  //系统消息
                    }
                }
            }
        }

        /*释放资源*/
        private void release(){
            this.isRunning = false;
            Utils.close(dis,dos,client);
            //退出
            sendOthers( this.name+ "离开了聊天室",true);
            all.remove(this);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if (!msg.equals("")){
                    sendOthers(msg,false);
                }

            }
        }


    }
}
