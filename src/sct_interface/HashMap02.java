package sct_interface;

public class HashMap02<K,V> {

    Node2[] table;  //位桶数组，Entry数组
    int size;  //存放键值对的个数

    public HashMap02(){
        table = new Node2[16];  //长度一般定义为2的整数幂
    }

    /*put存储键值对方法 ☆☆☆☆☆-----1*/  //如果要完善还需要考虑数组扩容问题
    public void put(K key,V value){

        //定义了新的节点对象
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node2 temp = table[newNode.hash];  //哈希值所对应的数组中的一个单位

        Node2 iterLast = null;  //正在遍历的最后一个元素
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

    /*实现get方法,根据键对象获得对应的值对象------3*/
    public V get(K key){

        int hash = myHash(key.hashCode(),table.length);
        V value = null;

        if (table[hash] != null){
            Node2 temp = table[hash];
            while (temp != null){

                if (temp.key.equals(key)){  //如果相等则找到了相应的键值对
                    value = (V) temp.value;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }

        return value;
    }

    /*实现remove方法,根据键对象删除对应的节点*/
//    public void remove(K key)

    /*重写toString方法便于查看Map键对值信息------2*/
    @Override
    public String toString() {
        //{10:aa,20:bb}
        StringBuilder sb = new StringBuilder("{");

        //遍历bucket数组
        for (int i=0; i<table.length; i++){
            Node2 temp = table[i];

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
        HashMap02<Integer,String> m = new HashMap02<>();
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
