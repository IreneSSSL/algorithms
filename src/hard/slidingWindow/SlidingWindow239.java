package hard.slidingWindow;

import java.util.LinkedList;

public class SlidingWindow239 {

    public static void main(String[] args) {
        int[] a = {1,3,1,2,0,5};
        new SlidingWindow239().maxSlidingWindow(a ,3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if (list.size()>0 && list.get(0) + k < i+1){
                list.remove(0); // the oldest number is beyond the range of current window
            }
            while (list.size()>0 && nums[list.getLast() ] <= nums[i]){
                list.removeLast(); // current one is bigger the pre-current one, then the pre-current one has no chance to be a max
            }
            list.add(i);
            if(i-k+1 >= 0){
                result[i-k+1] =nums[ list.get(0) ];
            }
        }
        return result;
    }
}
