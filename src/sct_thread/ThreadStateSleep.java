package sct_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试线程阻塞状态
 * sleep模拟网络延迟，放大了问题发生的可能性
 */

public class ThreadStateSleep {

    /*主线程休眠*/
    public static void main(String[] args) throws InterruptedException {
        //倒计时
        Date endtime = new Date(System.currentTimeMillis()+1000*10);
        long end = endtime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endtime));
            Thread.sleep(1000);
            endtime = new Date(endtime.getTime()-1000);
            if (end-10000 > endtime.getTime()){
                break;
            }
        }
    }


}
