package sct_collection;

/**
 * 自定义ArrayList数组
 * 增加set和get方法
 * 增加：数组边界检查
 */

public class TestDiyArrayList03<E> {

    private Object[] elementData;
    private int size;  //未初始化的变量系统会默认初始化为0
    private int DEFALT_CAPACITY = 10;

    public TestDiyArrayList03(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    /*新建自定义数组大小*/
    public TestDiyArrayList03(int capacity){
        if (capacity<0){
            throw new RuntimeException("容器容量不能为0！");
        }if (capacity == 0){
            elementData = new Object[DEFALT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    /*索引合法判断*/
    public void checkRange(int index){
        if ( index < 0 || index > size-1){
            throw new RuntimeException("索引不合法！" + index);
        }
    }

    /*数组get方法*/
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    /*数组set方法*/
    public void set(E element,int index){
        checkRange(index);
        elementData[index] = element;
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

        TestDiyArrayList03<String> s1 = new TestDiyArrayList03<>(20);
        for (int i=0; i<40; i++){
            s1.add("糯米");
        }
        System.out.println(s1.get(39));
    }
}
