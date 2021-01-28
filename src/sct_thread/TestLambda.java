package sct_thread;

/**
 * 测试Lambda推导
 *
 */

public class TestLambda {

    /*静态内部类*/
    static class Like2 implements ILike{
        @Override
        public void lambda() {
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like = new Like2();
        like.lambda();

        /*匿名内部类 ☆☆☆*/
         like = new ILike() {
            @Override
            public void lambda() {
                System.out.println(111);
            }
        };
        like.lambda();

        /*Lambda实现,必须存在类型*/
        like = () -> {
            System.out.println(111);
        };
        like.lambda();

    }
}

interface ILike{
    void lambda();
}

/*外部类*/
class Like implements ILike{

    @Override
    public void lambda() {

    }
}
