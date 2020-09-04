package medium.backtracking;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress93 {

    public static void main(String[] args) {
        String s ="010010";
        new RestoreIPAddress93().restoreIpAddresses(s);
    }
    List<String> result = new LinkedList<String>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() ==0) return result;
        helper(s,0,0,new char[s.length()+4]);
        return result;
    }

    public void helper(String s, int start, int i, char[] array){
        if( i==4 && start == s.length()){
            String st = new String(array);
            result.add(st.substring(0,st.length()-1));
            return;
        }
        // 处理0特别多的情况，比如 0000，有可能出现0000.然后i=1，start=4，没有及时停止，下面会越界
        if(i==4 || start==s.length()){
            return;
        }
        int len = 1;
        char[] sArray = s.toCharArray();

        while(true){
            int num = Integer.valueOf( s.substring(start,start+len));
            if(len>1 && num<10) break;  // 处理001这样的情况
            if( num<0 || num>255 ) break;
            for (int j=0;j<len;j++){
                array[i+start+j] = sArray[start+j];
            }
            array[i+start+len] = '.';
            helper(s,start+len,i+1,array);
            len++;
            if (start+len == s.length()+1) break;
        }
    }
}
