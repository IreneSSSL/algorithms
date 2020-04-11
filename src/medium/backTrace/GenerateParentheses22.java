package medium.backTrace;

import java.util.*;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }


//  this is a different backtracing problem to me.
//    you dont need to add and remove
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);  // if current '(' is less than the target '('  count, just add it.
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);  // if current '(' count is more than ')' count, just add ')' to close the '('
    }

}