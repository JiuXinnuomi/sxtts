package sct_project;

import java.util.*;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行数据使用javabean对象存储，多行数据放到map或list中
 */

public class TestStoreData2 {

    public static void main(String[] args) {

        User user1 = new User(1001,"张三",2000,"2020.6.5");
        User user2 = new User(1002,"李四",8000,"2018.6.5");
        User user3 = new User(1003,"糯米",50000,"2021.6.5");

//        /*放入List容器中*/
//        List<User> list = new ArrayList<>();
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//
//        for (User u : list){
//            System.out.println(u);
//        }

        Map<Integer,User> map = new HashMap<>();
        map.put(1001,user1);
        map.put(1002,user2);
        map.put(1003,user3);

        Set<Integer> keyset = map.keySet();  //keyset() 返还map中的所有key键值
        for (Integer key : keyset){
            System.out.println(key + "====" + map.get(key));
        }
    }
}

/*自定义一个JavaBean*/
class User{
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    //一个完整的javabean。要有set和get方法，以及无参构造器
    public User() {
    }

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "id: " + id + "name: " + name + "salary: " + salary + "入职日期: " + hiredate;
    }
}
