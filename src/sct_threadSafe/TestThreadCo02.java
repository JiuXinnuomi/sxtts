package sct_threadSafe;
/**
 * 协作模型：生产者消费者实现方法二：信号灯法
 * 借助标志位
 *  ☆☆☆☆☆
 */

public class TestThreadCo02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/*生产者 演员*/
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            if (i%2==0){
                this.tv.play("奇葩说");
            }else {
                this.tv.play("太污了");
            }
        }

    }

}

/*消费者 观众*/
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            tv.watch();
        }
    }

}

/*相同资源*/
class Tv{

    String voice;
    //信号灯 作为标志管控线程
    boolean flag = true;

    //表演
    public synchronized void play(String voice){
        //演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("表演了:  " + voice);
        this.voice = voice;
        this.notifyAll();
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch(){
        //观众等待
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("看到了:  " + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}
