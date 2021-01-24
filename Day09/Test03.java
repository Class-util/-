package Day09;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 01 24
 * Time:15:46
 */
public class Test03 {
    public static void main(String[] args) {
        String str  = "({[]})";
        boolean b = isValid(str);
        System.out.println(b);
    }
    public static boolean isValid(String s) {
        if(s == null)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char topch = stack.peek();
                if(topch == '{' && ch == '}' || topch == '(' && ch == ')' || topch == '[' && ch == ']'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
