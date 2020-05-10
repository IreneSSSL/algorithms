package medium.greedy;

import java.util.*;

public class NonOverlapping435 {

    public static void main(String[] args) {
        int[][] inter = {{1,2},{1,4},{2,3},{3,4},{1,2}};
        System.out.println(new NonOverlapping435().eraseOverlapIntervals(inter));
    }
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        int cnt = 0;
        int[] pre = new int[2];
        pre = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if (intervals[i][0]<pre[1]){
                cnt++;
                if (pre[1] > intervals[i][1]) pre = intervals[i]; // important step: [1,5] then [2,4], we delete [1,5]
            }else{
                pre = intervals[i];
            }
        }
        return cnt;
    }
}
