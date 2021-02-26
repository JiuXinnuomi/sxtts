package sct_InternetUdp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 引用类型 发送端
 */

public class TestObjUdpClient {

    public static void main(String[] args) throws Exception {

        System.out.println("发送方启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);

        //2、准备引用类型，一定转成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));

        //操作数据类型
        oos.writeObject("谁知其中味");
        oos.writeObject(new Date());
        Employee emp = new Employee("马云",400);
        oos.writeObject(emp);
        oos.flush();
        oos.close();

        byte[] datas = baos.toByteArray();

        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));

        //4、发送包裹send
        client.send(packet);

        //5、释放资源
        client.close();

    }
}
