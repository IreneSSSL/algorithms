package medium.graph;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule210 {

    public static void main(String[] args) {
        int[] a = {1,4,5,6,7};
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1,2);

        System.out.println(list.get(1));
//        System.out.println(Arrays.binarySearch(a, 8));
//        int[][] pre = {{1,0},{0,1}};
//        new CourseSchedule210().findOrder(2,pre);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topo = new int[numCourses];

        List<Integer>[] edges = new LinkedList[numCourses];
        for(int i=0;i<numCourses ;i++){
            edges[i] =  new LinkedList<>();;
        }
        for (int[] pair : prerequisites){
            edges[pair[0]].add(pair[1]);
            topo[pair[0]] = 1;
        }
        int[] result = new int[numCourses];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(topo[i]==0)
                queue.add(i);
        }

        int i = 0;
        while ( !queue.isEmpty()){
            int index = queue.poll();
            result[i++] = index;
            topo[index] = 1;
            for (int x=0;x<numCourses;x++) {
                if (edges[x] != null && edges[x].contains(index)) {
                    edges[x].remove( edges[x].indexOf(index));
                    if (edges[x].size() == 0) queue.add(x);
                }
            }
        }
        if (i < numCourses-1) return new int[]{};
        return result;
    }
}
