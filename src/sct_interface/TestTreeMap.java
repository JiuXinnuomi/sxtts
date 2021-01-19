package sct_interface;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap的使用
 */

public class TestTreeMap {

    public static void main(String[] args) {

        Map<Integer,String> treemap1 = new TreeMap<>();
        treemap1.put(20,"aa");
        treemap1.put(3,"bb");
        treemap1.put(6,"cc");

        //按照key递增的方式排序
        for (Integer key: treemap1.keySet()){
            System.out.println(key + "---" + treemap1.get(key));
        }

        Map<Emp,String> treemap2 = new TreeMap<>();
        treemap2.put(new Emp(100,"张三",50000),"张三是一个好小伙");
        treemap2.put(new Emp(101,"李四",5000),"李四是一个好小伙");
        treemap2.put(new Emp(102,"王五",8000),"王五是一个好小伙");
        treemap2.put(new Emp(50,"赵六",8000),"赵六是一个好小伙");

        //按照key递增的方式排序
        for (Emp key: treemap2.keySet()){
            System.out.println(key + "---" + treemap2.get(key));
        }

    }
}

/*Comparable接口是通过compareTo方法实现的*/
class Emp implements Comparable<Emp> {
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /*重写toString方法*/

    @Override
    public String toString() {
        return "id: " + id + "name: " + name + "salary: " + salary;
    }

    /*CompareTo比较方法的常规定义*/
    @Override
    public int compareTo(Emp o) {  //负数：小于  0：等于  整数：大于

        if (this.salary > o.salary){
            return 1;
        }else if (this.salary < o.salary){
            return -1;
        }else {
            if (this.id > o.id){
                return 1;
            }else if (this.id < o.id){
                return -1;
            }else {
                return 0;
            }
        }

    }

}
