package sct_collection;

/**
 * 自定义数组二，增加数组扩容方法
 */

public class TestDiyArrayList02<E> {

    private Object[] elementData;
    private int size;  //未初始化的变量系统会默认初始化为0
    private int DEFALT_CAPACITY = 10;

    public TestDiyArrayList02(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public TestDiyArrayList02(int capacity){
        elementData = new Object[capacity];
    }

    /*对老数组进行扩容*/
    public void add(E element){

        if (size == elementData.length){
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }

        elementData[size++] = element;
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

        TestDiyArrayList02<String> s1 = new TestDiyArrayList02<>(20);
        s1.add("黄宇");
        s1.add("糯米");
        for (int i=0; i<40; i++){
            s1.add("糯米");
        }
        System.out.println(s1);
    }
}
