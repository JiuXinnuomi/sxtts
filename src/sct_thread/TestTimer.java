package sct_thread;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时执行某项任务
 */

public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
//        timer.schedule(new Mytask(), 100000);  //延迟时间执行一次
//        timer.schedule(new Mytask(), 5000, 5000);  //每隔period执行一次
        Calendar cal = new GregorianCalendar(2021,03,21,8,30,30);
        timer.schedule(new Mytask(),cal.getTime(),3000);  //指定时间开始执行，每隔period执行一次
    }
}

/*需要执行的任务类*/
class Mytask extends TimerTask{

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("你真的帅");
        }
        System.out.println("---------ending--------");
    }
}
