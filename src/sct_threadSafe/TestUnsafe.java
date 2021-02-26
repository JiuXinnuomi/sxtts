package sct_threadSafe;

/**
 * 线程不安全
 * 1.新的线程会开辟新的工作空间
 * 2.存在数据重复，数据为负数
 */

public class TestUnsafe {

    public static void main(String[] args) {

        Account account = new Account(100,"结婚礼金");
        Drawing you = new Drawing(account,70,"丈夫");
        Drawing wife = new Drawing(account,80,"妻子");
        you.start();
        wife.start();

    }
}

//账户
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取款
class Drawing extends Thread{

    Account account;  //账户
    int drawingMoney;  //取钱
    int packetTotal;  //现金

    public Drawing(Account account, int drawingMoney, String name){
        super(name);  //为线程命名
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName()+ "-->账户余额为" + account.money);
        System.out.println(this.getName()+ "-->现金为" + packetTotal);
    }

}