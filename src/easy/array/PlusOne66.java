package easy.array;

public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        if (digits == null){
            return digits;
        }
        int[] one = new int[digits.length];
        one[digits.length-1] = 1;
        int extra = 0;
        for (int i = digits.length -1 ;i>=0;i--){
            if (extra == 0 && one[i] ==0){
                break;
            }
            int sum = digits[i] + one[i] +extra;
            extra = sum/10;
            digits[i] = sum%10;
        }
        if (extra !=0){
            int[] re = new int[digits.length +1];
            for (int i = 0;i < digits.length;i++){
                re[i+1] = digits[i];
            }
            re[0] = extra;
            return re;
        }
        return digits;

    }


//  similar to add two numbers problem.
//    reach 0ms with current code
//    the essence is set a carry signal.




    public static void main(String[] args) {
        int[] a = {9};
        new PlusOne66().plusOne(a);
    }
}
