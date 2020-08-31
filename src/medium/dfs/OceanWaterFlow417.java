package medium.dfs;

import java.util.*;

public class OceanWaterFlow417 {


    int[] up = {-1, 0};
    int[] right = {0, 1};
    int[] left = {0, -1};
    int[] down = {1, 0};
    int[][] dirs = {up, right, left, down};

    Set<List<Integer>> re = new HashSet<List<Integer>>();

    public static void main(String[] args) {
        int i = 1 + 'A';
        char s= (char)i;
        System.out.println( s);
//        int[][] a= {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//        new OceanWaterFlow417().pacificAtlantic(a);
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {


        char[][] visited = new char[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(visited[i], 'n');
            visited[i][0] = 'p';
            visited[i][matrix.length - 1] = 'a';
        }
        for (int j = 0; j < matrix.length; j++) {
            visited[0][j] = 'p';
            visited[matrix.length - 1][j] = 'a';
        }
        visited[0][matrix.length - 1] = 's';
        visited[matrix.length - 1][0] = 's';
        List<Integer> list1 = new LinkedList<>();
        list1.add(0);
        list1.add(matrix.length - 1);
        re.add(list1);

        List<Integer> list2 = new LinkedList<>();
        list2.add(matrix.length - 1);
        list2.add(0);
        re.add(list2);


        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            dfs(visited, matrix, i, j);
            j = matrix.length - 1;
            dfs(visited, matrix, i, j);

        }
        for (int j = 0; j < matrix.length; j++) {
            int i = 0;
            dfs(visited, matrix, i, j);
            i = matrix.length - 1;
            dfs(visited, matrix, i, j);
        }

        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            if ((i + up[0] >= 0 && matrix[i + up[0]][j + up[1]] == 's' && matrix[i + up[0]][j + up[1]] >= matrix[i][j])
                    || (j + left[1] >= 0 && matrix[i + left[0]][j + left[1]] == 's' && matrix[i + left[0]][j + left[1]] >= matrix[i][j])
                    || (j + right[1] < matrix.length && matrix[i + right[0]][j + right[1]] == 's' && matrix[i + right[0]][j + right[1]] >= matrix[i][j])
                    || (i + down[0] < matrix.length && matrix[i + down[0]][j + down[1]] == 's' && matrix[i + down[0]][j + down[1]] >= matrix[i][j])
            ) {
                visited[i][j] = 's';
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(j);
                re.add(list);
            }
            j = matrix.length - 1;

            if ((i + up[0] >= 0 && matrix[i + up[0]][j + up[1]] == 's' && matrix[i + up[0]][j + up[1]] >= matrix[i][j])
                    || (j + left[1] >= 0 && matrix[i + left[0]][j + left[1]] == 's' && matrix[i + left[0]][j + left[1]] >= matrix[i][j])
                    || (j + right[1] < matrix.length && matrix[i + right[0]][j + right[1]] == 's' && matrix[i + right[0]][j + right[1]] >= matrix[i][j])
                    || (i + down[0] < matrix.length && matrix[i + down[0]][j + down[1]] == 's' && matrix[i + down[0]][j + down[1]] >= matrix[i][j])
            ) {
                visited[i][j] = 's';
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(j);
                re.add(list);
            }

        }
        for (int j = 0; j < matrix.length; j++) {
            int i = 0;
            if ((i + up[0] >= 0 && matrix[i + up[0]][j + up[1]] == 's' && matrix[i + up[0]][j + up[1]] >= matrix[i][j])
                    || (j + left[1] >= 0 && matrix[i + left[0]][j + left[1]] == 's' && matrix[i + left[0]][j + left[1]] >= matrix[i][j])
                    || (j + right[1] < matrix.length && matrix[i + right[0]][j + right[1]] == 's' && matrix[i + right[0]][j + right[1]] >= matrix[i][j])
                    || (i + down[0] < matrix.length && matrix[i + down[0]][j + down[1]] == 's' && matrix[i + down[0]][j + down[1]] >= matrix[i][j])
            ) {
                visited[i][j] = 's';
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(j);
                re.add(list);
            }
            i = matrix.length - 1;

            if ((i + up[0] >= 0 && matrix[i + up[0]][j + up[1]] == 's' && matrix[i + up[0]][j + up[1]] >= matrix[i][j])
                    || (j + left[1] >= 0 && matrix[i + left[0]][j + left[1]] == 's' && matrix[i + left[0]][j + left[1]] >= matrix[i][j])
                    || (j + right[1] < matrix.length && matrix[i + right[0]][j + right[1]] == 's' && matrix[i + right[0]][j + right[1]] >= matrix[i][j])
                    || (i + down[0] < matrix.length && matrix[i + down[0]][j + down[1]] == 's' && matrix[i + down[0]][j + down[1]] >= matrix[i][j])
            ) {
                visited[i][j] = 's';
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(j);
                re.add(list);
            }
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>(re);
        return result;


    }

    public void dfs(char[][] visited, int[][] matrix, int i, int j) {
        for (int[] dir : dirs) {
            if (i + dir[0] <= 0 || i + dir[0] >= matrix.length-1 || j + dir[1] <= 0 || j + dir[1] >= matrix.length-1)
                continue;
            if (matrix[i + dir[0]][j + dir[1]] >= matrix[i][j]) {
                if (visited[i + dir[0]][j + dir[1]] != matrix[i][j] &&
                        visited[i + dir[0]][j + dir[1]] != 's') {
                    if (visited[i + dir[0]][j + dir[1]] == 'n') visited[i + dir[0]][j + dir[1]] = visited[i][j];
                    else if (visited[i + dir[0]][j + dir[1]] != visited[i][j]) visited[i + dir[0]][j + dir[1]] = 's';

                    if (visited[i + dir[0]][j + dir[1]] == 's') {
                        List<Integer> list = new LinkedList<>();
                        list.add(i + dir[0]);
                        list.add(j + dir[1]);
                        re.add(list);
                    }
                    dfs(visited, matrix, i + dir[0], j + dir[1]);
                }
            }
        }
    }
}
