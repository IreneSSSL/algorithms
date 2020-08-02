package medium.string;

import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator227 {

    public static void main(String[] args) {
        String s = "2+2*4";
        new BasicCalculator227().calculate(s);
    }
    public int calculate(String s) {
        LinkedList<Integer> num = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        s = s.replace(" ", "");
        char[] chars = s.toCharArray();
        int re = 0;
        for( int i=0;i< chars.length;i++){
            char c = chars[i];
            if (c == '+' || c== '-'){
                op.add(c);
            } else if(c=='*' || c == '/'){
                int first = num.removeLast();

                int second = 0;
                i++;
                while(i<chars.length && Character.isDigit(chars[i])){
                    second = second *10 + Character.getNumericValue(chars[i++]);
                }
                if(i != chars.length) i--;
                if(c == '*') num.add(first * second);
                else num.add(first / second);
            } else {
                int second = 0;
                while(i<chars.length && Character.isDigit(chars[i])){
                    second = second *10 + Character.getNumericValue(chars[i++]);
                }
                if(i != chars.length) i--;
                num.add(second);
            }
        }

        if(num.size() == 0) return 0;

        re = num.removeFirst();
        if(num.size() != op.size() ) return 0;
        while ( !num.isEmpty()){
            int second = num.removeFirst();
            if ( op.removeFirst() == '+') re += second;
            else re-=second;
        }
        System.out.println(re);
        return re;
    }
}
