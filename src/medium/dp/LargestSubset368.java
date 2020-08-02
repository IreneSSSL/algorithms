package medium.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LargestSubset368 {
    public static void main(String[] args) {
        int[] a = {546,669};
        new LargestSubset368().largestDivisibleSubset(a);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        if (nums.length == 1) {
            List<Integer> result = new LinkedList<>();
            result.add(nums[0]);
            return result;
        }

        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        List<Integer> result = new LinkedList<>();
        int max = 1;
        int index = -1;
        for (int i = 1;i< nums.length;i++){
            for (int j = i-1; j>=0;j--){
                if (nums[i] % nums[j]== 0){
                    if (count[j] +1 > count[i]){
                        count[i] = count[j]+1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max){
                max = count[i];
                index =i;
            }
        }
        if (index == -1 ) {
            result.add(nums[0]);
        }

        while (index != -1){
            result.add( nums[index] );
            index = pre[index];
        }
        return result;
    }
}
