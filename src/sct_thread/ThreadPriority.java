package sct_thread;

/**
 * 测试线程优先级
 */

public class ThreadPriority {

    public static void main(String[] args) {
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp,"线程一");
        Thread t2 = new Thread(mp,"线程二");
        Thread t3 = new Thread(mp,"线程三");
        Thread t4 = new Thread(mp,"线程四");
        Thread t5 = new Thread(mp,"线程五");

        //设置优先级,代表被调用的概率
        t1.setPriority(1);
        t2.setPriority(3);
        t4.setPriority(7);
        t5.setPriority(9);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.currentThread().getThreadGroup().list();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----->" + Thread.currentThread().getPriority());
    }

}
