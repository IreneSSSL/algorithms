package medium.string;

public class ReverseWordinString151 {

    public static void main(String[] args) {
        String s = "1 ";
        new ReverseWordinString151().reverseWords(s);
    }

    public String reverseWords(String s) {
        if (s ==null) return null;
        while ( s.startsWith(" ")){
            s= s.substring(1);
        }
        while (s.endsWith(" ")){
            s = s.substring(0, s.length()-1);
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i= s.length()-1; i>=1; i--){
            if (s.charAt(i) == ' ' && s.charAt(i-1)== ' ') sb.deleteCharAt(i-1);
        }


        s = sb.toString();
        String[] strs = s.split(" ");

        int start = 0;
        int end = strs.length-1;

        if(strs.length == 1) return s;

        while(start<end){
            String tmp = "";
            tmp = strs[end];
            strs[end] = strs[start];
            strs[start]=tmp;
            start++;
            end--;
        }
        StringBuilder b = new StringBuilder("");
        for(String ss : strs){
            ss = ss.trim();
            b.append(ss);
            b.append(" ");
        }
        b.deleteCharAt( b.length() -1);
        return b.toString();

    }
}
