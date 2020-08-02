package hard.dp;

import java.util.LinkedList;
import java.util.List;

public class IsScramble87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        // if (s1.length() == 0 && s2.length() == 0) return true;
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        return getRange(c1,c2,0,c1.length-1);
    }

    public boolean getRange(char[] c1, char[] c2, int c1start, int c1end){
        if (c1end - c1start==1 ){
            if (c1[c1start] == c2[c1start] && c1[c1end] == c2[c1end] ) return true;
            if (c1[c1start] == c2[c1end] && c1[c1end] == c2[c1start] ) return true;
            return false;
        }
        if (c1end == c1start){
            if (c1[c1start] == c2[c1start]  ) return true;
            return false;
        }
        int[] cc1 = new int[26];
        int[] cc2 = new int[26];
        for (int i = c1start;i<c1end;i++){
            cc1[c1[i]-'a']++;
            cc2[c2[i]-'a']++;

            boolean uniform = true;
            for (int j =c1start;j<=i;j++){
                if (cc1[c1[i]-'a'] !=cc2[c2[i]-'a']){
                    uniform= false;
                    break;
                }
            }
            if (uniform){
                return getRange(c1,c2,c1start,i) && getRange(c1,c2,i+1, c1end);
            }
        }
        return false;
    }
}
