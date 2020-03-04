package LinkedList;

import java.util.HashMap;

public class lengthOfLongestSubstring3 {
    public static void main(String[] args) {
        String s = "pwewkkaw";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring_secondTry(s));
    }

    public static String lengthOfLongestSubstring(String s) {
        if (s == null) {
            return "";
        }
        String window = "";
        String result = window;
        int length = s.length();
        int head = 0;
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if (!window.contains(String.valueOf(current))) {
                window = window + current;
                if (window.length() > result.length()) {
                    result = window;
                }
            } else {
                window = window + current;
                while (head < i) {
                    char headChar = s.charAt(head);
                    if (headChar == current) {
                        head++;
                        window = window.substring(1, window.length());
                        break;
                    }
                    head++;
                    window = window.substring(1, window.length());
                    if (window == null || window.length() == 0) {
                        window = "";
                        break;
                    }
                }
            }
        }
        return result;
//        in my first try, I used Sliding Window algorithm.
//        Increasing the window size when new character is not repeated in the window. Store the best window history in "result" parameter.
//        Decreasing the window from the start until no repeated character in the window.
//        But this is not a good one, since its time complexity is 2n.

//        A better attempt is storing each non-repeated character and its index in a hashmap.
//        when finding a repeated one, the next standard window size is new character index - old character index + 1.
//        then update the character's index(value of the entry).
//        This method's time complexity is n.
    }

    public static int lengthOfLongestSubstring_secondTry(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        int len = 0;
        int windowStart = 0;
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            if (map.keySet().contains(current)) {
//                Here is tricky, windowStart cant go earlier than it is now!!!!
//                because it may go back a large step and include some other repeated characters.
                windowStart =Math.max( map.get(current) + 1, windowStart);
            }
            map.put(current, i);
            len = Math.max(len, i - windowStart + 1);
        }
        return len;
    }
}
