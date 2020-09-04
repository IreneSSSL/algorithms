package medium.backtracking;

import java.util.*;

public class Permutation47 {

    Set<List<Integer>> result = new HashSet<List<Integer>>();
    // List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        LinkedList<Integer> current = new LinkedList<>();
        for (int num: nums) current.add(num);
        helper(new LinkedList<Integer>(), current);
        List<List<Integer>> finalResult = new LinkedList<List<Integer>>(result);
        return finalResult;
    }

    public void helper( LinkedList<Integer> list, LinkedList<Integer> current){
        if (current.size() == 0) {
            LinkedList<Integer> l = new LinkedList<>();
            l.addAll(list);
            result.add(l);
            return;
        }
        LinkedList<Integer> left = new LinkedList<>();
        left.addAll(current);
        for ( Integer n : current){
            list.add (n);
            left.clear();
            left.addAll(current);
            left.remove(n);
            helper( list, left);
            list.removeLast();
        }

    }

}
