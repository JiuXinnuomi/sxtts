package sct_thread;

/**
 * 共享资源,并发(线程安全)
 * 实现12306多线程抢票模拟
 */

public class TestWeb12306 implements Runnable{
    //票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true){
            if (ticketNums<0){
                break;
            }
            //延迟会导致线程并发，需要保证线程安全 ★★★
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //区分具体是哪个线程
            System.out.println(Thread.currentThread().getName() + "------→" + ticketNums--);
        }
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());  //主线程运行
        /*一份资源，三个代理*/
        TestWeb12306 tw = new TestWeb12306();
        new Thread(tw,"码畜").start();
        new Thread(tw,"码农").start();
        new Thread(tw,"蚂蝗").start();

        /*此处为开辟了三份资源,三个代理*/
//        new Thread(new TestWeb12306(),"码畜").start();
//        new Thread(new TestWeb12306(),"码农").start();
//        new Thread(new TestWeb12306(),"蚂蝗").start();


    }

}
