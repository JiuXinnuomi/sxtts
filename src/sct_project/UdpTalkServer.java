package sct_project;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 实现多次交流 接收端
 */

public class UdpTalkServer implements Runnable{
    private DatagramSocket server;
    private String from;

    //1、使用DatagramSocket 指定端口 创建接收端
    public UdpTalkServer(int Port, String from) {
        this.from = from;
        try {
            this.server = new DatagramSocket(Port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("接收方启动中。。。");
        //2、准备容器 封装成DatagramPacket包裹
        while (true) {
            byte[] container = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);

            //3、阻塞式接收包裹receive
            try {
                server.receive(packet);

                //4、分析数据 byte[] getData()，getLength()
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String data = new String(datas, 0, len);
                System.out.println(from + ":" + data);

                if (data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //5、释放资源
        server.close();
    }
}
