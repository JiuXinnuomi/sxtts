package sct_threadSafe;

/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 一般发生于同一个代码块中持有多个对象的锁
 */

public class TestDeadLock {
    public static void main(String[] args) {
        Markup g1 = new Markup(1,"雨佳1");
        Markup g2 = new Markup(0,"雨佳2");
        g1.start();
        g2.start();

    }
}

/*口红*/
class Lipstick{
    //只是新建一个对象，为上锁提供对象
}

/*镜子*/
class Mirror{

}

/*化妆*/
class Markup extends Thread{
    //选择
    int choice;
    //名字
    String girl;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    public Markup(int choice, String girl){
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        super.run();
        markup();
    }

    /*相互持有对方的对象锁-->可能会造成死锁*/
    private void markup(){
        if (choice==0){
            synchronized (lipstick){  //获得口红锁
                System.out.println(this.girl + "涂口红");
                //一秒钟后想拥有镜子
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //锁种套锁，会产生死锁。上锁程序必须执行完才会释放
                /*  synchronized (mirror){  //获得镜子
                    System.out.println(this.girl + "照镜子");
                }  */
            }
            synchronized (mirror){  //获得镜子
                System.out.println(this.girl + "照镜子");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girl + "照镜子");
                //一秒钟后想拥有镜子
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /* synchronized (lipstick){
                    System.out.println(this.girl + "涂口红");
                } */
            }
            synchronized (lipstick){
                System.out.println(this.girl + "涂口红");
            }
        }
    }


}