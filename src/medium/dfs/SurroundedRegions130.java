package medium.dfs;

public class SurroundedRegions130 {

    public int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if(board.length<1) return ;
        if(board[0].length ==0) return ;

        if(board.length == 1 || board[0].length ==1) return ;

//        这个题说，如果是边上的O，是没法转换成X的。
//        第一想法肯定是去找哪些能变成X的O，但是这个很麻烦，从中间一个点开始找，不一定确定当前这个是不是会触碰到边界。
//        其实换个想法， 从四个边的O开始找，所有和边缘O相连的O，一定是不能转换成x的，那把这些边缘O记录下来
//        然后把剩下的O换成X，就可以了。
        int x=0;
        for(int j=0;j<board[0].length;j++){
            if(board[x][j] !='O') continue;
            helper(board,x,j);
        }
        x=board.length-1;
        for(int j=0;j<board[0].length;j++){
            if(board[x][j]!='O') continue;
            helper(board,x,j);
        }

        int y=0;
        for(int i=0;i<board.length;i++){
            if(board[i][y] !='O') continue;
            helper(board,i,y);
        }
        y=board[0].length-1;
        for(int i=0;i<board.length;i++){
            if(board[i][y] !='O') continue;
            helper(board,i,y);
        }
//

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] ='X';
                }else if(board[i][j]=='S'){
                    board[i][j] ='O';
                }
            }
        }
        return ;
    }

    public void helper(char[][] board, int i,int j){
        if(board[i][j] !='O') return;
        board[i][j]='S';
        for(int s=0;s<direction.length;s++){
            int i_n= i + direction[s][0];
            int j_n= j + direction[s][1];
            if (i_n <0|| i_n>=board.length  ||j_n <0|| j_n>=board[0].length ) continue;
            helper(board,i_n,j_n);
        }
    }
}
