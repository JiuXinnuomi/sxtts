package sct_thread;

/**
 * 测试实现模拟龟兔赛跑多线程
 * 资源争夺理解 ★★★★★
 */

public class TestRunnableRacer implements Runnable{
    private String winner;  //胜利者

    @Override
    public void run() {
        /*抢夺此处资源，最先调用完胜利*/
        for (int steps=1; steps<=100; steps++){
            //模拟休息
            if (Thread.currentThread().getName().equals("兔子") && (steps%10)==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "-----→" + steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag){
                break;
            }
        }

        /*放在此处会出现线程并发*/
//        System.out.println("winner: -----→" + winner);
    }

    /*判断是否获胜*/
    private boolean gameOver(int steps){
        if (winner != null){  //存在胜利者
            return true;
        }else {
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner: -----→" + winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestRunnableRacer tr = new TestRunnableRacer();

        new Thread(tr,"乌龟").start();
        new Thread(tr,"兔子").start();
    }

}
