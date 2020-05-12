package medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath1091 {

    public int[][] direction = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0) return -1;
        int len = grid.length;
        if(len == 1){  // 处理只有一个元素的情况
            if (grid[0][0] == 1) return -1;
            else return 1;
        }
        if(grid[0][0] == 1 || grid[len-1][len-1] == 1) return -1;


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int step=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int i = 0;i<size;i++){
                int[] index = queue.poll();
                for(int x=0; x< 8;x++){
                    int i_n = index[0]+direction[x][0];
                    int j_n = index[1]+direction[x][1];
                    if(i_n<0 || i_n>=len ||j_n<0 || j_n>=len ) continue;
                    if (i_n ==len -1 && j_n == len-1) return step;
                    if (grid[i_n][j_n] == 1) continue;
                    grid[i_n][j_n] = 1;
                    queue.add(new int[]{i_n,j_n});
                }
            }
        }
        return -1;

    }

}
