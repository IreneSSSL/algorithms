package medium.array;

public class ValidSudoku36 {
    public static void main(String[] args) {
        char[][] s = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new ValidSudoku36().isValidSudoku(s));
    }


//    another implementation of int array. sometimes, using index of array could help improve efficiency a lot.
//    for each iteration, we new an int array {0,0,0,0,0,0,0,0,0,0}
//    array[i] ==0 means number i nerver appears. array[i] ==1 means i appeared once
    public boolean isValidSudoku(char[][] board) {
        int[] nums = new int[10];
        for (int i= 0;i<9;i++){
            nums = new int[10];
            for (int j= 0;j<9;j++){
                if (board[i][j] != '.'){
                    if (nums[Character.getNumericValue(board[i][j])] == 0 ){
                        nums[Character.getNumericValue(board[i][j])] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int j= 0;j<9;j++){
            nums = new int[10];
            for (int i= 0;i<9;i++){
                if (board[i][j] != '.'){
                    if (nums[Character.getNumericValue(board[i][j])] == 0 ){
                        nums[Character.getNumericValue(board[i][j])] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i= 0;i<3;i++){
            for (int j= 0;j<3;j++){
                nums = new int[10];
                for (int row = i*3; row < i*3+3;row++){
                    for (int column = j*3; column < j*3+3;column++){
                        if (board[row][column] != '.'){
                            if (nums[Character.getNumericValue(board[row][column])] == 0 ){
                                nums[Character.getNumericValue(board[row][column])] = 1;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;

    }
   }
