package medium.dp;

public class MaximalSquare221 {

    public static void main(String[] args) {
        char[][] a = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
//        char[]{] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','1','1','1'}};
        new MaximalSquare221().maximalSquare(a);

    }

    public int maximalSquare(char[][] matrix) {
        if (matrix .length == 0 || matrix[0].length == 0) return 0; // []  [[]]
        if (matrix.length == 1 ){
            for(int i= 0;i< matrix[0].length;i++){
                if (matrix[0][i] == '1') return 1;
            }
            return 0;
        }
        int max = 0;
        if (matrix[0].length == 1 ){
            for(int i= 0;i< matrix.length;i++){
                if (matrix[i][0] == '1') return 1;
            }
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 && j==0){
                    dp[i][j] = matrix[0][0] - 48;
                }else if(matrix[i][j] == '0' ){
                    if(j == 0){
                        dp[i][j] = dp[i-1][dp[0].length-1];
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                } else {
                    if( i == 0 ){
                        dp[i][j] = 1;
                    } else if (j == 0){
                        dp[i][j] = Math.max( 1,dp[i-1][dp[0].length-1] );   //之前都是0，在第一列里面出了第一个1
                    } else {
                        int length = 2;
                        boolean keep = true;
                        while (keep){
                            if (i-length < -1 || j-length<-1) break;
                            for(int s = 0;s< length ;s++){
                                if(matrix[i-length+1][j-s] != '1' ) {
                                    keep = false;
                                    break;
                                }
                            }
                            if (!keep) break;
                            for (int s= 0 ;s < length-1;s++){
                                if(matrix[i-s][j-length+1] !='1' ) {
                                    keep = false;
                                    break;
                                }
                            }
                            if (!keep) break; // 上面的行都是1，但是左边列出现了0的情况；否则会继续length++
                            length++;
                        }
                        length--;
                        max = Math.max(max, length);
                        dp[i][j] = max;
                    }
                }

            }
        }
        // System.out.println(dp[matrix.length-1][matrix[0].length-1]);
        return dp[matrix.length-1][matrix[0].length-1] *dp[matrix.length-1][matrix[0].length-1];
    }

    // l=2 i-1,j-1
//     i-1,j-0
//     i-0,j-1


// l=3 i-0,j-2
//     i-1,j-2
//     i-2,j-2
//     i-2,j-1
//     i-2,j-0

// l=4 i-0,j-3
//     i-1,j-3
//     i-2,j-3
//     i-3,j-0
//     i-3,j-1
//     i-3,j-2
//     i-3,j-3

// 11111111
// 11111110
// 11111110
// 11111000 (4,3)
// 01111000

}
