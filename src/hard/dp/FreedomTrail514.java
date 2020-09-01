package hard.dp;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

public class FreedomTrail514 {
    public static void main(String[] args) {
        System.out.println(new FreedomTrail514().findRotateSteps("godding",
                "gd"));
    }

    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][ring.length()];

//        dp[i][j] stores the shortest steps from i to j
        int s = 1, end = ring.length() - 1;
        int step = 1;
        while (s <= end) {
            dp[0][s++] = step;
            dp[0][end--] = step++;
        }
        for (int i = 1; i < ring.length(); i++) {
            for (int j = 0; j < ring.length(); j++) {
                int left = j - 1 >= 0 ? j - 1 : ring.length() - 1;
                dp[i][j] = dp[i - 1][left];
            }
        }

//        indice stores the indice of character in ring.
//        eg. indice[0]  :{1,3} means ring.charAt(1) == 'a' and  ring.charAt(3) == 'a'
        List<Integer>[] indice = new List[26];
        char[] rings = ring.toCharArray();
        for (int i = 0; i < rings.length; i++) {
            if (indice[rings[i] - 'a'] == null) indice[rings[i] - 'a'] = new LinkedList<Integer>();
            indice[rings[i] - 'a'].add(i);
        }


        Integer[] pre = new Integer[ring.length()];
        Integer[] current = new Integer[ring.length()];

        pre[0]= 0;
        int index = 0;
        char[] array = key.toCharArray();

        int min = Integer.MAX_VALUE;
//        bfs :
//        pre stores the possible solutions for key.substring(0,index+1), which ends at different indice.
//        specifically, if there are 3 's' in ring, and key.substring(0,index+1) is ended with 's'.
//        there would be 3 solutions in pre, representing 3 different solutions that end in 3 different 's'.
        while (index < array.length) {
            char next = array[index];
            for (int i = 0;i< pre.length;i++) {
                if (pre[i] == null) continue;
                int start = i;
                int len = pre[i];
                List<Integer> ins = indice[next - 'a'];
                for (Integer L : ins) {
                    if (current[L] == null) current[L]= dp[start][L] + len;
                    if (current[L] > dp[start][L] + len) current[L]= dp[start][L] + len;
                }
            }
            index++;
            for (int i=0;i<current.length;i++) pre[i] = current[i];
            Arrays.fill(current, null);
        }

        for (int i=0;i<pre.length;i++) {
            if (pre[i]==null) continue;
            int len = pre[i];
            min = Math.min(min, len);
        }
        return min + key.length();
    }
}
