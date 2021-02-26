package sct_InternetUdp;
/**
 * 文件发送端
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestImgUdpClient {

    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);

        //2、准备图片数据，转成字节数组
        byte[] datas = IoUtils.fileToByteArray("src/sct_io/images/nuomi.png");

        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));

        //4、发送包裹send
        client.send(packet);

        //5、释放资源
        client.close();

    }
}
