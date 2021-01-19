package sct_interface;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet接口
 * Set接口完全继承Collection，没有新增方法。
 * 特点： 无需，不可重复.  底层是Map
 * List: 有序，可重复
 */

public class TestHashSet {

    public static void main(String[] args) {

        Set<String> set1 = new HashSet<>();
        set1.add("aa");
        set1.add("bb");
        set1.add("cc");
        System.out.println(set1);
        set1.remove("bb");
        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.add("ee");
        set2.add("bb");
        set2.add("aa");
        set2.addAll(set1);
        System.out.println(set2);

    }
}
