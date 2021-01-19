package sct_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试Collection接口中的方法
 */
public class TestList {

    public static void main(String[] args) {

//        test01();
//        test02();
        test03();
    }

    /*测试单个容器方法*/
    public static void test01(){
        Collection<String> c = new ArrayList<>();

        c.add("米奇");
        c.add("妙妙屋");

        c.remove("米奇");  //移除不会删除对象本身
        System.out.println(c.size()); //容器大小
        System.out.println(c.isEmpty()); //是否为空
        System.out.println(c.contains("妙妙屋")); //是否包含某个元素
        System.out.println(c);

        Object[] objs= c.toArray(); //Obj对象打印地址
        System.out.println(objs);

        c.clear();
        System.out.println(c);

    }
    /*测试容器交互方法*/
    public static void test02(){
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list: " + list01);
        list01.addAll(list02); //添加list02容器所有内容
        list01.removeAll(list02);  //移除全部的相同部分
        System.out.println("list: " + list01);
        list01.retainAll(list02);  //只保留相同的部分

        System.out.println(list01.containsAll(list02));  //是否包含list02

    }
    /*测试与索引相关的容器*/
    public static void test03(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);

        list.add(2,"黄宇");
        list.remove(2);
        list.set(2,"黄宇");
        System.out.println(list);
        System.out.println(list.get(2));

        list.add("C");
        list.add("B");
        list.add("A");
        System.out.println(list.indexOf("B")); //返回指定元素第一次出现的下标
        System.out.println(list.lastIndexOf("B"));



    }
}
