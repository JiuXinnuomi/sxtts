package sct_threadSafe;

/**
 * 协作模型：生产者消费者实现方法一：管程法
 * 借助一个缓冲区
 *  ☆☆☆☆☆
 */

public class TestThreadCo01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();

    }

}

/*生产者*/
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    //生产
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("生产-->" + i + "个馒头");
            container.push(new Steamedbun(i));
        }
    }

}

/*消费者*/
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    //消费
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("消费-->" + container.pop().id + "个馒头");
        }
    }

}

/*缓冲区*/
class SynContainer{
    Steamedbun[] buns = new Steamedbun[10];  //存储容器
    int count = 0;  //计数器

    //存储
    public synchronized void push(Steamedbun bun){
        //生产判定
        if (count==buns.length){
            try {
                this.wait();  //此时线程阻塞，由消费者通知生产
            } catch (InterruptedException e) {
            }
        }

        buns[count] = bun;
        count++;
        this.notifyAll();  //存在资源了，可以唤醒对方消费
    }

    //获取 消费
    public synchronized Steamedbun pop(){
        //消费判定
        if (count==0){
            try {
                this.wait();  //此时线程阻塞，由生产者通知消费解除阻塞
            } catch (InterruptedException e) {
            }
        }

        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();  //存在空间了，可以唤醒对方生产
        return bun;
    }

}

/*数据*/
class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}