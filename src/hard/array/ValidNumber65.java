package hard.array;

public class ValidNumber65 {
    public static void main(String[] args) {
        String s = "-.";
        System.out.println(new ValidNumber65().isNumber(s));
    }

    public boolean isNumber(String s) {

        if (s.length() == 0) return false;

        s = s.trim();
        if (s.length() == 1) {
            if (Character.isDigit(s.toCharArray()[0])) return true;
            return false; //e .
        }

        int count = 0;
        int count2 = 0;
        int count3 = 0;
        char[] a = s.toCharArray();
        //        count the number of .  in case of .1.   ..
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'e') count++;
            if (count > 1) return false;

            if (a[i] == '.') count3++;
            if (count3 > 1) return false;
            if (Character.isDigit(a[i])) {
                count2++;
            }
        }
        if (count2 == 0) return false;


        String[] parts = s.split("e");
        if (parts.length > 2) return false;
        if (s.contains("e") && parts.length == 1) return false;
        if (parts.length == 1) return check(parts[0], false);
        return check(parts[0], false) && check(parts[1], true);
    }

    public boolean check(String s, boolean mustInteger) {
        if (s.length() == 0) return false; // nothing before or after the 'e'
        if (s.length() == 1) {
            if (Character.isDigit(s.toCharArray()[0])) return true;
            return false; //e .
        }
        if (mustInteger) {
            if (s.contains(".")) return false;
        }
        char[] arrays = s.toCharArray();
        String[] parts = s.split("\\.");
        if (parts.length > 2 || parts.length == 0) return false; //..

        String[] pos = s.split("\\+");
        String[] neg = s.split("-");
        if (pos.length > 2 || neg.length > 2 || (pos.length + neg.length) > 3)
            return false;  // exists mulitiple signs

        for (int i = 0; i < arrays.length; i++) {
            char ch = arrays[i];
            if (ch == '.') {

            } else if ((ch == '+' || ch == '-')) {
                if (i != 0) return false;
            } else if (!Character.isDigit(ch)) return false;


        }
        return true;
    }
}
