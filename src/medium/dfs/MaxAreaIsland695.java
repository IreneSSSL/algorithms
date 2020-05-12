package medium.dfs;

public class MaxAreaIsland695 {
    public int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length<1) return 0;
        if(grid[0].length ==0) return 0;

        if(grid.length == 1 && grid[0].length ==1) return grid[0][0];

        int area = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0) continue;
                area = Math.max(area, dfs(grid,i,j));
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int i,int j){
        if(grid[i][j] == 0) return 0;

        int area = 1;
        grid[i][j] =0;
        for(int s=0;s<direction.length;s++){
            int i_n= i + direction[s][0];
            int j_n= j + direction[s][1];
            if (i_n <0|| i_n>=grid.length  ||j_n <0|| j_n>=grid[0].length ) continue;
            area+= dfs(grid, i_n, j_n);
        }
        return area;
    }
}
