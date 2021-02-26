package sct_InternetUdp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 引用类型 接收端
 */

public class TestObjUdpServer {

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
        //依次读取，顺序必须保持一致
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();

        //对象的还原
        if (str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date){
            Date dateObj = (Date) date;
            System.out.println(dateObj);
        }
        if (employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName());
        }
        ois.close();

        //5、释放资源
        server.close();

    }
}
