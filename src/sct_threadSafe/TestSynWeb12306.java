package sct_threadSafe;

import sct_thread.TestWeb12306;

/**
 * 12306抢票 线程安全版 ★★★
 * 锁主太大，效率底下
 * 范围太小，可能锁不住
 */

public class TestSynWeb12306 {

    public static void main(String[] args) {

        /*一份资源，三个代理*/
        SynWeb12306 tw = new SynWeb12306();
        new Thread(tw,"码畜").start();
        new Thread(tw,"码农").start();
        new Thread(tw,"蚂蝗").start();

    }
}

class SynWeb12306 implements Runnable{

    //票数
    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
//            test01();
//            test02();
            test03();
        }
    }

    /*线程安全 方法区*/
    public synchronized void test01(){
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //延迟会导致线程并发，需要保证线程安全 ★★★
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "------→" + ticketNums--);
    }

    /*线程安全 同步块*/
    public void test02(){
        synchronized (this){  //此处上锁的对象应当不能改变，否则改变后将不是相同对象，则无法锁住
            if (ticketNums<=0){
                flag = false;
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "------→" + ticketNums--);
        }
    }

    /*线程安全 尽可能锁主合理的范围(不是指代码，指的是数据的完整性)*/
    /*double checking  考虑临界值情况★★★*/
    public void test03(){

        if (ticketNums<=0){  //考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNums <= 0) {  //考虑最后的1张票
                flag = false;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "------→" + ticketNums--);
        }
    }



}
