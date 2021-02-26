package sct_project;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试12306取票，锁定方法区
 * 代理线程的使用
 * ???? available上锁成功，打印顺序出错
 */

public class TestHappy12306 {

    public static void main(String[] args) {
        Web12306 c = new Web12306(10,"sct");
        new Passenger(c,"糯米1",2).start();
        new Passenger(c,"糯米2",3).start();
        new Passenger(c,"糯米3",2).start();
        new Passenger(c,"糯米4",1).start();

    }
}

/*顾客*/
class Passenger extends Thread{
    int seats;

    public Passenger(Runnable target,String name,int seats){
        super(target,name);  //☆☆☆
        this.seats = seats;
    }

}

/*火车票网*/
class Web12306 implements Runnable{
    int available;  //可用的位置
    String name;  //名称

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger)Thread.currentThread();  //☆☆☆
        boolean flag = this.bookTickes(p.seats);

        if (flag) {
            System.out.println("出票成功" + Thread.currentThread().getName() + "->票数为" + p.seats);
        } else {
            System.out.println("出票失败" + Thread.currentThread().getName() + "->票数不够");
        }
    }

    /*购票 方法区上锁成功*/
    public synchronized boolean bookTickes(int seats){
        System.out.println("可用位置为：" + available);
        if (seats > available){
            return false;
        }
        available -= seats;
        return true;
    }

}

