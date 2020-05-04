package hard.backtracing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens51 {
    LinkedList<List<String>> result = new LinkedList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        if (n ==0) return new LinkedList<List<String>>();

        char[][] re = new char[n][n];
        for (char[] row : re){
            Arrays.fill(row, '.');
        }
        helper(re, 0, n);
        return result;
    }

    public void helper(char[][] re, int start, int n){
        if ( start == n ){
            List<String> string = new LinkedList<>();
            for (int i=0;i<n;i++){
                string.add(String.valueOf(re[i]));
            }
            result.add(string);
            return;
        }

        for (int j= 0;j< n;j++){
            re[start][j] = 'Q';
            if (unconflict(re, start,j)){
                helper(re, start+1, n);
            }
            re[start][j] = '.';
        }

    }

    public boolean unconflict(char[][] re, int i, int j){
        if (i == 0) return true;
        for (int l=0;l<i;l++){
            if ( re[l][j] == 'Q') return false;
            if ((j-1-l)>=0 && (i-1-l)>=0 && re[i-1-l][j-l-1] == 'Q') return false;
            if ( (j+1+l)< re.length && (i-1-l)>=0 && re[i-1-l][j+l+1] == 'Q') return false;
        }
        return true;

    }
}
