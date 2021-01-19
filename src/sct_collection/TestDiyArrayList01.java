package sct_collection;

/**
 * 自定义实现一个ArrayList，体会底层原理
 */

public class TestDiyArrayList01 {

    private Object[] elementData;
    private int size;  //未初始化的变量系统会默认初始化为0
    private int DEFALT_CAPACITY = 10;

    public TestDiyArrayList01(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public TestDiyArrayList01(int capacity){
        elementData = new Object[capacity];
    }

    public void add(Object obj){
        elementData[size++] = obj;
    }

    /*重写toString方法  ☆☆☆☆☆*/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i<size; i++){
            sb.append(elementData[i]+ ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {

        TestDiyArrayList01 s1 = new TestDiyArrayList01(20);
        s1.add("黄宇");
        s1.add("糯米");
        System.out.println(s1);
    }
}
