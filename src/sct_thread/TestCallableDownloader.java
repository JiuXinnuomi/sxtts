package sct_thread;

import java.util.concurrent.*;

/**
 * 了解创建线程方式三 Callable
 * 1.创建执行服务
 * 2.提交执行
 * 3.获取结果
 * 4.关闭服务
 */

public class TestCallableDownloader implements Callable<Boolean> {

    private String url;  //远程路径
    private String name;  //存储名字

    public TestCallableDownloader(String url, String name){
        super();
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        TestWebDownloder twd =new TestWebDownloder();
        twd.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallableDownloader tcd1 = new TestCallableDownloader("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1403771733,1490427964&fm=111&gp=0.jpg","src/shiyan/dongman1.jpg");
        TestCallableDownloader tcd2 = new TestCallableDownloader("https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3303663935,1538145616&fm=26&gp=0.jpg","src/shiyan/dongman2.jpg");
        TestCallableDownloader tcd3 = new TestCallableDownloader("https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2723394144,981508277&fm=26&gp=0.jpg","src/shiyan/dongmane3.jpg");

        /*启动多线程*/
        //1.创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //2.提交执行
        Future<Boolean> result1 = ser.submit(tcd1);
        Future<Boolean> result2 = ser.submit(tcd2);
        Future<Boolean> result3 = ser.submit(tcd3);
        //3.获取结果
        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r3);
        //4.关闭服务
        ser.shutdownNow();


    }
}
