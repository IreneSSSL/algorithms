package medium.string;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {

        String begin = "leet";
        String end = "code";
        LinkedList<String> list = new LinkedList<>();
        list.add("lest");
        list.add("leet");
        list.add("lose");
        list.add("code");
        list.add("lode");
        list.add("robe");
        list.add("lost");
//        System.out.println(new WordLadder127().ladderLength(begin,end,list));
        System.out.println(new WordLadder127().ladderLength(begin, end, list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        Map<String, Set<String>> map = new HashMap<>();
        int step = 1;

        String current = beginWord;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String str = iterator.next();
                    if (compare(current, str)) {
                        if (str.equals(endWord)) return step;
                        queue.add(str);
                        iterator.remove();
                    }
                }
            }
        }
        return 0;
    }

    public boolean compare(String a, String b) {
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();

        int[] aC = new int[cha.length];

        int nonzeroCnt = 0;
        for (int i = 0; i < cha.length; i++) {
            aC[i] = cha[i] - chb[i];
            if (aC[i] != 0) nonzeroCnt++;
            if (nonzeroCnt > 1) return false;
        }
        if (nonzeroCnt == 0) return false;
        return true;
    }
}
