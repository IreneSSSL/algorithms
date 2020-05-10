package medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class TopKFrequentElements347 {


    public static void main(String[] args) {
        int[] a = {4,1,-1,2,-1,2,3};
        new TopKFrequentElements347().topKFrequent(a, 2);
    }



//    精妙！！！
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] frequencies = new ArrayList[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || (nums[i] != nums[i + 1])) {
                if ((frequencies[count] == null)) {
                    frequencies[count] = new ArrayList<>();
                }
                frequencies[count].add(nums[i]); // 出现count次的数字，都放一起
                count = 1;
            } else {
                count++;
            }
        }
        int cnt = k;
        for (int i = frequencies.length - 1; i > 0; i--) {
            //数字出现的次数，从1到nums.length次不等，所以frequencies的长度是nums.length
//            然后从大到小依次取出K个就够了，精妙！
            if ((frequencies[i] != null) && cnt > 0) {
                for (int item : frequencies[i]) {
                    list.add(item);
                    if (--cnt == 0) break;
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public int[] topKFrequent2(int[] nums, int k) {

        int[] heap = new int[k+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        int start = 0;
        for (int i = 1;i<nums.length;i++){
            if (nums[i] != nums[i-1]){
                map.put(nums[i-1], i-start);
                start= i;
            }
        }
        map.put(nums[nums.length-1], nums.length-start);

        int[] re = new int[k];
        for(int i =0;i<k;i++){
            int j = 0;
            for ( Integer number: map.keySet()){
                if (j+i < k+1){
                    heap[j] = number;
                    heapSort(heap,j, map);
                }else {
                    heap[k] = number;
                    heapSort(heap,k,map);
                }
                j++;
            }
            map.remove(heap[0]);
            re[i] = heap[0];
        }
        return re;

    }

    public void heapSort(int[] heap, int end, HashMap<Integer, Integer> map){
        int parent = (end-1)/2;
        while (map.get(heap[parent]) < map.get(heap[end])) {
            int tmp = heap[parent];
            heap[parent] = heap[end];
            heap[end] = tmp;
            end = parent;
            parent = (end-1)/2;
            if (end == 0) break;
        }
    }

}
