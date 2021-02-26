package sct_project;

/**
 * 学生端
 * 一个端口相当于一个进程，只能发，或者收
 */

public class TalkStudent {

    public static void main(String[] args) {

        new Thread(new UdpTalkClient(6666,"localhost",9999)).start(); //发送

        new Thread(new UdpTalkServer(7777,"老师说")).start();  //接收
    }
}
