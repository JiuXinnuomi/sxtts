package sct_thread;

/**
 *  测试Lambda表达式简化线程(仅用一次)使用
 */

public class TestLambdaThread {

    /*静态内部类*/
    static class Test implements Runnable{
        @Override
        public void run() {
            for (int i=0; i<10; i++){
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new Test()).start();
        /*局部内部类*/
        class Test2 implements Runnable{
            @Override
            public void run() {
                for (int i=0; i<10; i++){
                    System.out.println("一边听歌");
                }
            }
        }
        new Thread(new Test2()).start();

        /*匿名内部类，必须借助接口或者父类*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("一边听歌");
            }
        }).start();

        /*JDK8 简化 lambda只能有一个方法*/
        new Thread(()-> {
                System.out.println("一边听歌");
        }).start();

    }

}
