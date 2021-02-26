package sct_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 实现多次交流 发送端
 */

public class UdpTalkClient implements Runnable{
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIP;
    private int toPort;

    //1、使用DatagramSocket 指定端口 创建发送端
    public UdpTalkClient(int Port ,String toIP, int toPort) {
        try {
            this.client = new DatagramSocket(Port);
            this.toIP = toIP;
            this.toPort = toPort;
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("发送方启动中。。。");
        //2、准备数据，一定转成字节数组
        while (true) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();

                //3、封装成DatagramPacket包裹，需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toIP, this.toPort));

                //4、发送包裹send
                client.send(packet);
                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //5、释放资源
        client.close();
    }


}
