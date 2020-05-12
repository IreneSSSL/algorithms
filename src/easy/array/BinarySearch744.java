package easy.array;

import java.lang.reflect.Array;
import java.util.*;

public class BinarySearch744 {

    public static void main(String[] args) {
        char[] c = {'a','c','c','c','e'};
        System.out.println(new BinarySearch744().nextGreatestLetter(c, 'a'));
    }
    public char nextGreatestLetter(char[] c, char target) {
        if (target < c[0]) return c[0];
        if (target >=c[c.length-1] ) return c[0];

        int mid = 0;
        int start=0;
        int end = c.length-1;
        while( start <= end ){
            if (start == end-1){
                if ( c[start] == target) {
                    while( target == c[start]){start++;}
                    return c[start];
                }
                if ( c[end] == target) {
                    while( target == c[end]){end++;}
                    return c[end];
                }
                else return c[end];
            }
            if (start == end){
                if (c[start] == target) return c[end+1];
                else return c[end];
            }

            mid = start+ (end-start)/2;
            char m = c[mid];
            if(m == target) {
                while( target == c[mid]){mid++;}
                return c[mid];
            }
            if(m < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        return c[0];

    }


}
