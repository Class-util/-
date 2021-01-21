package Day09;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 21
 * Time:16:39
 */
public class Test01 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("吴博","网络二班",95);
        Student s2 = new Student("向仁义","网络二班",95);
        Student s3 = new Student("赵峰","网络二班",95);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println(list);
        Iterator<Student> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        List<Integer> list1  = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(7);
        list1.add(1);
        Collections.sort(list1);
        System.out.println(list1);
    }
}
