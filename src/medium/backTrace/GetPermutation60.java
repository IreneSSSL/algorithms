package medium.backTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPermutation60 {
    public static void main(String[] args) {
        System.out.println(new GetPermutation60().getPermutation(4, 9));
    }
    public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }

        int k_adj = k - 1;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int level = (k_adj / fact);
            sb.append(num.remove(level));
            k_adj -= level * fact;
        }
        return sb.toString();
    }

    int count = 0;
    List<Integer> list = new LinkedList<>();
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n+1];
        used[0]=true;
        helper(used, k, new LinkedList<Integer>());
        StringBuilder builder = new StringBuilder("");
        for (Integer i: list){
            builder.append(i);
        }
        return builder.toString();

    }
    public void helper(boolean[] used, Integer left,LinkedList<Integer> tmp ){

        if(tmp.size() == used.length -1) {
            count++;
            if ( count == left ) {
                list.addAll(tmp);
                return;
            }
        }

        for (int i = 1;i< used.length;i++){
            if (used[i]) continue;
            tmp.add(i);
            used[i] = true;
            helper(used, left, tmp);
            used[i] = false;
            tmp.removeLast();
        }
    }
}
