package sct_threadSafe;

/**
 * 测试线程安全同步块
 */

public class TestSynBlock {

    public static void main(String[] args) {

        Account account = new Account(100,"结婚礼金");
        SynDrawing you = new SynDrawing(account,70,"丈夫");
        SynDrawing wife = new SynDrawing(account,80,"妻子");
        you.start();
        wife.start();

    }
}

//模拟取款
class SynDrawing extends Thread{

    Account account;  //账户
    int drawingMoney;  //取钱
    int packetTotal;  //现金

    public SynDrawing(Account account, int drawingMoney, String name){
        super(name);  //为线程命名
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    /*锁定对象的金额，实现线程同步*/
    public void test(){
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            packetTotal += drawingMoney;
            System.out.println(this.getName() + "-->账户余额为" + account.money);
            System.out.println(this.getName() + "-->现金为" + packetTotal);
        }
    }

    @Override
    public void run() {
        test();
    }

}