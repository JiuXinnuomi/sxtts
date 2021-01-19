package sct_io;

/**
 * 测试 设计模式入门
 * 实现扩音器扩音
 */

public class TestDecorate01 {

    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        //装饰
        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{
    //属性
    private int voice = 10;
    @Override
    public void say() {
        System.out.println("人的声音为：" + this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{
    private Person p;

    Amplifier(Person p){
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为： " + p.getVoice()*100);
    }
}
