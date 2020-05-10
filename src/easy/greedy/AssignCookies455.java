package easy.greedy;

import java.util.Arrays;

public class AssignCookies455 {

//    最基础的贪心法，每次只解决当前最优，最后就是全局最优
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int size =0;
        int index =0;
        for ( int i = 0;i<g.length;i++ ){
            while(index< s.length && s[index]< g[i])index++;
            if (index < s.length) {
                size++;
                index++;
            }else {
                break;
            }
        }
        return size;
    }

}
