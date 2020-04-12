package hard.dp;

import java.util.Stack;

public class LongestValidParenthese32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.trim().length()<=1) return 0;
        Stack<Integer> stack= new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        int current = 0;
        for(int i= 0;i<s.length();i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    stack.pop();
                    if (stack.isEmpty()) {stack.push(i);}  // stack的顶部 存储的是当前i往前数，能valid的substring的最开头位置
                    current = i- stack.peek();
                    max = Math.max(max, current);
                }else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

}
