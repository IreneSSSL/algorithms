package easy.string;

public class ExcelSheetNumber171 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('A'));
    }

// the only thing that matters in this problem is
//   transfer 'A' into int, it would be 65
    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = 0;i< s.length();i++){
            Integer c =(int)( s.charAt(i)) -64;
            sum = sum *26 + c;
        }
        return sum;
    }
}
