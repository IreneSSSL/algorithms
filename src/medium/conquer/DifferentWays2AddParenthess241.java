package medium.conquer;

import java.util.LinkedList;
import java.util.List;

public class DifferentWays2AddParenthess241 {

    List<Integer> re = new LinkedList<Integer>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() ==0 ) return re;
        return helper(input);
    }

//    divide and conquer
//    every big problem could be divided as several smaller problems, like A(x) = a(x)+...+a(x)
//    for an expression, the signs are not important at all. like a+b+c+d
//    the point is we could divide the expression into two expressions on the sides of each sign
//    F(a-b-c-d) = (F(a)-F(b-c-d))  +  (F(a-b)-F(c-d) )  +  (F(a-b-c)-F(d))
//    see, we could solve this problem using iterative functions.
    public List<Integer> helper(String input){
        char[] chars = input.toCharArray();
        List<Integer> result = new LinkedList<>();
        if( !input.contains("+") && !input.contains("-") && !input.contains("*") ){
            int val =0;
            for(int i = 0;i<chars.length;i++){
                val = val *10+ Character.getNumericValue(chars[i]);
            }
            result.add(val);
        }else{

            for (int i= 0;i<chars.length;i++){
                if ( !Character.isDigit(chars[i]) ){
                    List<Integer> first = helper(input.substring(0,i));
                    List<Integer> second = helper(input.substring(i+1));
                    for (int a : first){
                        for (int b : second){
                            if (chars[i] == '+'){
                                result.add(a+b);
                            }else if (chars[i] == '-'){
                                result.add(a-b);
                            }else {
                                result.add(a*b);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
