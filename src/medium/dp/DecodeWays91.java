package medium.dp;

public class DecodeWays91 {


    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0' ) return 0; //"0"
        if(s.length() == 1) return s.length();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1;i< s.length();i++){
            String sub = s.substring(i-1, i+1);
            int tens = Integer.valueOf(sub);
            if (tens == 0) return 0; // "100"
            if (tens % 10 == 0 && tens/10 >2) return 0; // "190"

            String unit = s.substring(i, i+1);
            int units = Integer.valueOf(unit);
            if (units != 0) dp[i] += dp[i-1];
            if (tens <= 26 && tens >=10 && i-2>-1) dp[i] += dp[i-2];
            if (tens <= 26 && tens >=10 && i-2==-1) dp[i] ++; // this line is specific for i=1, like '12'
        }
        return dp[dp.length-1];
    }


//    my original solution, too complicated. and doesnt solve the problem finally.
    public int numDecodings2(String s) {
        int start = 0;
        for(int i = 0;i< s.length();i++){
            if (s.charAt(i) == '0') //start++;
                return 0;
            else break;
        }  // "000122"
        s = s.substring(start);
        if(s.length() == 0 || s.equals("0") ) return 0; //"0"
        if(s.length() <=1) return s.length();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1;i< s.length();i++){
            dp[i] = dp[i-1] ;
            String sub = s.substring(i-1, i+1);
            int tens = Integer.valueOf(sub);
            if (tens == 0) return 0; // "100"
            if (tens % 10 == 0 && tens/10 >2) return 0; // "190"
            if (s.charAt(i) == '0'){
                if(i-2 >=0){
                    //(int) '2' =50
                    if((int)s.charAt(i-2) > 50 ||(int)s.charAt(i-2)==48 ) dp[i] = dp[i-1];  // 310 44310  42010
                    else dp[i]=dp[i-1]-1;  // 210
                } else{
                    dp[i]  = dp[i-1]; // this line could be removed
                }
            }
            if (tens <=26 && tens > 10 && tens != 20  ) dp[i]++;

        }
        return dp[dp.length-1];
    }
}
