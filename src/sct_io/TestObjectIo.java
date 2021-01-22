package sct_io;

import java.io.*;
import java.util.Date;

/**
 * 测试对象流
 */

public class TestObjectIo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//将不同的数据类型分别写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new ByteArrayOutputStream(new FileOutputStream(“path”))));

        //操作数据类型
        oos.writeObject("谁知其中味");
        oos.writeObject(new Date());
        Employee emp = new Employee("马云",400);
        oos.writeObject(emp);
        oos.flush();
        oos.close();

        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);

        //依次读取,顺序必须保持一致
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(new FileInputStream("path"))));

        Object str = ois.readObject();
        Object date = ois.readObject();
        Object employee = ois.readObject();

        //对象的还原
        if (str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date){
            Date dateObj = (Date) date;
            System.out.println(dateObj);
        }
        if (employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName());
        }
        ois.close();
    }


}

//Javabean 封装数据
class Employee implements Serializable{
    private String name;
    private transient double salary;   //该数据避免序列化

    public Employee(){

    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
}
