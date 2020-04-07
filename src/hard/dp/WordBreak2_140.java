package hard.dp;

import java.util.*;

public class WordBreak2_140 {


    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> a = new LinkedList<>();
        a.add("cats");
        a.add("dog");
        a.add("sand");
        a.add("and");
        a.add("cat");
        new WordBreak2_140().wordBreak(s,a);
    }

// 这道题基于139题，先用dp统计，这个string是不是valid，如果不valid直接返回空list（这步骤最开始忘了）
//    然后用一个map存储当string结束在第i个时候，有哪些segment是可用的，
//    然后用backtracing方法，从string的尾巴开始拼。
//    从map读出拼出string的尾巴的n个segment，然后去map读出sub.length -{current segment.length}的segment们，
//    重复知道sub长度为0
    List<String> result = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> index2Seg = new HashMap<>();
        boolean[] dp = new boolean[s.length()];
        for (int i = 0;i<s.length();i++){
            for(String seg: wordDict){
                String sub = s.substring(0,i+1);
                if (sub.endsWith(seg)){
                    if ( i-seg.length()  == -1 || (i-seg.length()>-1 && dp[i-seg.length()])){
                        dp[i] = true;
                        List<String> list = index2Seg.get(i)!=null ? index2Seg.get(i): new LinkedList<>();
                        list.add(seg);
                        index2Seg.put(i,list);
                    }
                }
            }
        }
        if(!dp[dp.length-1]) return result;  // not valid s
        helper(index2Seg, new LinkedList<String>(), s.length()-1);
        return result;
    }

    public void helper(Map<Integer, List<String>> index2Seg,  LinkedList<String> current, int tail){
        if (tail < 0){
            Collections.reverse(current);
            String re = "";
            for(String seg : current){
                re += " "+seg;
            }
            result.add(re.substring(1));
            Collections.reverse(current);
            return;
        }
        List<String> list = index2Seg.get(tail);
        for(String seg : list){
            current.add(seg);
            helper(index2Seg, current, tail - seg.length());
            current.remove(current.lastIndexOf(seg)); //
        }
    }




//    this is a faster solution
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n == 0) return res;
        Set<String> dict = new HashSet<>();
        int maxLen = 0;
        for (String word : wordDict) {
            dict.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, true);
        dfs(s, new StringBuilder(), res, dp, dict, maxLen, 0);
        return res;
    }

    private void dfs(String s, StringBuilder tmp, List<String> res, boolean[] dp, Set<String> dict, int maxLen, int depth) {
        if (depth == s.length()) {
            res.add(tmp.toString());
        } else {
            for (int i = depth + 1; i <= Math.min(s.length(), depth + maxLen); i++) {
                if (dp[i]) {
                    String sub = s.substring(depth, i);
                    if (dict.contains(sub)) {
                        int oldLen = tmp.length();
                        if (oldLen != 0) {
                            tmp.append(" ");
                        }
                        tmp.append(sub);
                        int oldSize = res.size();
                        dfs(s, tmp, res, dp, dict, maxLen, i);
                        if (res.size() == oldSize) {
                            dp[i] = false;
                        }
                        tmp.delete(oldLen, tmp.length());
                    }
                }
            }
        }
    }
}
