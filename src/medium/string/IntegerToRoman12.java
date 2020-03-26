package medium.string;

public class IntegerToRoman12 {

    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        StringBuilder str = new StringBuilder("");
        while (num > 0) {
            if (num >= 1000) {
                int x = num / 1000;
                num -= x * 1000;
                while (x > 0) {
                    str.append("M");
                    x--;
                }
                continue;
            }
            if (num >= 900) {
                str.append("CM");
                num -= 900;
                continue;
            }
            if (num >= 500) {
                num -= 500;
                str.append("D");
                continue;
            }
            if (num >= 400) {
                str.append("CD");
                num -= 400;
                continue;
            }

            if (num >= 100) {
                int x = num / 100;
                num -= x * 100;
                while (x > 0) {
                    str.append("C");
                    x--;
                }
                continue;
            }
            if (num >= 90) {
                str.append("XC");
                num -= 90;
                continue;
            }
            if (num >= 50) {
                num -= 50;
                str.append("L");
                continue;
            }
            if (num >= 40) {
                str.append("XL");
                num -= 40;
                continue;
            }


            if (num >= 10) {
                int x = num / 10;
                num -= x * 10;
                while (x > 0) {
                    str.append("X");
                    x--;
                }
                continue;
            }
            if (num >= 9) {
                str.append("IX");
                num -= 90;
                continue;
            }
            if (num >= 5) {
                num -= 5;
                str.append("V");
                continue;
            }
            if (num >= 4) {
                str.append("IV");
                num -= 4;
                continue;
            }
            if (num >= 1) {
                while (num > 0) {
                    str.append("I");
                    num--;
                }
                continue;
            }

        }
        return str.toString();

    }
}
