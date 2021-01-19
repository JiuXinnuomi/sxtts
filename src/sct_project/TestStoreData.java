package sct_project;

import java.util.*;

/**
 * 测试容器存放表格数据
 * ORM思想的简单实验，对象关系映射
 */

public class TestStoreData {

    public static void main(String[] args) {

        Map<String,Object> row1 = new HashMap<>();
        row1.put("id",1001);
        row1.put("name","张三");
        row1.put("salary",20000);
        row1.put("入职日期","2018.5.5");

        Map<String,Object> row2 = new HashMap<>();
        row2.put("id",1002);
        row2.put("name","李四");
        row2.put("salary",30000);
        row2.put("入职日期","2018.5.4");

        //遍历整张表格 ☆☆☆☆
        List<Map<String,Object>> table1 = new ArrayList<>();
        table1.add(row1);
        table1.add(row2);

        //将String作为key值，打印对应的值对象
        for (Map<String,Object> row : table1){
            Set<String> keyset = row.keySet();
            for (String key : keyset){
                System.out.print(key + ":" + row.get(key) + "\t");
            }
            System.out.println();
        }


    }
}
