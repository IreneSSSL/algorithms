package medium.dp;

import java.util.*;

public class PalindromicSubstring647 {
    public static void main(String[] args) {
        String s = "abcdcba";
        new PalindromicSubstring647().countSubstrings2(s);
    }


    public int countSubstrings2(String s) {
        if (s == null) return 0;
        if (s.length() == 0) return 0;
        int count = 0;
        char[] chars = s.toCharArray();
        count++;
        int[][] flag = new int[s.length()][s.length()+1];
        flag[0][1] = 1;
        for (int i = 1; i < s.length(); i++) {
            count++;
            flag[i][1] =1;
            for (int j = 0; j < s.length()+1; j++) {
                if (flag[i-1][j] == 0) continue;
                String st = s.substring( i-j  ,i);
                int[] res = judgePalindrome2(chars, i, st.length());
                for (int ress: res){
                    if ( ress != 0) {
                        int start = i ;
                        if ( flag[start][ress] == 0){
                            count++;
                            flag[start][ress] =1;
                        }

                    }
                }
            }

        }
        System.out.println(count);
        return count;
    }

    public int[] judgePalindrome2(char[] chars, int end, int length) {
        int[] str = {0,0};
        int cnt = 0;
//         case 1:
        int start = end - length;
        int tail = end;
        String s = new String(chars);
        while (start >= 0 && start < end) {
            if (chars[start] != chars[end]) break;
            start++;
            end--;
        }
        if (start >= end) {
            str[0] = 1 + length;
        }

//         case 2:
        start = tail - length - 1;
        end = tail;
        if (start>=0 && chars[start] == chars[end] ) {
            str[1] = 2 + length;
        }
        return str;
    }


//    this is DP，but not the best way to solve it
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }


//    this is the easiest and fastest way
    int count =1;
    public int countSubstrings3(String s) {
        if(s.length()==0)
            return 0;
        for(int i=0; i<s.length()-1; i++){
            checkPalindrome(s,i,i);     //To check the palindrome of odd length palindromic sub-string
            checkPalindrome(s,i,i+1);   //To check the palindrome of even length palindromic sub-string
        }
        return count;
    }

    private void checkPalindrome(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){    //Check for the palindrome string
            count++;    //Increment the count if palindromin substring found
            i--;    //To trace string in left direction
            j++;    //To trace string in right direction
        }
    }
}
