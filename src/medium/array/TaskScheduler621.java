package medium.array;

import java.util.Arrays;

public class TaskScheduler621 {


    public int leastInterval(char[] tasks, int n) {
        if( tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        int[] count = new int[26];
        int height = 0;
        for (char c : tasks){
            count[c-'A']++;
        }
        int width = n;

        Arrays.sort(count);
        height = count[25]-1;   // 最后一行不用算slot，因为最后一行的slot不会算进最后的时间里，最后一行一定是以无slot的形式统计的
        int intervals = height * width;
        for (int i= count.length-2;i>=0;i--){
            if (count[i] == 0) break;
            intervals -= Math.min(count[i], height); // 从数学上看，这么操作是可行的，每次填满一个cycle之后，再对剩余的任务数量排序，保证这样可行
        }
        return intervals>0?intervals+tasks.length: tasks.length;
    }
}
