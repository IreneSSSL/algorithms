package easy.array;

import java.awt.*;

public class Reverse {
    public long reverse(int x) {
        if (x < -Math.pow(2, 32) || x > Math.pow(2, 32) + 1) {
            return 0;
        }
        int target = 0;
        while (x >= 1 || x <= -1) {
//            here is the most important part, in order not to overflow, we need to check before the times operation
            if (target <  Integer.MIN_VALUE/10  || target >  Integer.MAX_VALUE/10 ) {
                return 0;
            }
            target = target * 10 + x % 10;
            x = x / 10;
        }
        if (target < -Math.pow(2, 32) || target > Math.pow(2, 32) + 1) {
            return 0;
        }
        return (target);
    }

    public static void main(String[] args) {
//        1563847412
//        1534236469
        System.out.println(new Reverse().reverse(1563847412));
    }
}
