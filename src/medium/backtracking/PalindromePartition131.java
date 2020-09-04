package medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartition131 {
    List<List<String>> result = new LinkedList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return result;
        helper(s,0,new LinkedList<String>());
        return result;
    }

    public void helper(String s, int start, LinkedList<String> list){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                list.add( s.substring(start,i+1));
                helper(s,i+1,list);
                list.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start,int end){
        if(start>end) return false;
//  此处如果多次用s.toCharArray()反而很慢
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
