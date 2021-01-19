package sct_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试TestCollections工具类
 * Collection是接口
 */

public class TestCollections {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i=0; i<10; i++){
            list.add("gao " + i);
        }

        Collections.shuffle(list);  //随机排列list中的元素
        Collections.reverse(list);  //逆序排列list中的元素
        Collections.sort(list);  //递增的方式排序,自定义类的使用：Comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list,"张三"));  //二分法查找
    }
}
