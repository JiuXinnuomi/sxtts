package sct_exception;

/**
 * 测试自定义异常
 */

public class TextDiyException {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(-10);
    }
}

class Person{
    private int age;

    public int getAge(){
        return age;
    }

    //定义异常输出
    public void setAge(int age){
        if (age<0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

/*自定义异常处理 */
class IllegalAgeException extends RuntimeException{
    public IllegalAgeException(){

    }
    //定义异常输出类型
    public IllegalAgeException(String msg){
        super(msg);
    }
}
