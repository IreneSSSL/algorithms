package easy.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FirstUniqChar387 {
    public int firstUniqChar(String s) {
        if (s == null || s.length() ==0) {
            return -1;
        }
        HashSet<Character> repeated = new HashSet<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character cha = (Character) s.charAt(i);
            if (repeated.contains(cha)) {
                continue;
            }
            if (map.keySet().contains(cha)) {
                map.remove(cha);
                repeated.add(cha);
            } else {
                map.put(cha, i);
            }
        }
        if(repeated.size() == 0){
            return 0;
        }
        if( map.size() == 0) {
            return -1;
        }

        Iterator<Character> iter= map.keySet().iterator();
        int smallest = Integer.MAX_VALUE;
        while (iter.hasNext()){
            smallest = Math.min(smallest, map.get(iter.next()));
        }
        return  smallest;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar387().firstUniqChar("loveleetcode"));
    }
}
