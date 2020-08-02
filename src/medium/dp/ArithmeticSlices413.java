package medium.dp;

public class ArithmeticSlices413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        int[] dp = new int[A.length];
        int[] tmp = new int[A.length+1];
        for(int i = 1;i<tmp.length;i++){
            tmp[i] =  tmp[i-1] + i;
        }
        dp[0]=Integer.MIN_VALUE;
        int cnt = 0;
        int sum = 0;
        for(int i=1;i<A.length;i++){
            dp[i] = A[i]-A[i-1];
            if(dp[i] == dp[i-1]) cnt++;
            else{
                sum += tmp[cnt];
                cnt=0;
            }
        }
        if(cnt >= 1) sum += tmp[cnt];
        return sum;
    }
}
