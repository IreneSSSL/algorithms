package medium.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InsertDeleteDesign380 {

    public static void main(String[] args) {
        InsertDeleteDesign380 insertDeleteDesign380 = new InsertDeleteDesign380();
        boolean a = insertDeleteDesign380.insert(1);
        System.out.println(a);
         a = insertDeleteDesign380.insert(2);
        System.out.println(a);
         a = insertDeleteDesign380.remove(1); System.out.println(a);
         a = insertDeleteDesign380.insert(2); System.out.println(a);

    }

    List<Integer> set;
    /** Initialize your data structure here. */
    public InsertDeleteDesign380() {
        set = new LinkedList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        HashSet<Integer> ss = new HashSet<>(set);
        if (ss.contains(val)) return false;
        set.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        HashSet<Integer> ss = new HashSet<>(set);
        if (!set.contains(val)) return false;
        boolean a = set.remove((Object)val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = set.size();
        Random r = new Random();
        return set.get( r.nextInt(size));
    }

}
