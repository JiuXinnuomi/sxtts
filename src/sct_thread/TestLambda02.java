package sct_thread;

/**
 * Lambda推导，加入参数
 */

public class TestLambda02 {

    public static void main(String[] args) {
        ILove love = (int a)-> {
            System.out.println(a);
        };
        love.lambda(100);

        //简化,只有一种类型
        love = (a)-> {
            System.out.println(a);
        };
        love.lambda(50);

        //简化,只有一个参数
        love = a-> {
            System.out.println(a);
        };
        love.lambda(5);

        //简化,只有一行方法代码
        love = a-> System.out.println(a);
        love.lambda(5);

    }
}

interface ILove{
    void lambda(int a);
}

/*外部内*/
class Love implements ILove{

    @Override
    public void lambda(int a) {
        System.out.println(a);
    }
}
