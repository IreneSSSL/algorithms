package hard.dp;

public class MaxSumOfRectangleNoLargerThanK363 {

    public static void main(String[] args) {
        int[][] a= {{2,2,-1}};
        System.out.println(new MaxSumOfRectangleNoLargerThanK363().maxSumSubmatrix(a,0));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            int[] sum = new int[row];
            for (int j = i; j < col; j++) {
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][j];
                }
                int curr = 0;
                int max = sum[0];
                for (int n : sum) {
                    curr = Math.max(n, curr + n);
                    max = Math.max(curr, max);
                    if (max == k) return max;
                }
                if (max < k) {
                    res = Math.max(max, res);
                } else {
                    for (int a = 0; a < row; a++) {
                        int currSum = 0;
                        for (int b = a; b < row; b++) {
                            currSum += sum[b];
                            if (currSum <= k) res = Math.max(currSum, res);
                        }
                    }
                    if (res == k) return res;
                }
            }
        }
        return res;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        if(matrix.length == 0) return 0;
        int count = matrix[0][0]<= k? matrix[0][0] : Integer.MIN_VALUE ;
        int[][] sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for(int i =1;i< sum[0].length;i++){
            sum[0][i] = sum[0][i-1]+matrix[0][i];
            if (sum[0][i] <= k){
                count = Math.max(sum[0][i], count);
            }
            for(int l = 0;l<i;l++){
                if (sum[0][i]-sum[0][l] <= k){
                    count = Math.max(sum[0][i]-sum[0][l], count);
                }
            }

        }
        for(int i=1;i<sum.length;i++){
            sum[i][0] = sum[i-1][0]+matrix[i][0];
            if (sum[i][0] <= k){
                count = Math.max(sum[i][0], count);
            }
            for(int l = 0;l<i;l++){
                if (sum[i][0]-sum[l][0] <= k){
                    count = Math.max(sum[i][0]-sum[l][0], count);
                }
            }
        }



        for(int i=0;i<sum.length;i++){
            for(int j=0;j<sum[0].length;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1] -sum[i-1][j-1]+matrix[i][j];
                for (int s=0;s<i;s++){
                    for (int l=0;l<j;l++){
                        int tmp =0 ;
                        if (s==0 && l==0){
                            tmp = sum[i][j];
                        }else if (s == 0 ){
                            tmp = sum[i][j]-sum[i][l-1];
                        } else if (l==0){
                            tmp = sum[i][j]-sum[s-1][j];
                        } else{
                            tmp = sum[i][j] -sum[s-1][j]-sum[i][l-1] + sum[s-1][l-1];
                        }
                        if (tmp <= k){
                            count = Math.max(tmp, count);
                        }
                    }
                }


            }
        }
        return count;
    }
}
