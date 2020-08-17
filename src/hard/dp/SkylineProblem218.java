package hard.dp;

import java.util.*;

public class SkylineProblem218 {

    public static void main(String[] args) {
        int[][] b = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        new SkylineProblem218().getSkyline(b);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new LinkedList<>();
        if (buildings.length == 0 ) return result;
        int[][] height = new int[buildings.length *2][2];
        int index = 0;
        for (int[] pair : buildings){
            int start = pair[0];
            int end = pair[1];
            height[index][0] = start;
            height[index++][1] = -pair[2];
            height[index][0] = end;
            height[index++][1] = pair[2];
        }
        Arrays.sort(height, (a,b)->{
            if (a[0]== b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        queue.offer(0);
        int pre = 0;
        for (int[] pair : height){
            if (pair[1] < 0 ){
                queue.add(-pair[1]);
            }else {
                queue.remove(pair[1]);
            }
            if (pre != queue.peek()){
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                list.add(queue.peek());
                pre = queue.peek();
                result.add(list);
            }
        }
        return result;
    }



}
