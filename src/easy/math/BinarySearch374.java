package easy.math;

public class BinarySearch374 {

    public int guessNumber(int n) {
        return check(1, n);

    }

    public int check (double start, double end){
        double middle = (start+end)/2;
        int result = guess((int)middle);
        if (result == 0) return (int)middle;
        if (result < 0){
            return check (start, middle);
        } else {
            return check(middle+1, end);
        }
    }


/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 */
    public int guess(int num) {
        return 0;
    }

}
