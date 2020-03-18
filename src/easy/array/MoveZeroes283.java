package easy.array;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] a = {0, 0, 5,0,0};
        new MoveZeroes283().moveZeroes(a);
    }

//    low-efficiency solution
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int last = nums.length - 1;
        boolean stop = true;
        for (int i = 0; i < last; i++) {
            stop = true;
            for (int j = i; j < last; j++) {
                if (nums[j] == 0) {
                    for (int n = 1; n < last + 1 && j+n <last+1; n++) {
                        if (nums[j + n] != 0) {
                            nums[j] = nums[j + n];
                            nums[j + n] = 0;
                            stop = false;
                            j = j + n - 1;
                            break;
                        }

                    }

                }
            }
            last--;
            if (stop) {
                break;
            }
        }

    }

}
