package sct_project;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 用多线程封装：发送端
 * 1.发送消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写run方法
 */

public class Send implements Runnable{
    BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;

    public Send(Socket client,String name) {
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        isRunning = true;
        this.name = name;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            Send(name);
        } catch (IOException e) {
            //释放资源
            System.out.println("===1===");
            this.release();
        }
    }

    /*从控制台获取信息*/
    public String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /*发送信息*/
    public void Send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("===3===");
            release();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getStrFromConsole();
            if (!msg.equals("")){
                Send(msg);
            }
        }
    }

    /*释放资源*/
    public void release(){
        this.isRunning = false;
        Utils.close(dos,client);
    }

}
