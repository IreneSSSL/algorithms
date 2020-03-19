package easy.array;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,7,0,0,0,0,0,0};
        int[] nums2 = new int[]{3,5,6};
        new MergeSortedArray88().merge(nums1,3, nums2,3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if( nums2 == null || nums2.length ==0 || n == 0 ){
            return;
        }
        int tail1 = m-1;
        int tail2 = n-1;
        int finalLen = n+m-1;
        while (tail1 >-1 &&tail2>-1){
            nums1[finalLen--] = nums2[tail2] > nums1[tail1] ? nums2[tail2--] : nums1[tail1--];
        }
        while (tail2 >=0){
            nums1[finalLen-- ]=nums2[tail2--];
        }
    }

//    dont make everything too complicated to solve!
//    dont focus on your first idea! try to solve it in different ways!
//    below method is not correct when int[] nums1 = new int[]{1,2,4,7,0,0,0,0,0,0}; int[] nums2 = new int[]{3,5,6};
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if( nums2 == null || nums2.length ==0 || n == 0 ){
            return;
        }
        int p1 = 0;
        int p2 = 0;
        while (true) {
            p1 = 0;
            p2 = 0;
            while (!(nums1[p1] == 0 && p2 == n)) {
                if (p2 == n) {
                    p2 = 0;
                }
                if (nums2[p2] == 0){
                    break;
                }
                if (nums1[p1] != 0 && nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    int tmp = nums1[p1];
                    nums1[p1] = nums2[p2];
                    nums2[p2] = tmp;
                    p2++;
                }
            }
            if (p2 == 0) {
                break;
            }
        }
        System.out.println(nums1);


    }
}
