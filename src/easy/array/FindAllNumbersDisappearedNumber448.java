package easy.array;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedNumber448 {


//    把nums的值和index连接起来，混合使用
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (nums.length == 0) return list;
        int len = nums.length;
        for(int i = 0;i<nums.length;i++){
            int index = nums[i]-1;
            if ( index >= len) index -= len;
            if (nums[index] > len) continue;
            nums[index] += len;
        }

        for (int i=0;i<nums.length; i++){
            if (nums[i]<=len){
                list.add(i+1);
            }
        }
        return list;
    }
}
