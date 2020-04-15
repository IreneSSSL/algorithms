package medium.dp;

public class CountingBIts338 {
    public static void main(String[] args) {
        System.out.println((int)'9');
//        Integer.valueOf("33")
    }

//    dp & binary
    public int[] countBits(int num) {
        if( num < 0) return new int[]{0};
        if (num==0) return new int[]{0};
        int[] bi = new int[num+1];
        bi[0] = 0;
        bi[1]  =1;
        for (int i=2;i<num+1;i++){
            bi[i] = bi[i>>1] + (i&1);
        }
        return bi;
    }
}
