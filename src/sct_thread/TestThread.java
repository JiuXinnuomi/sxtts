package sct_thread;

/**
 * 测试创建线程一，Thread
 * 1.继承Thread，重写run
 * 2.新建子类对象，调用启动
 */

public class TestThread extends Thread{

    /*线程入口点*/
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("一遍听歌");
        }
    }

    public static void main(String[] args) {
        //调用启动
        TestThread tt = new TestThread();
        tt.start();  //开启一条新的进程，不保证立即运行，由CPU调用。线程启动时机也重要
        tt.run();  //执行run(),仅是普通方法调用

        for (int i=0; i<20; i++){
            System.out.println("一边coding");
        }

    }
}
