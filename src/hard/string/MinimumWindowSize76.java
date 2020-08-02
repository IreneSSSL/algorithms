package hard.string;

import medium.dp.MaximumProductSubarray152;

import java.util.*;

public class MinimumWindowSize76 {

    public static void main(String[] args) {
//        String S = "ADOBECODEBANC";
        String S = "ADOABC";
        String T = "ABC";
        System.out.println(new MinimumWindowSize76().minWindow(S, T));
    }


    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

//      start with 2 pointers, the initial sliding window is empty
        int finalLeft = 0;
        int finalRight = s.length();
//       construct a validation method
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }


        int left = 0;
        int right = 0;
        char[] sc = s.toCharArray();
        int count = t.length();
        for (int i = 0;i< s.length();i++){
            char ch = sc[i];
            if (map.get(ch) != null ) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) >= 0) count--;
            }

            right = i;
            while ( count == 0 && left <= right){
                if (finalRight- finalLeft > right-left){
                    finalLeft = left;
                    finalRight = right;
                }
                if ( map.containsKey(sc[left])){
                    map.put(sc[left], map.get(sc[left])+1);
                    if (map.get(sc[left]) > 0) count++;
                }
                left++;
            }
        }
        return s.substring(finalLeft, finalRight+1);
    }




}
