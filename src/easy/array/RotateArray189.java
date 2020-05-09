package easy.array;

public class RotateArray189 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        new RotateArray189().rotate(a, 2);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        int count = 0;
        for (int i = 0; count < len; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (i != current);
        }
        for (int n : nums) {
            System.out.print(n);
        }

    }
}
