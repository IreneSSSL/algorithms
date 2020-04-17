package medium.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule207 {


//  拓扑排序，遍历下来，队列为空则停止遍历，如果还有节点入度/出度不为0，则证明有环，不能上完所有课。
    public boolean canFinish(int numCourses, int[][] pre) {
        int[] indegree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        for(int[] array: pre){
            matrix[array[0]][array[1] ] =1;
            indegree[array[1]]++;
        }

        Queue<Integer> stack = new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i] == 0) stack.add(i);
        }

        while (!stack.isEmpty()){
            int index = stack.poll();
            for (int j = 0;j< numCourses;j++){
                if(matrix[index][j] != 0){
                    indegree[j]--;
                    if (indegree[j] == 0) stack.add(j);
                }
            }
        }
        for (int i=0;i<indegree.length;i++){
            if (indegree[i] != 0) return false;
        }
        return true;

    }

}
