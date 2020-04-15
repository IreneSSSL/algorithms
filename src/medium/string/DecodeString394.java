package medium.string;

import java.util.Stack;

public class DecodeString394 {

    public static void main(String[] args) {
        System.out.println(new DecodeString394().decodeString("3[a3[b]dd3[c]]"));
    }


//    recursive
    public String decodeString(String s) {
        if (s == null) return s;
        if (s.length()<=1) return s;
        return helper(s);

    }

//    每次只处理一个【】，然后生成个新的string，对新的string进行爹下一次处理，直到所有【】都被处理完
    public String helper(String s){
        if (!s.contains("[")) return s;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> times = new Stack<>();
        times.push(0);
        for (int i = 1;i<s.length();i++){
            if (s.charAt(i) == '['){
                stack.push(i);
                continue;
            }

//            数字可能不仅是个位数，因此只存储第一个数字，最后一个数字的index = ‘【’的index-1；
            if ( (int)s.charAt(i) <=57 && (int) s.charAt(i)>= 48){
                if ((int)s.charAt(i-1) <=57 && (int) s.charAt(i-1)>= 48) continue;
                else times.push(i);
            }
//            遇到第一个最内层【】，可以开始进行处理了
            if  (s.charAt(i) == ']'){
                int j = stack.pop();
                int head = times.pop();
                int time = Integer.valueOf(s.substring(head, j));
                String subString = s.substring(j+1,i);
                String ss ="";
                for (int l =0;l<time;l++){
                    ss += subString;
                }
                String old = s.substring(head,i+1);
                s = s.replace(old, ss);
                break;
            }
        }
        s = helper(s);
        return s;
    }
}
