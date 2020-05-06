package easy.array;

public class BackspaceString844 {

    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) return true;
        if (S == null || T == null) return false;

        String s = process(S);
        String t = process(T);

        return s.equals(t);
    }

    private String process(String s) {
        char[] chars = s.toCharArray();

        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                p = Math.max(0, p-1);
                continue;
            }

            chars[p] = chars[i];
            p++;
        }
        //System.out.println( (new String(chars)).substring(0, p));

        return (new String(chars)).substring(0, p);
    }
}
