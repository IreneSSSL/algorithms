package medium.string;

public class LongestRepeatingCharacterReplacement424 {

    public static void main(String[] args) {
        String s ="ABACDEA";
        new LongestRepeatingCharacterReplacement424().characterReplacement2(s, 2);
    }

    public int characterReplacement2(String s, int k)
    {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public int characterReplacement(String s, int k) {
        if (s.length() == 1) return s.length();
        if (s.length() <= k) return s.length();

        int start = 0;
        int end = 1;
        char[] origin = s.toCharArray();
        int times = 0;
        int firstDiff = 0;

        char[] array = s.toCharArray();
        int max = Integer.MIN_VALUE;
        while (end < s.length()) {
            times = 0;
            firstDiff = -1;
            array =  s.toCharArray();;

            while (end < s.length() && (times < k || array[end] == array[end - 1])) {
                if (array[end] == array[end - 1]) {
                    max = Math.max(max, end - start + 1);
                    end++;
                } else {
                    if (times < k) {
                        array[end] = array[end - 1];
                        if (firstDiff == -1) firstDiff = end;
                        max = Math.max(max, end - start + 1);
                        end++;
                        times++;
                    } else {
                        break;
                    }
                }
            }
            if ( end == s.length() && times < k ) {
                if (k - times + (end-start) < s.length()) {
                    max = Math.max(max, end-start+ k-times);
                } else {
                    max = s.length();
                }
                break;
            }
            if( end == s.length() ) break;
            if( firstDiff == -1 ){
                start = end;
                end= start+1;
            }else{
                start = firstDiff;
                end = firstDiff+1;
            }

        }
        return max;

    }
}
