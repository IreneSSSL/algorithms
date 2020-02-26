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
