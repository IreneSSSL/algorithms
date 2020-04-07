package medium.dp;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        int[] a = {-1,4,-9};
        new MaximumProductSubarray152().maxProduct(a);
    }
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

}
