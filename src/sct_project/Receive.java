package sct_project;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装：接收端
 * 1.接收消息
 * 2.释放资源
 * 3.重写run方法
 */

public class Receive implements Runnable{
    DataInputStream dis;
    private Socket client;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        isRunning = true;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            //释放资源
            System.out.println("===2===");
            this.release();
        }
    }

    /*接收信息*/
    public String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("===4===");
            this.release();
        }

        return msg;
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if (!msg.equals("")){
                System.out.println(msg);
            }
        }
    }

    /*释放资源*/
    public void release(){
        this.isRunning = false;
        Utils.close(dis,client);
    }
}
