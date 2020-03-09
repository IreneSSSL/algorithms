import java.util.ArrayList;
import java.util.HashMap;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.keySet().contains(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.keySet().contains(nums2[i])) {
                list.add(nums2[i]);
                int cnt = map.get(nums2[i]) - 1;
                if (cnt == 0) {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], cnt);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();


    }

//    this is not a smart method to solve this problem. But now it is the smartest method I can do.
//    traverse nums1 and store its number and its occurrence times in a hashmap
//    traverse nums2 and if the number exists in the map, put it into a list and reduce the occurrence field with 1 from the map.

    public static void main(String[] args) {
        int[] b = {1, 2};
        int[] a = {1, 1};
        new Intersect().intersect(a, b);
    }

}
