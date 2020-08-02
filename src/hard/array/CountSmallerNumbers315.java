package hard.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountSmallerNumbers315 {

    public static void main(String[] args) {
        int[] a = {4,5,2,6,1};
        new CountSmallerNumbers315().countSmaller(a);
    }
    public List<Integer> countSmaller(int[] nums) {
        int[] origin = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            origin[i] = nums[i];
        }
        Arrays.sort(nums);
        int[] count = new int[nums.length];

        for (int i = 0;i< origin.length;i++){
            for (int j=0;j<i;j++){
                if( origin[j] > origin[i] ) {
                    count[j]++;
                }

            }
        }
        List<Integer> re = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            re.add( count[i] );
        }
        return re;
    }
}
