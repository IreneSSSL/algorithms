package hard.dp;

public class WildcardMatching44 {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        new WildcardMatching44().isMatch(s,p);
    }
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return false;

        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
        for (int i=1;i< p.length()+1;i++){
            boolean change = false;
            for (int j=0;j<s.length()+1;j++){
                if (pc[i-1] == '*'){
                        change = true;
                    if (j==0){
                        dp[i][j] = dp[i-1][j];

                    }else{
                        dp[i][j] = (dp[i-1][j] || dp[i-1][j-1] || dp[i][j-1]);
                    }
                }else {
                    if (j!=0){
                        if(sc[j-1] == pc[i-1] || pc[i-1] == '?' ){
                            dp[i][j] = dp[i-1][j-1];
                            change = true;
                        }
                    }
                }
            }
            if (!change) break;
        }
        System.out.println(dp[p.length()][s.length()]);
        return dp[p.length()][s.length()];
    }
}
