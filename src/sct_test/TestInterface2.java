package sct_test;

/**
 * 测试接口类的多继承
 */

public class TestInterface2 {

}

interface A{
    void testa();
}

interface  B{
    void testb();
}

interface C extends A,B {
    void testc();
}

/*接口可以多继承，类只能单继承*/
class Mysubclass implements C{
    @Override
    public void testa() {

    }

    @Override
    public void testb() {

    }

    @Override
    public void testc() {

    }
}
