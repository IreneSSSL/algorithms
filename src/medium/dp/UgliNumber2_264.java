package medium.dp;

public class UgliNumber2_264 {
    public static void main(String[] args) {
        new  UgliNumber2_264().nthUglyNumber2(10);
    }

//    this is almost brute force! really ugly
    public int nthUglyNumber(int n) {
        double[] dp = new double[5];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        dp[4] = 5;
        if(n <= 4) {
            return (int)dp[n-1];
        }
        dp = new double[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        dp[4] = 5;

        for (int i=5;i<n;i++){
            double a =0;
            double b =0;
            double c =0;
            double max = Integer.MAX_VALUE;
            for(int j =i-1;j>=0;j--){
                a = 2 * dp[j] > dp[i-1] ?2 * dp[j]: max ;
                b =3 * dp[j] > dp[i-1] ?3 * dp[j]: max ;
                c =5* dp[j] > dp[i-1] ?5 * dp[j]: max ;
                if (a == b && b==c && 5* dp[j] != c) break;
                max = Math.min(Math.min(Math.min(a,b),c ),max);
            }
            dp[i] = max;
        }
        System.out.println(dp[n-1]);
        return (int)dp[n-1];

    }


//    this is the correct solution
    public int nthUglyNumber2(int n) {
        if(n <= 0) return -1;
        if(n == 1) return n;
        int t2 = 0, t3 = 0, t5 = 0;
        int[] k = new int[n];
        k[0] = 1;
        for(int i  = 1; i < n ; i ++)
        {
            k[i] = Math.min(k[t2]*2,Math.min(k[t3]*3,k[t5]*5));
            if(k[i] == k[t2]*2) t2++;
            if(k[i] == k[t3]*3) t3++;
            if(k[i] == k[t5]*5) t5++;
        }
        return k[n-1];
    }

}
