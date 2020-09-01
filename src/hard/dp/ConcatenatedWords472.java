package hard.dp;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords472 {


    class TrieNode{
        TrieNode[] nexts ;
        boolean end;
        public TrieNode(){
            nexts = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String[] a = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        new ConcatenatedWords472().findAllConcatenatedWordsInADict(a);
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = new TrieNode();
        int index = 0;
        ArrayList<char[]> array = new ArrayList<>();
        for(String word : words){
            array.add(word.toCharArray());
        }
        boolean last= false;

        TrieNode cur = root;
        for(char[] chs : array){
            cur = root;
            for(int i=0;i<chs.length;i++){
                char c = chs[i];
                if ( cur.nexts[c-'a'] == null) {
                    cur.nexts[c-'a'] = new TrieNode();
                }
                if (i==chs.length-1) cur.nexts[c-'a'].end = true;
                cur =cur.nexts[c-'a'];
            }
        }

        for(char[] chs : array){
            cur = root;
            int cnt = 0;
            for(int i=0;i<chs.length;i++){
                char c = chs[i];
                cur = cur.nexts[c-'a'];
                if (cur == null) break;
                if (cur.end){
                    cnt++;
                }
                cur = root;
            }
        }
        return null;


    }
}
