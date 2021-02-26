package sct_threadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：操作容器
 * ！！！List自带并发锁 CopyOnWriteArrayList(锁可携带) ☆
 */

public class TestSynList {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<500; i++){
            new Thread(()->{
                //同步模块
                synchronized(list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(list.size());
    }

}
