package medium.dp;

import medium.segmenttree.RangeSumQuery307;

public class RangeSum2D304 {

    public static void main(String[] args) {
        int[][] a = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        System.out.println(new RangeSum2D304(a).sumRegion(2, 1, 4, 3));
    }

    ;

    int[][] sum;

    public RangeSum2D304(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) sum[0][i] = sum[0][i - 1] + matrix[0][i];
        for (int i = 1; i < matrix.length; i++) sum[i][0] = sum[i - 1][0] + matrix[i][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sum[i][j] = -sum[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j]+ matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0)
            return sum[row2][col2];
        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        }
        if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }
}
