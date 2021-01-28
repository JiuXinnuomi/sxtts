package sct_thread;

/**
 * 测试静态代理 设计模式
 * 代理：为你需要实现的方法做准备工作和结尾工作
 * 1.真实角色
 * 2.代理角色
 */

public class TestStaticProxy {

    public static void main(String[] args) {
           new WeddingCompany(new You()).happyMarry();

           //new Thread(线程对象).start();
    }
}

/*必须要实现的方法*/
interface Marry{
    void happyMarry();
}

/*需要实现方法的角色*/
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("你和嫦娥终于登月了");
    }
}

/*代理角色，为真实角色实现方法而忙前忙后的角色*/
class WeddingCompany implements Marry{
    //真实角色
    /*多处方法使用改参数，则需要方法外部定义target*/
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        read();
        this.target.happyMarry();
        after();
    }

    private void read(){
        System.out.println("准备座椅");
    }

    private void after(){
        System.out.println("收拾后续");
    }

}

