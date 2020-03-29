package medium.array;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return ;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for( int i=0;i< matrix.length;i++){
            // if(rows.size() == matrix.length && columns.size() == matrix[0].length){
            //         break;
            // }
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }

            }
        }
        for(Integer i : rows){
            for(int j=0;j< matrix[0].length;j++){
                matrix[i][j] = 0;
            }
        }

        for(Integer j : columns){
            for(int i=0;i< matrix.length;i++){
                matrix[i][j] = 0;
            }
        }
    }
}
