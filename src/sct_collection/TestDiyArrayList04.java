package sct_collection;

/**
 * 自定义ArrayList数组
 * 增加remove方法
 * @param <E>
 */

public class TestDiyArrayList04<E> {

    private Object[] elementData;
    private int size;  //未初始化的变量系统会默认初始化为0
    private int DEFALT_CAPACITY = 10;

    public TestDiyArrayList04(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    /*新建自定义数组大小*/
    public TestDiyArrayList04(int capacity){
        if (capacity<0){
            throw new RuntimeException("容器容量不能为0！");
        }if (capacity == 0){
            elementData = new Object[DEFALT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    /*判断数组是否为空*/
    public boolean isEmpty(){
        return size==0? true:false;
    }

    /*索引合法判断*/
    public void checkRange(int index){
        if ( index < 0 || index > size-1){
            throw new RuntimeException("索引不合法！" + index);
        }
    }

    /*移除数组指定元素 ☆☆☆☆☆*/
    public void remove(E element){
        //element，将它和所有元素挨个比较，获得第一个比较为true的，返回

        int value = size;  //检验数组是否发生变化

        for (int i=0; i<size; i++){
            if (element.equals(get(i))) {  //容器中的比较操作都是运用equals
                remove(i);
            }
        }
        if (value == size){
            throw new RuntimeException("该数组中没有相同的元素!!");
        }
    }

    public void remove(int index){

        int numMoved = elementData.length-index-1;
        if (numMoved>0) {  //谨慎考虑
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;  //size仅是定义为数组长度，并不是真的数组长度
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

        TestDiyArrayList04<String> s1 = new TestDiyArrayList04<>(20);
        for (int i=0; i<40; i++){
            s1.add("糯米" + i);
        }
//        s1.remove(3);
        s1.remove("糯米22");
//        System.out.println(s1.get(23));
        System.out.println(s1);
    }
}
