package sct_thread;

/**
 * Lambda推导
 *
 */

public class TestLambda04 {

    public static void main(String[] args) {

        new Thread(()->{
            for (int i=0; i<10; i++){
                System.out.println(i);
            }
        }).start();

        new Thread(()-> System.out.println("一边崩溃")).start();

    }
}
