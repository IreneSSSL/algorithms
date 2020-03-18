package easy.array;

import java.util.*;
import java.util.stream.IntStream;

class SingleNumber136 {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Integer[] s = set.toArray(new Integer[0]);
        return Arrays.stream(s).mapToInt(Integer::intValue).sum() * 2 - IntStream.of(nums).sum();
    }


//    a lot of tricky methods.
//    I prefer this one:   2*(a+b+c) - (a+a+b+b+c) = c
//    Math is beautiful.
//
//    another tricky one
//    0 xor a = a
//    a xor a = 0
//    a xor a xor b xor b xor c = c
//    bit manipulation is beautiful (in java, a ^ b = a xor b)



    public static void main(String[] args) {
        int[] a = {2, 2, 1, 5, 5};
        SingleNumber136 s = new SingleNumber136();
        System.out.println(s.singleNumber(a));
    }
}