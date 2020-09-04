package medium.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCase784 {


    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }

    public static void main(String[] args) {
        String s = "a1b2";
        new LetterCase784().fractionToDecimal(1,6);
    }

    List<String> list = new LinkedList<>();

    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0) return list;
        char[] array = S.toCharArray();

        for (int i = 0; i < array.length; i++) {
            helper(array, new StringBuilder(""), i);
        }
        return list;
    }

    public void helper(char[] array, StringBuilder tmp, int i) {

        if (i == array.length && array.length == tmp.length()) {
            list.add(tmp.toString());
            return;
        }
        if (i == array.length ) return;

        if (Character.isDigit(array[i])) {
            tmp.append(array[i]);
            helper(array, tmp, i + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        } else {
            tmp.append(Character.toLowerCase(array[i]));
            helper(array, tmp, i + 1);
            tmp.deleteCharAt(tmp.length() - 1);

            tmp.append(Character.toUpperCase(array[i]));
            helper(array, tmp, i + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        //

    }
}
