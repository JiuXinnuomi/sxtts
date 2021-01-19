package sct_test;

import java.util.Arrays;

/**
 * 测试排序
 */

public class TestArraysSort {

    public static void main(String[] args) {
        TestArraysSort t = new TestArraysSort();
        t.bubbleSort();

        int[] arr = {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        int value = 10; //要查找的值
        System.out.println(t.binarySearch(arr,value));
    }

/*冒泡排序及优化*/
    public void bubbleSort(){

        int[] values = {3,1,6,2,9,0,7,4,5,8};
        int temp = 0;

        for (int i = 0; i<values.length-1; i++){
            //优化冒泡算法
            boolean flag = true;

            for (int j = 0; j<values.length-1-i; j++){

                if (values[j]>values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(Arrays.toString(values));

    }

/*二分法检索，折半查找*/
    public int binarySearch(int[] arr,int value){
        //只能检索排好序的数组
        int low = 0;
        int high = arr.length-1;

        while (low <= high ){
            int mid = (low+high)/2;

            if (value == arr[mid]){
                return mid;
            }
            if (value > arr[mid]){
                low = mid+1;
            }
            if (value < arr[mid]){
                high = mid-1;
            }
        }
        return -1;
    }



}
