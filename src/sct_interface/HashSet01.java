package sct_interface;

import java.util.HashMap;

/**
 * 手动实现一个HashSet
 */

public class HashSet01 {

    HashMap map;
    private static final Object PRESENT = new Object();

    public HashSet01(){
        map = new HashMap();
    }

    /*add方法*/
    public void add(Object o){
        map.put(o,PRESENT);
    }

    /*size方法*/
    public int size(){
        return map.size();
    }

    /*toString方法*/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
//        sb.append("[")

        for (Object key: map.keySet()){
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length()-1,']');

        return sb.toString();
    }

    public static void main(String[] args) {
        HashSet01 set = new HashSet01();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set.size());
        System.out.println(set);
    }

}
