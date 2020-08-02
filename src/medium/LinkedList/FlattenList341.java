package medium.LinkedList;

import java.util.HashMap;
import java.util.Stack;

public class FlattenList341 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder str = new StringBuilder("");
        if ( numerator == 0) return "0";
        long num = Math.abs((long) numerator);
        long dem = Math.abs((long) denominator);
        if ( (numerator>0) ^ (denominator>0) ) str.append("-");

        long integer= num/dem;
        str.append(integer);

        long remainder= num % dem;
        if (remainder == 0) return str.toString();
        str.append(".");
        HashMap<Long, Integer> map = new HashMap<>();


        map.put(remainder, str.length());
        remainder *= 10;
        while ( remainder != 0){
            str.append( remainder / dem );
            if (map.get( remainder% dem ) != null){
                str.insert(map.get( remainder % dem ), "(");
                str.append(")");
                break;
            }
            map.put( remainder % dem, str.length());
            remainder = remainder  % dem;
            remainder *= 10;

        }
        String re =  str.toString();
        re = re.replace("(0)", "");
        System.out.println(re);
        return re;
    }



    public static void main(String[] args) {
        new FlattenList341().fractionToDecimal(1,333);
    }
}
