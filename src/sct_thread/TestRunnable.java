package sct_thread;

/**
 * 创建线程方式二 Runnable
 * 启动：创建实现类对象 + Thread对象 + start
 *
 */

public class TestRunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("一遍听歌");
        }

    }

    public static void main(String[] args) {

        //Runnable调用启动
        TestRunnable tr = new TestRunnable();
        Thread t = new Thread(tr);
        t.start();
        //匿名用法,对象只使用一次
//        new Thread(new TestRunnable()).start();

        for (int i=0; i<20; i++){
            System.out.println("一边coding");
        }
    }

}
