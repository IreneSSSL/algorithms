package medium.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations77 {

    public static void main(String[] args) {
        new Combinations77().combine(4, 2);
    }



//    typical backtracing problem
    List<List<Integer>> re = new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        helper(1, n, new LinkedList<Integer>(), k);
        return re;
    }

    public void helper(int start, int n, List<Integer> current, int k) {
        if (current.size() == k) {
            re.add(new LinkedList<>(current));
            return;
        }
        if (start > n && current.size() < k) return;
        for (int i = start; i <= n; i++) {
            current.add(i);
            helper(i + 1, n, current, k);
            current.remove(current.size() - 1);
        }
    }
}
