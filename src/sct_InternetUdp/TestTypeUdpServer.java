package sct_InternetUdp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型 接收端 ★★★
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive
 * 4、分析数据 将字节数组还原为对应的类型
 * 5、释放资源
 */

public class TestTypeUdpServer {

    public static void main(String[] args) throws Exception {

        System.out.println("接收端启动中。。。");
        //1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(9999);

        //2、准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        //3、阻塞式接收包裹receive
        server.receive(packet);

        //4、分析数据 byte[] getData()，getLength()
        byte[] datas = packet.getData();
        int len = packet.getLength();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(age + "-->" + flag);

        //5、释放资源
        server.close();
    }
}
