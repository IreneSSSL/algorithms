package easy.math;

public class IsHappy202 {

//    this solution is mathematical and tricky,
//    according to some evidence, all unhappy number will turn to 4 during their infinite iteration.
//    这题没劲
    public boolean isHappy(int n) {
        int sum = 0; //
        while (n != 1 && n != 4){
            sum = 0;
            while (n > 0 ){
                sum = sum + (n%10)*(n%10)  ;
                n = n/10;
            }
            n = sum;
        }
        return n == 1;
    }
}
