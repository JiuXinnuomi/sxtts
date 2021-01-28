package sct_thread;

/**
 * 实现下载图片 Thread  ☆☆☆
 */

public class TWebDownloder implements Runnable{
    private String url;  //远程路径
    private String name;  //存储名字

    public TWebDownloder(String url, String name){
        super();
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        TestWebDownloder twd =new TestWebDownloder();
        twd.download(url,name);
        System.out.println(name);

    }

    public static void main(String[] args) {
        TWebDownloder td = new TWebDownloder("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1403771733,1490427964&fm=111&gp=0.jpg","src/shiyan/dongman1.jpg");
        TWebDownloder td2 = new TWebDownloder("https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3303663935,1538145616&fm=26&gp=0.jpg","src/shiyan/dongman2.jpg");
        TWebDownloder td3 = new TWebDownloder("https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2723394144,981508277&fm=26&gp=0.jpg","src/shiyan/dongmane3.jpg");

        //启动多线程
        new Thread(td).start();
        new Thread(td2).start();
        new Thread(td3).start();

    }

}
