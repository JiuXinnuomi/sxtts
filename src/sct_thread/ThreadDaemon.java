package sct_thread;

/**
 * 测试守护线程
 * 守护线程：为用户线程服务，jvm停止不用等待守护线程执行完毕
 * 用户线程：jvm等待用户线程执行完毕才会停止
 */

public class ThreadDaemon {

    public static void main(String[] args) {
        God god = new God();
        Me me = new Me();
        Thread t = new Thread(god);
        t.setDaemon(true);  //将用户线程调整为守护
        t.start();

        new Thread(me).start();
    }
}

class Me extends Thread{

    @Override
    public void run() {
        for (int i=0; i<365; i++){
            System.out.println("happy life");
        }
        System.out.println("ooooooo");
    }
}

class God extends Thread{

    @Override
    public void run() {
        for (;true;){
            System.out.println("God bless you...");
        }
    }
}