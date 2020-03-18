package easy.string;

import java.util.HashMap;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (t == null || t.length() == 0){
            return true;
        }
        if(s == null){
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        int[] source = new int[26];
        for (int i=0;i< s.length();i++){
            source[s.charAt(i) - 'a'] ++;
        }
        for (int i =0 ;i< t.length(); i++){
            source[t.charAt(i)-'a'] -- ;
            if (source[t.charAt(i)-'a'] < 0 ){
                return false;
            }
        }
        return true;
    }



//    this is what I did first. But apparently, using a hashmap is more time-consuming than using an int array
    public boolean isAnagram2(String s, String t) {
        if (t == null || t.length() == 0){
            return true;
        }
        if(s == null){
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Integer> source = new HashMap<Character,Integer>();
        for (int i=0;i< s.length();i++){
            Character c = Character.valueOf(s.charAt(i));
            if(source.get(c)==null) {
                source.put(c,1);
            } else {
                source.put (c, source.get(c) +1);
            }

        }
        for (int i =0 ;i< t.length(); i++){
            Character c = Character.valueOf(t.charAt(i));
            Integer cnt = source.get(c);
            if ( cnt == null || cnt == 0){
                return false;
            } else {
                if(cnt ==1){
                    source.remove(c);
                }else{
                    source.put(c, cnt - 1);
                }

            }
        }
        if (source == null || source.size() == 0){
            return true;
        }
        return false;
    }
}
