package easy.dp;

public class MaxSubArray53 {
    public static void main(String[] args) {
        new MaxSubArray53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int result = 0;
        int current = 0;
        for (int i=0;i< nums.length;i++){
            current += nums[i];
            current = Math.max(0, current);
            result = Math.max(current, result);
        }
        if (result == 0){
            if (nums.length==1){
                return nums[0];
            }
            result = nums[0];
            for(int i=1; i<nums.length;i++){
                if(nums[i]> result){
                    result = nums[i];
                }
            }
        }
        return result;
    }

}
