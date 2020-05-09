package easy.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(

                new Comparator<Integer>(){
                    public int compare(Integer a, Integer b){
                        return b-a;
                    }
                }
        );
        for (int stone: stones){
            queue.add(stone);
        }
        while (queue.size()>1){
            int a = queue.poll();
            // if (queue.isEmpty()) return a;
            int b = queue.poll();
            int min = Math.min(a,b);
            a -= min;
            b -= min;
            if (a != 0) queue.add(a);
            if (b != 0) queue.add(b);
        }
        if (queue.isEmpty()) return 0;
        return queue.poll();

    }
}
