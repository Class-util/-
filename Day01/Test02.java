package Day01;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2020 12 13
 * Time:16:40
 */
public class Test02 {
    public static void main(String[] args) {
        int[][] array = new int[][]{{2,3},{4,5}};
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println(Arrays.deepToString(array));
    }
}
