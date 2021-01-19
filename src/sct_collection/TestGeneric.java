package sct_collection;

/**
 * 测试泛型用例★★★★★
 */

public class TestGeneric {

    public static void main(String[] args) {
        //未设置泛型时提取对象
        MyCollection mc = new MyCollection();
        mc.set("黄宇",0);
        mc.set(8888,1);

        String a = (String)mc.get(0);
        Integer b = (Integer)mc.get(1);

        //设置泛型后题去对象,泛型类似于定义一个形参来管理容器类型
        MyCollection01<String> mc01 = new MyCollection01<>(); //新new的对象可以省略类型
        mc01.set("黄宇",0);
        System.out.println(mc01.get(0));


    }
}

/*基本容器*/
class MyCollection {
    Object[] objs = new Object[5];

    public void set(Object obj,int index){
        objs[index] = obj;
    }

    public Object get(int index){
        return objs[index];
    }
}

/*添加泛型过后的容器★★★★★*/
class MyCollection01<E> {
    Object[] objs = new Object[5];

    public void set(E e,int index){
        objs[index] = e;
    }

    public Object get(int index){
        return (E)objs[index];
    }
}
