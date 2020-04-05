package medium.backTrace;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets78 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        new Subsets78().subsets(a);
    }

//    this is solve by myself, but it's slow compared to other's solution.
    Set<List<Integer>> re = new HashSet<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        re.add( new LinkedList<Integer>());
        for (int i=1;i<= nums.length; i++){  //i=1
            for (int j=0;j< nums.length; j++){
                int[] sub = new int[i];
                sub[0] = nums[j];
                helper(nums, sub, 1);
            }
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>(re);
        return res;
    }

    public void helper(int[] nums, int[] sub, int unfixed){
        if (unfixed == sub.length){
            Arrays.sort(sub);
            re.add(Arrays.stream( sub ).boxed().collect(Collectors.toList()));
            return;
        }
        List<Integer> parent = Arrays.stream( nums ).boxed().collect(Collectors.toList());
        List<Integer> son = Arrays.stream( sub ).boxed().collect(Collectors.toList()).subList(0,unfixed);
        LinkedList<Integer> left = new LinkedList<>();
        parent.removeAll(son);
        left.addAll(parent);
        while ( left.peek()!=null ){
            while (left.peek()!=null && left.peek()< sub[unfixed-1]){
                left.pop();
            }
            if(left.peek()==null) return;
            sub[unfixed] = left.pop();
            helper(nums, sub, unfixed+1);
        }
    }




//    this is a faster solution
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}
