package sct_interface;

import java.util.Set;
import java.util.TreeSet;


/**
 * 测试TreeSet的使用
 * 熟悉Comparable接口
 */

public class TestTreeSet {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        set.add(300);
        set.add(200);
        set.add(600);

        //按照元素递增方式排序
        for (Integer m: set){
            System.out.println(m);
        }

        Set<Emp> set2 = new TreeSet<>();
        set2.add(new Emp(20,"张三",3000));
        set2.add(new Emp(150,"李四",8000));
        set2.add(new Emp(3,"王五",8000));
        set2.add(new Emp(1,"糯米",300000));

        for (Emp e: set2){
            System.out.println(e);
        }

    }
}
