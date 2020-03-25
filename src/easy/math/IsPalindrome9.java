package easy.math;

public class IsPalindrome9 {



//    run time 7ms
    public boolean isPalindrome(int x) {
        if(x <0) return false;
        int num = 0;
        int origin =x;
        while (x > 0){
            int remainer = x % 10;
            if (num > (Integer.MAX_VALUE-remainer)/10) return false;
            num = 10* num + remainer;
            x = x/10;
        }
        if (origin == num) return true;
        return false;
    }


//    this is the fastest way(6ms), smart thought!
    public boolean isPalindrome2(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

}
