package medium.math;

import java.util.*;

public class FourSum18 {

    public static void main(String[] args) {
        int[] nums={375,440,492,441,470,331};
        new FourSum18().fourSum(nums, 1682);
    }


//    this is my solution, only beat 15% in runtime.
//    this is also my original idea to solve 3sum problem.
//    but actually this is not a smart idea. it works, but not smart enough.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> sumToEle = new HashMap<>();
        for (int i = 0;i< nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                Integer sum = nums[i]+nums[j];
                List<Integer> additions =  sumToEle.get(sum) == null? new LinkedList<Integer>() : sumToEle.get(sum);
                if (!additions.contains(Integer.valueOf(nums[i])) && !additions.contains(Integer.valueOf(nums[j]))){
                    additions.add(nums[i]);
                }
                sumToEle.put(sum, additions);
            }
        }
        Set<List<Integer>> re = new HashSet<List<Integer>>();
        Set<List<Integer>> dup = new HashSet<List<Integer>>();
        Set<Integer> calculated = new HashSet<Integer>();
        for (Integer addition : sumToEle.keySet()){
            if ( calculated.contains(addition) || calculated.contains(target-addition)) {
                continue;
            }
            List<Integer> firstList = sumToEle.get(addition);
            List<Integer> secondList = sumToEle.get((target - addition));
            if (firstList == null || secondList == null) continue;
            calculated.add(addition);
            calculated.add(target - addition);
            for (Integer firstEles : firstList){
                for(Integer secondEles: secondList){
                    List<Integer> li = new LinkedList<>();
                    li.add(firstEles);
                    li.add(addition - firstEles);
                    li.add(secondEles);
                    li.add(target - addition - secondEles);
                    Collections.sort(li);
                    if ( new HashSet<Integer>(li).size() != li.size()){
                        dup.add(li);
                    } else {
                        re.add(li);
                    }
                }
            }
        }
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int i: nums){
            if (numToCnt.get(i) == null){
                numToCnt.put(i,1);
            } else {
                numToCnt.put(i, 1+ numToCnt.get(i));
            }
        }
        boolean noDup = true;
        for (List<Integer> list : dup){
            Map<Integer, Integer> tmp = new HashMap<>();
            tmp.putAll(numToCnt);
            noDup=true;
            for (Integer ele : list){
                int cnt = tmp.get(ele);
                if (cnt <=0){
                    noDup = false;
                    break;
                } else {
                    tmp.put(ele, tmp.get(ele)-1);
                }
            }
            if (noDup) re.add(list);
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        res.addAll(re);
        return res;

    }




//  best solution
//    sort it
//    fixed two elements, then two pointers at the start and end position
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = nums[n-2] + nums[n-1];
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int remain = target - nums[i] - nums[j];
                int minSum = nums[j+1] + nums[j+2];
                if (remain < minSum || remain > maxSum) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (remain == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < remain) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
