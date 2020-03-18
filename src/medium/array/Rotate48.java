package medium.array;

import java.util.HashSet;

public class Rotate48 {
    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Rotate48().rotate(a);
    }


//    [m][n]->[n][len-1-m]
//    rotate top left part(1/4) of the array 4 times, this is a ring route.
//    caution, some elements in top left may be in the ring path of former elements.
    public void rotate(int[][] matrix) {
        if (matrix == null){ return ;}
        int len = matrix[0].length;
        if (len == 1){
            return;
        }
        int half = len % 2 == 0 ? len/2 : len/2 +1;
        HashSet<Integer> dup = new HashSet<Integer>();
        for (int i=0;i<half;i++){
            for(int j = 0;j < half;j++){

                int oldI = i;
                int oldJ = j;
                int newI =j;
                int newJ =len-1-i;
                if(oldI == newI && oldJ == newJ ){
                    break;
                }
                if (newI < half && newJ < half){
                    break;
                }
                int tmpnew = matrix[newI][newJ];
                int tmpold = matrix[oldI][oldJ];
                while ( !(newI == i && newJ == j)){
                    dup.add(oldI *10 + oldJ);
                    tmpnew = matrix[newI][newJ] ;
                    matrix[newI][newJ] = tmpold;
                    tmpold = tmpnew;
                    oldI = newI;
                    oldJ = newJ;
                    newI = oldJ;
                    newJ = len-1-oldI;
                }
                matrix[newI][newJ] = tmpold;
            }
        }
    }

}
