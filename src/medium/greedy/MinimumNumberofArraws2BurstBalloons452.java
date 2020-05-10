package medium.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArraws2BurstBalloons452 {


//    和435题非常相似，但是描述非常不清楚，主要是记住这种解题思路
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });
        int cnt = 0;
        int pre = points[0][1];
        for (int i = 1;i< points.length;i++){
            if (points[i][0]<=pre) {
                cnt++;
                if(points[i][1] < pre){
                    pre = points[i][1];
                }
            }else{
                pre = points[i][1];
            }
        }
        return points.length-cnt;
    }
}
