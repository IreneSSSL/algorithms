package medium.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new SpiralMatrix54().spiralOrder(a);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new LinkedList<Integer>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        int i =0;
        int upper = matrix.length %2==0? matrix.length/2:  matrix.length/2+1;
        while (i< upper ){
            int row = i;

            int j=i;
            while (i+j<matrix[0].length){
                result.add(matrix[i][j++]);
            }
            j--;
            i++;
            while (i+row<matrix.length ){
                result.add(matrix[i++][j]);
            }
            i--;
            j--;
            if ( result.size() == matrix.length * matrix[0].length) break;
            while (j>=row){
                result.add(matrix[i][j--]);
            }
            j++;
            i--;
            while (i>row){
                result.add(matrix[i--][j]);
            }
            if ( result.size() == matrix.length * matrix[0].length) break;
            i++;
        }
        return result;
    }
}
