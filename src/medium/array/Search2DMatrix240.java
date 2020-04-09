package medium.array;

public class Search2DMatrix240 {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 ||matrix[0].length == 0) return false;
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        return helper(matrix, target,0, matrix.length-1, 0);
    }

    public boolean helper(int[][] matrix, int target, int start, int row,int column){
        if(start > row || row == -1 || column == matrix[0].length) return false;


        int targetRow=row;
        int newStart = start;
        for( int i=start;i<=row;i++){
            if(matrix[i][column] == target) return true;
            if (matrix[i][matrix[0].length-1] < target) newStart = i+1;
            if(matrix[i][column] > target) {
                targetRow = i-1;
                break;
            }
        }
        return helper(matrix, target, newStart, targetRow, column+1);
    }

}
