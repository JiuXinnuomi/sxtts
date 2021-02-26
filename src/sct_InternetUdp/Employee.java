package sct_InternetUdp;

import java.io.Serializable;

/**
 * javabean封装数据
 */

public class Employee implements Serializable {

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
