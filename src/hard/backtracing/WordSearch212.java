package hard.backtracing;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearch212 {

    public static void main(String[] args) {

        char[][] chars = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}} ;
        String[] strings = {"oath","pea","eat","rain"};
        List<String> result = new WordSearch212().findWords(chars, strings);
        System.out.println();
    }
    Set<String> result = new HashSet<>();
    TrieNode root = new TrieNode();
    boolean[][] isVisited;
    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);
        int width = board[0].length;
        int depth = board.length;
        isVisited = new boolean[depth][width];
        for(int i = 0; i< depth;i++){
            for(int j =0;j<width;j++){
                helper(board, root, i,j);
            }
        }
        return new LinkedList<>(result);
    }

    public void helper(char[][] board, TrieNode node, int x, int y){
        if(x== board.length || y == board[0].length) return;
        if (x<0 || y<0) return;
        if (!isVisited[x][y]){

            TrieNode s = node.children[board[x][y]-'a'];
            if ( node.children[board[x][y]-'a'] != null ){
                if (node.children[board[x][y]-'a'].isWord){
                    result.add(node.children[board[x][y]-'a'].str);
//                    return; 此处不可以返回，因为可能当前string是一个更长的string的子集
                }
                isVisited[x][y] = true;
                s = node.children[board[x][y]-'a'];
                helper(board, node.children[board[x][y]-'a'], x+1, y);
                helper(board, node.children[board[x][y]-'a'], x, y+1);
                helper(board, node.children[board[x][y]-'a'], x-1, y);
                helper(board, node.children[board[x][y]-'a'], x, y-1);
                isVisited[x][y] = false;
            }
        }
    }


    public void buildTrie(String[] words){
        for (String word : words){
            TrieNode ws = this.root;
            char[] array = word.toCharArray();
            for (char c : array){
                if (ws.children[c-'a'] == null){
                    ws.children[c-'a'] = new TrieNode();
                }
                ws = ws.children[c-'a'];
            }
            ws.isWord = true;
            ws.str = word;
        }
    }

    public class TrieNode{
        String str;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
        }
    }

}
