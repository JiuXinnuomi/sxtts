package sct_project;

/**
 * 老师端
 */

public class TalkTeacher {

    public static void main(String[] args) {

        new Thread(new UdpTalkServer(9999,"学生说")).start();  //接收

        new Thread(new UdpTalkClient(5555,"localhost",7777)).start(); //发送
    }
}
