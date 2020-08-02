package medium.backTrace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumber17 {
    List<String> result = new LinkedList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0) return result;
        
        HashMap<Character, String> map =new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        helper(digits.toCharArray(), 0, map, new char[digits.length()]);
        return result;
    }

    public void helper(char[] array, int i, HashMap<Character, String> map, char[] res){
        if( i==array.length ){
            String s = new String(res);
            result.add(s);
            return;
        }
        String str = map.get(Character.valueOf(array[i]));
        char[] strArray = str.toCharArray();
        for( char c : strArray){
            res[i] = c;
            helper(array, i+1, map, res);
        }
    }
}
