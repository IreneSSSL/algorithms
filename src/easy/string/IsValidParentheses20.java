package easy.string;

import java.util.HashMap;
import java.util.Stack;

public class IsValidParentheses20 {


//    just use stack to solve this problem
//    two occasions :  "){}"  and "(("
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        Stack<Character> stack = new Stack<Character>();
        for (int i=0;i< s.length();i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c=='[' ){
                stack.push(Character.valueOf(c));
            } else {
                if (stack.isEmpty()){
                    return false; // "){}"
                }
                Character left = stack.pop();
                if (!map.get(left).equals( Character.valueOf(c) )){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;   // "(("
        return true;
    }

}
