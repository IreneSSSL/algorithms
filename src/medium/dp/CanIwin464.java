package medium.dp;

import java.util.Arrays;

public class CanIwin464 {

    boolean[] used;
    // Map<Integer, Boolean> map = new HashMap<>();
    Boolean[] map2;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > (1+maxChoosableInteger)/2 *maxChoosableInteger) return false;
        if (desiredTotal <=0) return true;
        used = new boolean[maxChoosableInteger+1];

        Arrays.fill(used, true);
        map2 = new Boolean[ format(used) + 1];
        Arrays.fill(used, false);


        return check(desiredTotal);
    }

    public boolean check(int desired){
        if (desired <= 0) return false;
        int cur = format(used);
        if (map2[cur] != null ) return map2[cur];
        for ( int i= 1;i< used.length;i++){
            if(!used[i]){
                used[i] = true;
                if ( !check(desired-i)){
                    map2[cur]= true;
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        map2[cur]= false;
        return false;

    }

    public int format(boolean[] array){
        int start = 0;
        for (boolean b : array){
            start = start<<1;
            if(b){
                start = start | 1;
            }
        }
        return start;
    }

}
