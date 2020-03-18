package medium.string;

public class Atoi08 {
    public static void main(String[] args) {
        String str =" -91283472332";
        System.out.println(new Atoi08().myAtoi(str));
    }
    public int myAtoi(String str) {
        if (str == null || str.trim().equals("")){
            return 0;
        }
        String[] s = str.split(" ");
        String target = "";
        int j = 0;
        while(target.equals("")){
            target = s[j++];
        }
        int sign = 1;
        if (target.charAt(0) == '+' || target.charAt(0) == '-'){
            sign = target.charAt(0) == '-'? -1 :1;
            target = target.substring(1);
        }
        int num  = 0;
        for (int i=0;i< target.length();i++){
            char c = target.charAt(i);
            if (!Character.isDigit(c)){
                break;
            }
            int unit = Character.getNumericValue(c);
            if ( sign > 0 ){
                if ( num > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE - 10*num < unit  ){
                    return Integer.MAX_VALUE;
                }
            } else {
                if ( -1* num < Integer.MIN_VALUE / 10 || (- unit)  < Integer.MIN_VALUE  + 10*num  ){
                    return Integer.MIN_VALUE;
                }
            }
            num = num * 10 + Character.getNumericValue(c);
        }
        return num *sign;
    }

}
