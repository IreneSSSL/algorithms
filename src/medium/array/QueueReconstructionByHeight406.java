package medium.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight406 {

    public static void main(String[] args) {
        int[][] a = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        a = (new QueueReconstructionByHeight406().reconstructQueue(a));
        for (int[] s: a){
            System.out.println(s[0] + " "+ s[1]);
        }

    }
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]){
                    return a[1]- b[1];
                }else{
                    return b[0] - a[0];
                }
            }
        });

        List<int[]> list = new LinkedList<>();
        for(int[] pair: people){
            int pre = pair[1];
            int cnt = 0;
            if (list.size() == 0) {
                list.add(pair);
                continue;
            }
            for (int[] sorted: list){
                cnt++;
                if (sorted[0] >= pair[0]) pre--;
                if (pre <= 0) {
                    if ((pre < 0)) cnt = 0;
                    list.add( cnt, pair);
                    break;
                }
            }

        }
        return list.stream().toArray(int[][]::new);
    }
}
