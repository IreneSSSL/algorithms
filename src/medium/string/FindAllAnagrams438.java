package medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagrams438 {


//    我的解法，非常慢，因为runtime ≈ s.length * p.length；
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> list = new LinkedList<>();

        if (s==null || p == null ){
            return list;
        }
        if (s.length() == 0 || p.length()==0 ||
                s.length() < p.length() ){
            return list;
        }

        char[] cs= p.toCharArray();
        Arrays.sort(cs);
        String newp = new String(cs);

        int len = p.length();
        char[] chars = s.toCharArray();
        for (int i=0; i<= chars.length-len;i++){
            String sub = s.substring(i,i+len);
            char[] subSort = sub.toCharArray();
            Arrays.sort(subSort);
            sub = new String(subSort);
            if ( sub.equals(newp)) list.add(i);
        }
        return list;
    }


//    THE BEST

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] count = new int[256];
        int[] count2 = new int[256];
        for (char c : p.toCharArray()) {
            count[c]++;
        }

        int i = 0;
        int ns = s.length(), np = p.length();
        while (i <= ns - np) {
            char c = s.charAt(i);
            if (count[c] == 0) {
                i++; continue;
            }
            int j = 0;
            for (char c1 = 'a'; c1 <= 'z'; c1++) {
                count2[c1] = 0;
            }
            while (j < np) {
                c = s.charAt(i+j);
                if (++count2[c] > count[c]) {
                    if (count[c] == 0) {
                        i += j;
                    }
                    break;
                }
                j++;
            }
            if (j == np) {
                result.add(i);

//                最精妙的地方
//                p: abc
//                s: aeabcabcabc
//                首先找到了第一组abc，在index=2的地方。
//                然后判断 如果即将去掉的第一个和即将加入的新的那一个 相等
//                那么去掉一个再加上一个之后，还是成立，就不用判断上面的过程了
                while (i < ns-np && s.charAt(i) == s.charAt(i+np)) {
                    i++; result.add(i);
                }
            }
            i++;
        }
        return result;
    }


}
