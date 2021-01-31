package Day10;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 31
 * Time:12:19
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {9,8,6,5,4};
        func(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void func(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            for (; j >= 0 ; j--) {
                if(arr[j] > tmp){
                    arr[j +1] = arr[j];
                }else {
                    //arr[j + 1] = tmp;
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }
}
