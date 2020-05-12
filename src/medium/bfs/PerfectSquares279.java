package medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares279 {

    public static void main(String[] args) {
       System.out.println( new PerfectSquares279().numSquares(12));
    }
    public int numSquares(int n) {
        if(n <=1) return n;

        int len = (int)Math.sqrt(n);
        if (len * len == n) return 1;

        int[] squares = new int[len+1];
        boolean[] visited = new boolean[n];
        for (int i=1;i<len+1;i++){
            squares[i] = i*i;
        }

        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i=0;i<size;i++){
                int current = queue.poll();
                for(int j=len;j>0;j--){
                    if(squares[j] > current) continue;
                    if (squares[j] == current) return step;

                    if(visited[current - squares[j]]) continue;
                    queue.add(current - squares[j]);
                    visited[ current - squares[j] ] = true;
                }
            }
        }
        return step;
    }

}
