package easy.math;

public class RomanToInteger13 {
    public int romanToInt(String s) {

        int res = 0;
        char last = s.charAt(0);
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'I':
                    res += 1;
                    break;
                case 'V':
                    res += 5;
                    if (last == 'I') {
                        res -= 2;
                    }
                    break;
                case 'X':
                    res += 10;
                    if (last == 'I') {
                        res -= 2;
                    }
                    break;
                case 'L':
                    res += 50;
                    if (last == 'X') {
                        res -= 20;
                    }
                    break;
                case 'C':
                    res += 100;
                    if (last == 'X') {
                        res -= 20;
                    }
                    break;
                case 'D':
                    res += 500;
                    if (last == 'C') {
                        res -= 200;
                    }
                    break;
                case 'M':
                    res += 1000;
                    if (last == 'C') {
                        res -= 200;
                    }
                    break;
            }
            last = c;
        }
        return res;
    }
}
