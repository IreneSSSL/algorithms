package easy.math;

public class Recursive278 {

    public static void main(String[] args) {
        int n = 2126753390;
        System.out.println( new Recursive278().firstBadVersion(n));
    }

    public static boolean isBadVersion(int n){
        if(n <1702766719){
            return false;
        }
        return true;
    }
    public int firstBadVersion(int n) {
        if(n == 1){
            return n;
        }
        return (int)check(1,n);

    }

    public double check(double start,double end){
        if(end-start == 0){
            return end;
        }
        int s = (int) ((end+start)/2);
        if (!isBadVersion(s)){
            return check( 1+(end+start)/2,end );
        } else {
            return  check(start, (end+start)/2 );
        }

    }

}
