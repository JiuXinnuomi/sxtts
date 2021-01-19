package sct_collection;

import java.sql.ClientInfoStatus;

/**
 * 测试LinkedList链表 ☆☆☆☆☆
 * 增加小的封装,增加泛型
 */

public class TestLinkedList01<E> {

    private Node first;
    private Node last;
    private int size;

//    /*低效率的链表get方法*/
//    public Object get(int index){
//        if (index<0||index>size-1){
//            throw new RuntimeException("索引越界！");
//        }
//        Node temp = first;
//        for (int i=0; i<index; i++){
//            temp = temp.next;
//        }
//        return temp.element;
//    }

    /*链表get方法优化版*/
    public E get(int index){
        if (index<0||index>size-1){
            throw new RuntimeException("索引越界！");
        }
        Node temp = getNode(index);

        return temp!=null? (E) temp.element : null;
    }

    /*链表的add方法 ☆☆☆☆☆*/
    public void add(E element){  //alt+shift+R重构变量名
        Node node = new Node(element);

        if (first==null){
//            node.previous = null;
//            node.next = null;
            first = node;
            last = node;

        }else {
            node.previous = last;
            node.next =  null;

            last.next = node;
            last = node;
        }
        size++;
    }

    /*链表的remove方法*/
    public void remove(int index){
        Node temp = getNode(index);

        if (temp != null){
            Node up = temp.previous;
            Node down = temp.next;

            if (up!=null){
                up.next = down;
            }
            if (down!=null){
                down.previous = up;
            }

            //被删除的元素是特殊节点
            if (index == 0){
                first = down;
            }
            if (index == size-1){
                last = up;
            }
        }

        size--;
    }

    /*链表的insert插入方法 ☆☆☆☆☆*/
    public void insert(int index, E element){

        Node newNode = new Node(element);
        Node temp = getNode(index);

        if (index == 0){
            temp.previous = newNode;
            newNode.next = temp;
            first = newNode;
        }else if (index == size){
            temp.next = newNode;
            newNode.previous = temp;
            last = newNode;
        } else if (temp!=null) {
            Node up = temp.previous;
            up.next = newNode;
            newNode.next = temp;
            temp.previous = newNode;
        }
//        else{
//            Node up = temp.previous;
//            Node down = temp.next;
//            up.next = newNode;
//            down.previous = newNode;
//            newNode.next = down;
//        }

        size++;
    }

    /*封装获取节点的方法*/
    private Node getNode(int index){

        checkRange(index);
        Node temp = null;
        if (index <= (size >> 1)) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    /*检查索引下标是否越界*/
    private void checkRange(int index){
        if (index<0 || index>size){
            throw new RuntimeException("索引下标越界");
        }
    }

    /*链表重写toStirng*/
    @Override
    public String toString() {
        //first = a, last = c
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp!=null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {

        TestLinkedList01<String> tll = new TestLinkedList01<>();

        tll.add("a");
        tll.add("b");
        tll.add("c");
        tll.add("d");
        tll.add(null);
        tll.add("f");
        tll.insert(0,"糯米");
        tll.insert(7,"糯米03");
        System.out.println(tll.get(7));
        System.out.println(tll);
    }
}
