package medium.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals56 {

//    for this problem, the most important point is redefining Compare function
    public class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            if (a[0] >b[0])
                return 1;
            if (a[0]==b[0])
                return 0;
            return -1;
        }
    }
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] a: intervals){
            if (merged.isEmpty() ||merged.getLast()[1] < a[0]){
                merged.add(a);
            }else {
                merged.getLast()[1] = Math.max(a[1],  merged.getLast()[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
