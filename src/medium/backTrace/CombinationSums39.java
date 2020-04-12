package medium.backTrace;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationSums39 {


//    backtracing
    HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return new LinkedList<List<Integer>>(set);
        if (target<=0) return new LinkedList<List<Integer>>(set);
        Arrays.sort(candidates);
        for(int i=0;i< candidates.length;i++){
            if(candidates[i] > target) break;
            helper(new LinkedList<Integer>(), candidates, i, target);
        }
        return new LinkedList<List<Integer>>(set);
    }

    public boolean helper(LinkedList<Integer> list, int[] candidates, int index, int target){
        if(target == 0){
            set.add(new LinkedList<Integer>(list));
            return true;
        }else if (target < 0 ) return false; // if it has already larger than the target, you dont need to try the rest numbers. since they are all larger than the current one
        boolean re = true;
        for (int i = index;re && i<candidates.length;i++){
            list.add(candidates[i]);
            re = helper(list, candidates, i, target-candidates[i]);
            list.remove( list.indexOf(candidates[i]));
        }
        return true;
    }


}
