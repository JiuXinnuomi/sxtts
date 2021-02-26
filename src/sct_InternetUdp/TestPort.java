package sct_InternetUdp;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1、区分软件
 * 2、2个字节0~65535 UDP TCP
 * 3、同一个协议端口不能冲突
 * 4、定义的端口越大越好
 * InetSocketAddress: 主要作用是封装端口
 */

public class TestPort {

    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress2.getHostName());
        System.out.println(socketAddress2.getPort());

    }
}
