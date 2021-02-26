package sct_InternetUdp;

/**
 * 文件存储端
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestImgUdpServer {

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
        IoUtils.byteArrayToFile(datas,"src/sct_internet/copy.png");

        //5、释放资源
        server.close();

    }
}
