package sct_interface;

/**
 * 自定义一个HashMap
 * 测试实现HashMap基本结构，put存储键值对，实现toString ★★★★★
 */

public class HashMap01 {

    Node[] table;  //位桶数组，Entry数组
    int size;  //存放键值对的个数

    public HashMap01(){
        table = new Node[16];  //长度一般定义为2的整数幂
    }

    /*put存储键值对方法 ☆☆☆☆☆-----1*/  //如果要完善还需要考虑数组扩容问题
    public void put(Object key,Object value){

        //定义了新的节点对象
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];  //哈希值所对应的数组中的一个单位

        Node iterLast = null;  //正在遍历的最后一个元素
        boolean keyRepeat = false;

        if (temp == null){
            //此处数组元素为空,则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else {
            //此处数组元素不为空，则遍历对应链表
            while (temp != null){
                //判断key如果重复，则覆盖. HashMap规则
                if (temp.key.equals(key)){

                    System.out.println("key重复了！！");
                    temp.value = value;  //覆盖Value值，其他不变
                    keyRepeat = true;
                    break;
                }
                //key不重复,则遍历下一个
                iterLast = temp;
                temp = temp.next;
            }
        }
        if (!keyRepeat && iterLast != null) {  //没有发生重复则执行
            iterLast.next = newNode;
            size++;
        }
    }

    /*实现get方法,根据键对象获得对应的值对象-----3*/
    public Object get(Object key){

        int hash = myHash(key.hashCode(),table.length);
        Object value = null;

        if (table[hash] != null){
            Node temp = table[hash];
            while (temp != null){

                if (temp.key.equals(key)){  //如果相等则找到了相应的键值对
                    value = temp.value;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }

        return value;
    }

    /*重写toString方法便于查看Map键对值信息------2*/
    @Override
    public String toString() {
        //{10:aa,20:bb}
        StringBuilder sb = new StringBuilder("{");

        //遍历bucket数组
        for (int i=0; i<table.length; i++){
            Node temp = table[i];

            //遍历链表
            while (temp!=null){
                sb.append(temp.key + ":" + temp.value + ",");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');

        return sb.toString();
    }

    /*求出hash值方法-----1*/
    public int myHash(int v,int length){

        System.out.println("hash in myHash: " + (v&(length-1)));  //直接的位运算，效率高
//        System.out.println("hash in myHash: " + (v%(length-1)));  //求余运算 效率低 值不相同
        return v&(length-1);
    }

    public static void main(String[] args) {
        HashMap01 m = new HashMap01();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"ssss");
        m.put(53,"第一位");
        m.put(69,"第二位");
        m.put(85,"第三位");
        System.out.println(m.get(69));
        System.out.println(m);
    }

}
