package Day10;

import Day09.HeapDemo;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 02 01
 * Time:15:24
 */
public class Test02 {

    public String name="abc";
    public static void main(String[] args){
        Test02 test=new Test02();
        Test02 testB=new Test02();
        System.out.println(test.equals(testB)+","+test.name.equals(testB.name));
        Object o=new Object(){
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

    public static void main1(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        //shellSort(arr);
        //selectSort(arr);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));

    }

    //快速排序
    public static void quickSort(int[] arr){
        quick(arr,0, arr.length - 1);
    }

    public static void quick(int[] arr,int low ,int high){
        if(low < high){
            int piv = pivot(arr,low,high);
            quick(arr,low,piv-1);
            quick(arr,piv+1,high);
        }
    }

    public static int pivot(int[] arr,int start ,int end){
        int tmp = arr[start];
        while (start < end){
            //从最后面往前走,条件为后面的值都大于tmp
            while(start < end && arr[end] >= tmp){
                end--;
            }
            arr[start] = arr[end];

            while(start < end && arr[start] <= tmp){
                start++;
            }
            arr[end] = arr[start];
        }

        arr[start] = tmp;
        return start;
    }

    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = arr[i];
                if(arr[j] < tmp){
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //希尔排序
    public static void shell(int[] arr ,int gap){
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - gap;
            for (; j >= 0; j = j - gap) {
                if(tmp < arr[j]){
                    arr[j + gap] = arr[j];
                }else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }

    public static void shellSort(int[] arr){
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(arr,drr[i]);
        }
    }
}
