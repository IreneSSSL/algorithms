package medium.bfs;

import java.util.Arrays;

public class Matrix542 {
    public static void main(String[] args) {
        int[][] a = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        for(int i=0;i<10;i++){
            System.out.println();
            for (int j=0;j<10;j++){
                System.out.print(" " + a[i][j]);
            }
        }
        int[][] b= new Matrix542().updateMatrix(a);
        System.out.println("[-------");
        for(int i=0;i<10;i++){
            System.out.println();
            for (int j=0;j<10;j++){
                System.out.print(" " + b[i][j]);
            }
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int index=1;

        boolean flag = true;

        while(flag) {
            flag = false;
            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix[i].length; j++) {
                    if (matrix[i][j] == index) {
                        int min = Integer.MAX_VALUE;

                        if (i > 0 && matrix[i-1][j] < min) min = matrix[i-1][j];
                        if (i+1 < matrix.length && matrix[i+1][j] < min)min = matrix[i+1][j];
                        if (j > 0 && matrix[i][j-1] < min) min = matrix[i][j-1];
                        if (j + 1 < matrix[0].length && matrix[i][j+1] < min)min = matrix[i][j+1];
                        if (min != matrix[i][j] - 1) {
                            matrix[i][j] = matrix[i][j] + 1;
                            flag = true;
                        }
                    }
                }
            }
            index++;
        }
        return matrix;
    }


    public int[][] updateMatrix2(int[][] matrix) {
        int[][] bfs = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < bfs.length; i++) {
            Arrays.fill(bfs[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < bfs.length; i++) {
            for (int j = 0; j < bfs[0].length; j++) {
                if (matrix[i][j] == 0) {
                    bfs[i][j] = 0;
                    helper(matrix, bfs, i+1, j, 1);
                    helper(matrix, bfs, i, j+1, 1);
                    helper(matrix, bfs, i-1, j, 1);
                    helper(matrix, bfs, i, j-1, 1);
                }
            }
        }
        return bfs;
    }

    public void helper(int[][] matrix, int[][] bfs, int i, int j, int step) {
        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length) return;
        if (matrix[i][j] == 0) return;
        if (bfs[i][j] > step) {
            bfs[i][j] = step;
            helper(matrix, bfs, i + 1, j, step + 1);
            helper(matrix, bfs, i , j - 1, step + 1);
            helper(matrix, bfs, i-1, j, step + 1);
            helper(matrix, bfs, i, j + 1, step + 1);
        }
    }
}
