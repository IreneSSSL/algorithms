package easy.array;

public class RemoveElement27 {


//    双指针，等于目标值的就挪到后面
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int head = 0;
        int tail = nums.length-1;


        while ( head <= tail && nums[tail] == val) tail--;

        if (nums.length == 1){
            if (head == tail) return 1;
            else return 0;
        }

        if(head > tail){
            return 0;
        }

        while(head < tail){
            if (nums[head] == val){
                int tmp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = tmp;
                while ( head <= tail && nums[tail] == val) tail--;
            }
            head++;
        }
        return tail+1;
    }

}
