package easy.string;

public class LongestCommonPrefix14 {


//    some points:
//    1 length of all array, like int array, char array, string array  —— a.length, no ()!!!  But for a string, it's length()
//    2 using StringBuilder str= new StringBuilder("xx");  to append char or char array flexibly.
//    3 test case [], ["",""],["c","c"]....


    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return "";
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder target = new StringBuilder("");
        boolean running = true;
        int step = 0;
        while(running ){
            if (step == strs[0].length()) {
                running = false;
                break;
            }
            char a = strs[0].charAt(step);
            target.append(a);
            for (int i=1;i< strs.length;i++){
                if( step == strs[i].length() || a != strs[i].charAt(step)){
                    running = false;
                    target.deleteCharAt(target.length()-1);
                    break;
                }
            }
            step++;
        }
        return target.toString();

    }

}
