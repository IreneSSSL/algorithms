import java.util.*;
public class TwoSums {
    public static void main(String[] args){
        TwoSums tw = new TwoSums();
        int[] nums = new int[]{2,7,11,15};
        tw.TwoSum(nums, 9);
    }
    public int[] TwoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 ){
            return null;
        }
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
//      since this problem aims to find two numbers, it means if one is fixed, the other is fixed too.
//      assuming we fix the first one value, then we only need to find whether the other number exists or not.
//      if it does exist, then we could return their indice, which are stored at the value part of the ArrayList;
//      else the assumed one is not what we want.
//      jump to next number
        for (int i=0; i< nums.length;i++){
            Integer current = nums[i];
            Integer sub = target-current;
            if (hashmap.keySet().contains(sub)){
                return new int[]{i,hashmap.get(sub)};
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }
}

// if code without IDE, points needed to be remembered:
// 1 for array of int, use xx.length to get the length
