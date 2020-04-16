package medium.string;

import java.util.*;

public class GroupAnagrams49 {


//    每个字符用一个质数表示，保证一个积只能有固定的3个数字组成
//    精妙的数学解法
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();

        HashMap<Integer, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101
        };

        for (String s : strs) {
            int score = score(s, primes);
            List<String> list = map.get(score);
            if (list == null){
                list = new ArrayList<>();
                map.put(score, list);
                res.add(list);
            }
            list.add(s);
        }
        return res;
    }

    private int score(String s, int[] primes) {
        int score = 1;
        for (char c : s.toCharArray()){
            score *= primes[c-'a'];
        }
        return score;
    }


//    slower solution
    HashMap<String, List<String>> map = new HashMap<>();
    List<List<String>> list = new LinkedList<>();
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs==null) return list;
        if (strs.length == 0) return list;
        for(int i=0;i< strs.length;i++){
            char[] c =strs[i].toCharArray();
            Arrays.sort(c);
            String s = strs[i];
            List<String> group = map.get(String.valueOf(c)) == null ? new LinkedList<String>() : map.get(String.valueOf(c)) ;
            group.add(s);
            map.put(String.valueOf(c), group);
        }
        if (map.size() == 0) return list;
        for (String title: map.keySet()){
            list.add(map.get(title));
        }
        return list;
    }
}
