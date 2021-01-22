package sct_io;

import java.io.*;

/**
 * 测试数据流
 * 1、先写出后读取
 * 2、读取顺序和写出顺序保持一致
 */

public class TestDataIo {

    public static void main(String[] args) throws IOException {
        //将不同的数据类型分别写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));

        //操作数据类型
        dos.writeUTF("编码辛酸泪");
        dos.writeBoolean(false);
        dos.writeInt(18);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);

        //依次读取,顺序必须保持一致
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);

    }
}
