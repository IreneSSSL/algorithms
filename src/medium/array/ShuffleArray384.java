package medium.array;

import java.util.Random;


// weird problem
public class ShuffleArray384 {

    int[] array;
    int[] origin;
    public ShuffleArray384(int[] nums) {
        array = nums;
        origin = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = origin.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(array == null || array.length <2){
            return array;
        }
        Random random = new Random();
        for (int i=0;i< array.length;i++){
            int j = random.nextInt(array.length-i)+i;
            swap(i,j,array);
        }
        return array;
    }

    public int[] swap(int indexa, int indexb, int[] array){
        int tmp = array[indexa];
        array[indexa]=array[indexb];
        array[indexb]=tmp;
        return array;
    }
}
