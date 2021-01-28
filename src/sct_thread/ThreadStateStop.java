package sct_thread;

/**
 * 测试终止线程
 * 1.线程正常执行完毕
 * 2.外部干涉--->加入标识
 * 不要使用stop
 */

public class ThreadStateStop implements Runnable{

    private boolean flag = true;
    private String name;

    public ThreadStateStop(String name) {
        this.name = name;
    }

    /*关联标志，true-->运行,false-->停止*/
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(name + "--->" +i++);
        }
    }

    /*对外提供方法改变线程*/
    public void terminate(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStateStop tss = new ThreadStateStop("线程一");
        new Thread(tss).start();

        //i太小 主线程会立马跑完
        for (int i=0; i<1000; i++){
            if (i==888){
                tss.terminate(); //终止线程
                System.out.println("game over");
            }
            System.out.println("main-->" + i);
        }
    }

}
