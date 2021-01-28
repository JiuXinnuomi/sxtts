package sct_thread;

/**
 * 观察所有线程状态
 * idea中自带一个监控线程
 */

public class ThreadStateAll {

    public static void main(String[] args) {

        Thread t = new Thread(()->{
            for (int i=0; i<5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".....");
            }
        });

        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);  //NEW

        t.start();
        state = t.getState();
        System.out.println(state);  //RUNNABLE

        /*监控线程状态1*/
        while (state != Thread.State.TERMINATED){ //TERMINATED
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);  //TIMED_WAITING
        }

        /*监控线程状态2*/
        while (true){
            int num = Thread.activeCount();
            System.out.println(num);
            if (num == 2){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //列出线程列表
        Thread.currentThread().getThreadGroup().list();

    }
}
