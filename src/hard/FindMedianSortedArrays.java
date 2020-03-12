package hard;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3, 4};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l3 = (l1 + l2) / 2 + 1;
        int[] nums3 = new int[l3];
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        while (n1 < l1 && n2 < l2 && n3 < l3) {
            if (nums1[n1] < nums2[n2]) {
                nums3[n3++] = nums1[n1++];
            } else {
                nums3[n3++] = nums2[n2++];
            }
        }
        while (n1 < l1 && n3 < l3) {
            nums3[n3++] = nums1[n1++];
        }
        while (n2 < l2 && n3 < l3) {
            nums3[n3++] = nums2[n2++];
        }
        if ((l2 + l1) % 2 == 0) {
            return ((double) nums3[l3 - 1] + nums3[l3 - 2]) / 2;
        } else {
            return (double) nums3[l3 - 1];
        }
    }

}
