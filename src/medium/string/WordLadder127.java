package medium.string;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(2);
        queue.add(1);
        boolean a = queue.remove(2);
        System.out.println(a);
//        String begin = "leet";
//        String end = "code";

        String begin = "hit";
        String end = "cog";

        LinkedList<String> list = new LinkedList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

//        list.add("leet");
//        list.add("code");
//        list.add("lose");
//        list.add("code");
//        list.add("lode");
//        list.add("robe");
//        list.add("lost");
//        System.out.println(new WordLadder127().ladderLength(begin,end,list));
        System.out.println(new WordLadder127().ladderLength(begin, end, list));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        wordList.add(beginWord);
        if( !wordList.contains(endWord) ) return 0;
        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i), find(wordList, wordList.get(i) ));
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 1;
        Set<String> visited =new HashSet<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0;i< size;i++){
                String cur = queue.poll();
                if (visited.contains(cur)) continue;
                List<String> nexts = map.get(cur);
                if (nexts.contains(endWord)) return step+1;
                visited.add(cur);
                nexts.removeAll(visited);
                queue.addAll(nexts);
            }
            step++;
        }
        return 0;
    }

    public List<String> find(List<String> wordList, String begin){
        int index = wordList.indexOf(begin);
        List<String> res = new LinkedList<>();
        char[] array = begin.toCharArray();
        for(int s = index+1;s< wordList.size();s++){
            String word = wordList.get(s);
            int dif = 0;
            char[] cur = word.toCharArray();
            for (int i =0;i<cur.length;i++){
                if (cur[i] != array[i]) dif++;
                if (dif == 2) break;
            }
            if (dif == 1) res.add(word);
        }
        return res;
    }







    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        if(!words.contains(endWord)) {
            return 0;
        }
        return biBFS(beginSet, endSet, words, 1);
    }

    private int biBFS(Set<String> beginSet, Set<String> endSet, Set<String> words, int length) {
        if(beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }

        if(beginSet.size() > endSet.size()) {
            return biBFS(endSet, beginSet, words, length);
        }

        Set<String> nextSequence = new HashSet<>();
        words.removeAll(beginSet);

        for(String word : beginSet) {

            char[] chars = word.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                char currentChar = word.charAt(i);

                for(char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String nextWord = new String(chars);

                    if(!words.contains(nextWord)) {
                        continue;
                    }

                    if(endSet.contains(nextWord)) {
                        return length + 1;
                    }
                    nextSequence.add(nextWord);
                }
                chars[i] = currentChar;
            }
        }

        if(!nextSequence.isEmpty()) {
            return biBFS(nextSequence, endSet, words, length + 1);
        }else {
            return 0;
        }
    }

    private void swap(Set<String> set1, Set<String> set2) {
        Set<String> set = set1;
        set1 = set2;
        set2 = set;
    }

}
