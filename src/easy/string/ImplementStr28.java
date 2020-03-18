package easy.string;

public class ImplementStr28 {
    public static void main(String[] args) {
        String h = "mississippi";
        String n = "issip";
        System.out.println(new ImplementStr28().strStr(h, n));
    }


//    kind of sliding window strategy.

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int hl = haystack.length();
        int nl = needle.length();
        for (int i = 0; i <= hl - nl; i++) {
            for (int j = 0; j < nl && haystack.charAt(i + j) == needle.charAt(j); j++) {
                if (j == nl - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
