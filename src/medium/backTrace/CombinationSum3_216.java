package medium.backTrace;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum3_216 {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        helper(k,n,new LinkedList<Integer>(), 1);
        return result;
    }

    public void helper(int k, int n, LinkedList<Integer> list, int start){
        if (k==0 && n==0){
            LinkedList<Integer> re = new LinkedList<>();
            re.addAll(list);
            result.add(re);
            return;
        }
        // if(start == 10) return;
        if( k<0 || n<0 ) return;

        for(int i= start;i<10;i++){
            list.add(i);
            helper(k-1, n-i, list,i+1);
            list.removeLast();
        }

    }
}
