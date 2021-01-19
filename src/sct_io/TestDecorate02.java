package sct_io;

/**
 * 测试 设计模式 ☆☆☆
 * 实现模拟咖啡机
 */

public class TestDecorate02 {

    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger = new Suger(coffee);
        System.out.println(suger.info() + "价格为：" + suger.cost());

        Drink milk = new Milk(suger);
        System.out.println(milk.info() + "价格为：" + milk.cost());

    }
}

/*抽象组件*/
interface Drink{
    double cost();  //费用方法
    String info();  //说明方法
}

/*具体组件*/
class Coffee implements Drink{
    private String name = "原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }

}

/*抽象装饰类*/
abstract class Decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;
    public Decorate(Drink drink){
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

/*具体装饰类*/
class Milk extends Decorate{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶";
    }
}

class Suger extends Decorate{

    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info() + "加入了蔗糖";
    }
}