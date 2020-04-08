package medium.array;

public class NumberOfIslands200 {

    public static void main(String[] args) {
        char[][] c= new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        new NumberOfIslands200().numIslands(c);
    }

//    this problem cannot solved by dp, instead dfs is a good idea.
//    when finding an island, try to figure out its outline
    public int numIslands(char[][] grid) {
        char[][] dup = grid;
        int cnt = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if (dup[i][j] == '1'){
                    dfs(dup, i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] dup, int i,int j){
        if (i< 0 || i>= dup.length || j<0 || j>=dup[0].length || dup[i][j] == '0') return;
        dup[i][j] = '0';
        dfs(dup,i-1,j);
        dfs(dup,i+1,j);
        dfs(dup,i,j+1);
        dfs(dup,i,j-1);
    }
}
