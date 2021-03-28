package Day01;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 13
 * Time:14:39
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int i = maxNum(arr);
        System.out.println(i);

        double fun = fun(arr);
        System.out.println(fun);

        boolean b1 = searchNum(arr, 3);
        System.out.println(b1);

        boolean b = searchNum1(arr, 2);
        System.out.println(b);

        fun1(arr);
        System.out.println(Arrays.toString(arr));
    }
    //寻找数组最大值
    public static int maxNum(int[] nums){
        int num = nums[0];
        for (int i : nums) {
            if(i > num)
                num = i;
        }
        return num;
    }
    //数组平均值
    public static double fun(int[] nums){
        double num = 0;
        for (int i : nums) {
            num += i;
        }
        return num/nums.length;
    }
    //查找数组中指定元素
    public static boolean searchNum(int[] nums,int n){
        for (int num : nums) {
            if(n == num)
                return true;
        }
        return false;
    }
    //查找数组中指定元素
    public static boolean searchNum1(int[] nums,int n){
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len -1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] < n){
                left = mid + 1;
            }else {
                if(nums[mid] > n){
                    right = mid - 1;
                }else
                    return true;
            }
        }
        return false;
    }
    //数组逆序
    public static void fun1(int[] nums){
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(i <= j && j > 0){
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
            }
            j--;
        }
    }
}
