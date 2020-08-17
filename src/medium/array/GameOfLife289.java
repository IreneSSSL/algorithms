package medium.array;

public class GameOfLife289 {

    public static void main(String[] args) {
//        int[][] b = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] b={{1}};
        new GameOfLife289().gameOfLife(b);
    }
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return ;
        int row = board.length;
        int col = board[0].length;

        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int sum = 0;
                int leftup= i-1>=0 && j-1>=0 ? board[i-1][j-1] :0;
                int up =i-1>=0 ? board[i-1][j]:0;
                int rightup=i-1>=0 && j+1<col ? board[i-1][j+1] :0;
                int left=j-1>=0 ? board[i][j-1] : 0;
                int right=j+1<col? board[i][j+1] :0 ;
                int leftdown = i+1< row && j-1>=0 ? board[i+1][j-1] :0;
                int down= i+1< row? board[i+1][j] :0;;
                int rightdown= i+1< row && j+1<col ? board[i+1][j+1] :0;
                sum += leftup/10+up/10+rightup/10
                        + left/10 + right
                        + leftdown+down+rightdown;
                if (sum <2){
                    board[i][j] =  board[i][j] *10;
                }else if (sum == 2){
                    board[i][j] =  board[i][j] *10 +board[i][j];
                }else if (sum == 3){
                    board[i][j] =  board[i][j] *10 + 1;
                } else {
                    board[i][j] =  board[i][j] *10;
                }
            }
        }

        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] = board[i][j] %10;
            }
        }
        System.out.println(board.length);
    }
}
