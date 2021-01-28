package sct_thread;

/**
 * Lambda推导，加入返回值
 */

public class TestLambda03 {

    public static void main(String[] args) {
        IHate hate = (int a1, int a2)-> {
            System.out.println(a1 + "-------" + a2);
            return a1+a2;
        };
        hate.lambda(100,200);

        //简化
        hate = (a1,a2)-> {
            System.out.println(a1 + "-------" + a2);
            return a1+a2;
        };
        hate.lambda(20,30);

        //简化return
        hate = (a1,a2)-> a1+a2;
        System.out.println(hate.lambda(2,3));

    }
}

interface IHate{
    int lambda(int a, int b);
}

/*外部类*/
class Hate implements IHate{

    @Override
    public int lambda(int a1, int a2) {
        System.out.println(a1 + "-------" + a2);
        return a1+a2;
    }
}