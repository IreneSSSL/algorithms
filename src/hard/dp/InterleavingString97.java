package hard.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InterleavingString97 {

    public static void main(String[] args) {
        String a = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
        String b = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
        String c = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
        System.out.println(new InterleavingString97().isInterleave(a, b, c));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() == 0) return true;
        if (s1.length() == 0) {
            if (s2.equals(s3)) return true;
            return false;
        }
        if (s2.length() == 0) {
            if (s1.equals(s3)) return true;
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) return false;
        Set<Integer> old = new HashSet<>();
        char[] s1s = s1.toCharArray();
        char[] s2s = s2.toCharArray();
        char[] s3s = s3.toCharArray();
        if (s1s[0] == s3s[0]) {
            old.add(1);
        }
        if (s2s[0] == s3s[0]) {
            old.add(0);
        }

        for (int i = 1; i < s3.length(); i++) {
            if (old.size() == 0) return false;
            char ch = s3s[i];
            HashSet<Integer> current = new HashSet<>();
            for (int index : old) {
                if (index < s1s.length && s1s[index] == ch) {
                    current.add(index + 1);
                }
                if (i - index < s2s.length && s2s[i - index] == ch) {
                    current.add(index);
                }
            }
            old.clear();
            if (current != null && current.size() > 0) {
                old.addAll(current);
            }

        }
        if (old != null && old.size() > 0) return true;
        return false;
    }
}
