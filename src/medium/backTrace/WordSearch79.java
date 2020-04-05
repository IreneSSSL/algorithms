package medium.backTrace;

public class WordSearch79 {

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','C'},
//                {'S','F','C','S'},
//        {'A','D','E','E'}};

        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        System.out.println(new WordSearch79().exist2(board, "CAAAC"));
    }


//    In my solution, I used a two-dimensional array to store the path of the word.
//    but it leads to a problem that I dont know in which step current char has been used
//    so I have to check the array every time I find a new fit char.
//    In the smart solution, it used a two-dimensional boolean array, indicating whether the char in [i,j] is used before,
//    saving the time a lot.

    public boolean exist(char[][] board, String word) {
        int[][] path = new int[2][word.length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                path[0][0] = i + 1;
                path[1][0] = j + 1;
                boolean s = helper(board, path, i, j, word, 1);
                if (s) return s;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int[][] path, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(pos)) {
            if (!checkDup(path, i + 2, j + 1,pos)) {
                path[0][pos] = i + 2;
                path[1][pos] = j + 1;
                a = helper(board, path, i + 1, j, word, pos + 1);
                if (a) return true;
            }
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(pos)) {
            if (!checkDup(path, i + 1, j + 2,pos)) {
                path[0][pos] = i + 1;
                path[1][pos] = j + 2;
                b = helper(board, path, i, j + 1, word, pos + 1);
                if (b) return true;
            }
        }

//        可能是个回字形 所以要考虑左转和上转的情况
        if (j - 1 > -1 && board[i][j - 1] == word.charAt(pos)) {
            if (!checkDup(path, i + 1, j,pos)) {
                path[0][pos] = i + 1;
                path[1][pos] = j;
                c = helper(board, path, i, j - 1, word, pos + 1);
                if (c) return true;
            }

        }
        if (i - 1 > -1 && board[i - 1][j] == word.charAt(pos)) {
            if (!checkDup(path, i, j + 1,pos)) {
                path[0][pos] = i;
                path[1][pos] = j + 1;
                d = helper(board, path, i - 1, j, word, pos + 1);
                if (d) return true;
            }

        }
        return a || b || c || d;
    }

    public boolean checkDup(int[][] path, int i, int j, int pos) {
        for (int s = 0; s < pos; s++) {
            if (path[0][s] == i && path[1][s] == j) return true;
        }
        return false;
    }


// this one is faster
    public boolean exist2(char[][] board, String word) {
        boolean[][] occupied = new boolean[board.length][board[0].length];
        return solve(board, occupied, word, 0, -1, -1);
    }

    public boolean solve(char[][] array, boolean[][] occupied, String target, int index, int x, int y) {
        if (index >= target.length())
            return true;
        if (x == -1) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (array[i][j] == target.charAt(index)) {
                        occupied[i][j] = true;
                        if (solve(array, occupied, target, index + 1, i, j)) {
                            return true;
                        }
                        occupied[i][j] = false;
                    }
                }
            }
        } else {
            if (x - 1 > -1 && !occupied[x - 1][y] && array[x - 1][y] == target.charAt(index)) {
                occupied[x - 1][y] = true;
                if (solve(array, occupied, target, index + 1, x - 1, y)) return true;
                occupied[x - 1][y] = false;
            }
            if (x + 1 < array.length && !occupied[x + 1][y] && array[x + 1][y] == target.charAt(index)) {
                occupied[x + 1][y] = true;
                if (solve(array, occupied, target, index + 1, x + 1, y)) return true;
                occupied[x + 1][y] = false;
            }
            if (y - 1 > -1 && !occupied[x][y - 1] && array[x][y - 1] == target.charAt(index)) {
                occupied[x][y - 1] = true;
                if (solve(array, occupied, target, index + 1, x, y - 1)) return true;
                occupied[x][y - 1] = false;
            }
            if (y + 1 < array[0].length && !occupied[x][y + 1] && array[x][y + 1] == target.charAt(index)) {
                occupied[x][y + 1] = true;
                if (solve(array, occupied, target, index + 1, x, y + 1)) return true;
                occupied[x][y + 1] = false;
            }
        }
        return false;
    }


//    this is modified based my own idea, good enough
    public boolean exist3(char[][] board, String word) {
        boolean[][] path = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                path[i][j] = true;
                boolean s = helper(board, path, i, j, word, 1);
                if (s) return s;
                path[i][j] = false;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] path, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        if (i + 1 < board.length && board[i + 1][j] == word.charAt(pos)) {
            if (!path[i+1][j] ) {
                path[i+1][j] = true;
                a = helper(board, path, i + 1, j, word, pos + 1);

                if (a) return true; path[i+1][j] = false;
            }
        }
        if (j + 1 < board[0].length && board[i][j + 1] == word.charAt(pos)) {
            if (!path[i][j+1] ) {
                path[i][j+1] = true;
                b = helper(board, path, i, j + 1, word, pos + 1);

                if (b) return true; path[i][j+1] = false;
            }
        }

//        可能是个回字形 所以要考虑左转和上转的情况
        if (j - 1 > -1 && board[i][j - 1] == word.charAt(pos)) {
            if (!path[i][j-1]) {
                path[i][j-1] = true;
                c = helper(board, path, i, j - 1, word, pos + 1);

                if (c) return true;  path[i][j-1] = false;
            }

        }
        if (i - 1 > -1 && board[i - 1][j] == word.charAt(pos)) {
            if (!path[i-1][j]) {
                path[i-1][j] = true;
                d = helper(board, path, i - 1, j, word, pos + 1);

                if (d) return true;  path[i-1][j] = false;
            }

        }
        return false;
    }
}
