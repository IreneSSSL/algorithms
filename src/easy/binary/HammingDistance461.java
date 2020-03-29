package easy.binary;

public class HammingDistance461 {

    public int hammingDistance(int x, int y) {
        if( x<0 || y<0){
            return 0;
        }
        int c = x^y;
        int cnt = 0;
        while (c > 0){
            c = c &(c-1);
            cnt++;
        }
        return cnt;

    }
}
