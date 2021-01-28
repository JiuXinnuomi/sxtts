package sct_thread;

/**
 * Join 合并线程，插队线程
 */

public class ThreadStateJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("lambda...." + i);
            }
        });
        t.start();

        for (int i=0; i<100; i++){
            System.out.println("main...." + i);
            if (i==20){
                t.join();  //插队  main主线程被阻塞
            }
        }

        /*父亲与儿子买烟*/
        Thread f = new Thread(new Father());
        f.start();
    }

}

class Father extends Thread{
    @Override
    public void run() {
        System.out.println("想抽烟，烟没了");
        System.out.println("给零钱，儿买烟");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();
            System.out.println("接过烟，赏零钱");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class  Son extends Thread{
    @Override
    public void run() {
        System.out.println("接过钱，去买烟");
        System.out.println("遇电玩，忘买烟");
        for (int i=0; i<10; i++){
            System.out.println("玩了---->"+ i +"秒");
        }
        System.out.println("买到烟，回家");
    }

}
