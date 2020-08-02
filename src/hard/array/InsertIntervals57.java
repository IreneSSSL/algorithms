package hard.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class InsertIntervals57 {


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] b = {4,8};

//        int[][] a = new int[][]{{1,5}};
//        int[] b = {0,0};
        new InsertIntervals57().insert(a,b);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        if (newInterval.length == 0) return intervals;

        int start = newInterval[0];
        int end = newInterval[1];
        if(start < intervals[0][0] && end >intervals[intervals.length-1][1] ){
            return new int[][]{newInterval};
        }

        boolean startMid = false;
        boolean endMid = false;

        int startBefore = start;
        int endAfter = end;

        LinkedList<int[]> result = new LinkedList<>();
        for (int[] a : intervals){
            result.add(a);
            if (!startMid && a[0] <= start && start <= a[1]){
                startMid = true;
                startBefore = a[0];
            }
            if (!endMid && a[0] <= end && end <= a[1]) {
                endMid = true;
                endAfter = a[1];
            }
        }

        if (end < intervals[0][0] || intervals[intervals.length-1][1] < start) {
            result.add(newInterval);
        } else {
            int[] target = new int[2];
            if (startMid && endMid) {
                target[0] = startBefore;
                target[1] = endAfter;
            } else if (!startMid && endMid) {
                target[0] = start;
                target[1] = endAfter;
            } else if (!startMid && !endMid) {
                target[0] = start;
                target[1] = end;
            } else {
                //     startMid && !endMid
                target[0] = startBefore;
                target[1] = end;
            }

            Iterator<int[]> iter = result.iterator();
            while (iter.hasNext()) {
                int[] a = iter.next();
                if (target[0] <= a[0] && a[1] <= target[1]) {
                    iter.remove();
                }
            }
            result.add(target);
        }
        int[][] re =  result.toArray(new int[result.size()][2]);
        Arrays.sort(re, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        return re;

    }
}
