package sct_test;

/**
 * 测试接口类
 */

public class Testinterface {
    public static void main(String[] args) {
        Volant v = new Angel();
        v.fly();

        Honest h = new GoodMan();
        h.helpOtehr();
    }
}

interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}

interface Honest{
    void helpOtehr();
}

class Angel implements Volant,Honest{
    @Override
    public void fly() {
        System.out.println();
    }

    @Override
    public void helpOtehr() {

    }
}

class GoodMan implements Honest{
    @Override
    public void helpOtehr() {

    }
}
