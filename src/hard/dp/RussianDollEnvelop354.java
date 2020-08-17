package hard.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelop354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = new int[4];
        int[] s = {5,3,6,4,5};
        int i=-0;
        for (int ss :s ){
            int index = Arrays.binarySearch(a,0,i,ss);
            if (index<0){
                index = -(index+1);
            }
            if (index == i){
                i++;
            }
            a[index]= ss;
        }
    }
}
