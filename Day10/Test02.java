package Day10;

import Day09.HeapDemo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 02 01
 * Time:15:24
 */
public class Test02 {

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        //quickSort1(arr);
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    public String name="abc";
    public static void main2(String[] args){
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

    //归并排序非递归
    public static void merge(int[]arr,int gap){
        int s1 = 0;
        int e1 = s1 + gap - 1;
        int s2 = e1 + 1;
        int e2 = s2 + gap - 1 < arr.length ? s2 + gap -1 : arr.length-1;
        int[] tmp = new int[arr.length];
        int k = 0;
        while (s2 < arr.length){
            while (s1 <= e1 && s2 <= e2){
                if(arr[s1] <= arr[s2]){
                    tmp[k++] = arr[s1++];
                }else {
                    tmp[k++] = arr[s2++];
                }
            }
            while (s1 <= e1){
                tmp[k++] = arr[s1++];
            }
            while (s2 <= e2){
                tmp[k++] = arr[s2++];
            }
            s1 = e2 + 1;
            e1 = s1 + gap - 1;
            s2 = e1 + 1;
            e2 = s2 + gap - 1 < arr.length ? s2 + gap -1 : arr.length-1;
        }
        while (s1 < arr.length){
            tmp[k++] = arr[s1++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void mergeSort1(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            merge(arr,i);
        }
    }

    ///归并排序
    public static  void mergeSortInternal(int[] arr,int low,int high){
        if(low >= high)
            return ;
        int mid = (low + high) / 2;
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        //合并
        merge(arr,low,mid,high);
    }

    public static void merge(int[] arr ,int low ,int mid,int high){
        int s1 = low;
        int s2 = mid + 1;
        int[] tmp = new int[high - low + 1];
        //数组下标
        int k = 0;
        while (s1 <= mid && s2 <= high){
            if(arr[s1] <= arr[s2]){
                tmp[k++] = arr[s1++];
            }else {
                tmp[k++] = arr[s2++];
            }
        }
        while (s1 <= mid){
            tmp[k++] = arr[s1++];
        }
        while (s2 <= high){
            tmp[k++] = arr[s2++];
        }
        System.arraycopy(tmp, 0, arr, low, tmp.length);
    }

    public static  void mergeSort(int[] arr){
        mergeSortInternal(arr,0,arr.length -1);
    }



    //快速排序非递归
    public static void quickSort1(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;
        int piv = pivot(arr,low,high);
        if(piv > low + 1){
            stack.push(low);
            stack.push(piv -1);
        }
        if(piv < high - 1){
            stack.push(piv + 1);
            stack.push(high);
        }
        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();
            piv = pivot(arr,low,high);
            if(piv > low + 1){
                stack.push(low);
                stack.push(piv -1);
            }
            if(piv < high - 1){
                stack.push(piv + 1);
                stack.push(high);
            }
        }
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
