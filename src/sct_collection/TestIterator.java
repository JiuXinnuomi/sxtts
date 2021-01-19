package sct_collection;

import java.util.*;

/**
 * 测试迭代器遍历set、Set、Map ☆☆☆☆☆
 * 提供了统一的接口来遍历不同容器
 */

public class TestIterator {

    public static void main(String[] args) {

        testIteratorList();
        testIteratorSet();
        testIteratorMap01();
        testIteratorMap02();
    }

    /*迭代器遍历set*/
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        //使用迭代器遍历list
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }

    }

    /*迭代器遍历Set*/
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        //使用迭代器遍历set
        for (Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    /*迭代器遍历Map方式01 ☆☆☆*/
    public static void testIteratorMap01(){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(100,"aa");
        map1.put(200,"bb");
        map1.put(300,"cc");

        Set<Map.Entry<Integer,String>> ss = map1.entrySet();

        for (Iterator<Map.Entry<Integer,String>> iter = ss.iterator(); iter.hasNext(); ){
            Map.Entry<Integer,String> temp = iter.next();

            System.out.println(temp.getKey() + "----" + temp.getValue());
        }

    }

    /*迭代器遍历Map方式02 ☆☆☆*/
    public static void testIteratorMap02(){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(100,"aa");
        map1.put(200,"bb");
        map1.put(300,"cc");

        Set<Integer> keySet = map1.keySet();
        for (Iterator<Integer> iter = keySet.iterator(); iter.hasNext(); ){
            Integer key = iter.next();
            System.out.println(key + "----" + map1.get(key));
        }
    }

}
