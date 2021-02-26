package sct_internetTcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 1、指定端口,使用ServerSocket创建服务器
 * 2、阻塞式的连接accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 */

public class FileServer {

    public static void main(String[] args) throws IOException {

        System.out.println("--------Server--------");

        //1、指定端口,使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(7777);

        //2、阻塞式的连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");

        //3、操作：文件拷贝存储
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("src/sct_internetTcp/copy.png"));

        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = is.read(flush)) != -1){
            os.write(flush,0,len);
        }
        os.flush();

        //4、释放资源
        os.close();
        is.close();
        client.close();

        server.close();

    }
}
