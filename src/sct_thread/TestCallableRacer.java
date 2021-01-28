package sct_thread;

import java.util.concurrent.*;

/**
 * 用Callable实现龟兔赛跑
 * 逻辑过程 ★★★★★
 */

public class TestCallableRacer implements Callable<Integer> {
    private String winner;  //获胜者

    @Override
    public Integer call() throws Exception {

        /*需要最后输出结果时，将输出放置循环结束时*/
        for (int steps=1; steps<=100; steps++){
            //模拟休息
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && (steps%10)==0){
                    Thread.sleep(1);
                }

            System.out.println(Thread.currentThread().getName() + "-----→" + steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag){
                return steps;
            }

        }
        return null;
    }

    /*判断是否获胜*/
    private boolean gameOver(int steps){
        if (winner != null){  //存在胜利者
            return true;
        }else {
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner: -----→" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //启动线程
        TestCallableRacer tcr = new TestCallableRacer();

        /*启动多线程*/
        //1.创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //2.提交执行
        Future<Integer> result1 = ser.submit(tcr);
        Future<Integer> result2 = ser.submit(tcr);
        //3.获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + "----→" + r2);
        //4.关闭服务
        ser.shutdownNow();
    }

}
