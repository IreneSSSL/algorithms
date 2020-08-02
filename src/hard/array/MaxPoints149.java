package hard.array;

import java.util.*;

public class MaxPoints149 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1}, {2, 2}, {1, 2}, {2, 3},{3,4}};
        System.out.println(new MaxPoints149().maxPoints(a));
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        if (points[0].length == 0) return 0;
        HashSet<int[]> set = new HashSet<>();
        Map<Integer,Integer> dup = new HashMap<>();

        double[][] slope = new double[points.length][points.length];
        int maxOccurrence = 0;
        double maxSlope = 0;
        int start = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                if ((points[i][0] - points[j][0]) == 0){
                    slope[i][j] = Integer.MAX_VALUE;
                    if ((points[i][1] - points[j][1]) == 0) {
                        int ocurrence = map.getOrDefault(slope[i][j], 0);
                        dup.put(i,ocurrence+1);
                    }
                }
                else slope[i][j] = (double) (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                int ocurrence = map.getOrDefault(slope[i][j], 0);
                map.put(slope[i][j], ocurrence + 1);
                if (ocurrence + 1 > maxOccurrence) {
                    maxOccurrence = ocurrence + 1;
                    maxSlope = slope[i][j];
                    start = i;
                }

            }
        }

        Set<Integer> target = new HashSet<>();
        for (int j = start + 1; j < points.length; j++) {
            target.add(start);
            if (slope[start][j] == maxSlope) {
                target.add( j );
            }
        }
        int re = 0;
//        for (Integer tar : target){
            if (dup.get(start) != null) re += dup.get(start);

//        }
        return re + target.size();
    }
}
