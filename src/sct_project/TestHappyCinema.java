package sct_project;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现快乐影院 ★★★★★
 * 完成线程安全
 */

public class TestHappyCinema {

    public static void main(String[] args) {
        //可用的位置
        List<Integer> available = new ArrayList<Integer>();
        for (int i=1; i<8; i++){
            available.add(i);
        }
        //顾客需要的位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(3);
        seats2.add(4);
        seats2.add(7);
        seats2.add(6);

        SctCinema cinema = new SctCinema(available,"快乐影院");
        new Thread(new HappyCustomer(cinema,seats1),"糯米").start();
        new Thread(new HappyCustomer(cinema,seats2),"团子").start();
    }

}

/*顾客*/
class HappyCustomer implements Runnable{
    SctCinema cinema;
    List<Integer> seats;

    public HappyCustomer(SctCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        //加入线程同步, run里上锁会锁住所有线程内容
        synchronized (cinema) {
            boolean flag = cinema.bookTickes(seats);
            if (flag) {
                System.out.println("出票成功" + Thread.currentThread().getName() + "->位置为" + seats);
            } else {
                System.out.println("出票失败" + Thread.currentThread().getName() + "->位置不够");
            }
        }
    }

}

/*影院*/
class SctCinema{
    List<Integer> available;
    String name;

    public SctCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    /*购票 操作容器☆☆☆☆*/
    public boolean bookTickes(List<Integer> seats){
        System.out.println("欢迎光临" + this.name + "可用位置为：" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);
        //相减
        copy.removeAll(seats);
        //判断大小
        if (available.size()-copy.size() != seats.size()){
            return false;
        }
        //成功
        available = copy;
        return true;
    }

}
