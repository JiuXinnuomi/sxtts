package sct_test;

/**
 * 测试数组的拷贝
 */

public class TestArrayCopy {

    public static void main(String[] args) {

//        testBasicCopy2();
//
        String[] str = {"京东","阿里","百度","亚马逊","尚学堂"};
//        removeElment(str,3);
        //在原数组加扩容多大
//        extendRange(str,10);
        //向数组内指定下标插入一个元素
        insertElment(str,2,"哔哩哔哩");

    }

/*拷贝一个数组*/
    public static void testBasicCopy(){
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[10];
        //srcpos 原数组起始下标，destPos 目标数组起始下标
        System.arraycopy(s1,2,s2,6,3);

        for (int i = 0; i<s2.length; i++){
            System.out.println(i+ "--" +s2[i]);
        }
    }

/*测试从数组中删除某个元素(本质依旧是数组的拷贝)*/
    public static void testBasicCopy2(){
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[5];

        System.arraycopy(s1,3,s1,3-1,s1.length-3);

        s1[s1.length-1] = null;

        for (int i = 0; i<s1.length; i++){
            System.out.println(i+ "--" +s1[i]);
        }
    }

/*删除数组中的指定索引的元素(本质依旧是数组的拷贝)*/
    //☆☆☆☆☆
    public static String[] removeElment(String[] s, int index){

        System.arraycopy(s,index+1,s,index,s.length-index-1);

        s[s.length-1] = null;

        for (int i = 0; i<s.length; i++){
            System.out.println(i+ "--" +s[i]);
        }

        return s;
    }

/*数组的扩容（本质上是：先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中）*/
    public static String[] extendRange(String[] s, int index){

        String[] s2 = new String[s.length+index];
        System.arraycopy(s,0,s2,0,s.length);
        for (String temp: s2){
            System.out.println(temp);
        }

        return s2;

    }

/*向数组内插入一个元素 */
    //☆☆☆☆☆
    public static String[] insertElment(String[] s ,int index ,String e){
        String[] s2 = new String[s.length+1];

        System.arraycopy(s,0,s2,0,s.length);
        for (int i = s2.length-1; i>index; i--){
            s2[i] = s2[i-1];
        }
        s2[index] = e;

        for (String temp: s2){
            System.out.println(temp);
        }

        return s2;

    }

}
