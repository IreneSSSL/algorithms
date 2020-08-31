package medium.array;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class WiggleSort324 {


    public static void main(String[] args) {
        int[] a= {2,3,3,2,2,2,1,1};
        new WiggleSort324().wiggleSort(a);
    }

    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        LinkedList<Integer> left = new LinkedList<>();
        for (int i = 0;i< nums.length;i++){
            if (queue.size() <nums.length/2) {
                queue.add(nums[i]);
            }else {
                int s =queue.peek();
                if (queue.peek() < nums[i]){
                    int a = queue.poll();
                    if (left.size() %2 == 0) left.addFirst(a);
                    else left.addLast(a);
                    queue.add(nums[i]);
                }else{
                    left.add(nums[i]);
                }
            }
        }

        for (int i=nums.length-1;i>=0;i--){
            if (i % 2 == 0){
                nums[i] = left.getFirst();
                left.removeFirst();
            }else{
                nums[i] = queue.poll();
            }
        }
        System.out.println();
    }
}
