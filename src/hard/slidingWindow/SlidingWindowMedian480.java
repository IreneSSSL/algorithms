package hard.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {

    public static void main(String[] args) {
        int[] a = {2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        new SlidingWindowMedian480().medianSlidingWindow(a,3);
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Double> bigger = new PriorityQueue<>();
        PriorityQueue<Double> smaller = new PriorityQueue<>( (a, b)->(int) (b-a) );

        double[] res = new double[nums.length-k+1];
        if (k==1){
            int index =0;
            for (int i: nums) res[index++] = i;
            return res;
        }
        for(int i =0;i<k;i++){
            if (bigger.size() < k/2) {
                bigger.add( (double) nums[i]);
            }else if ( nums[i] > bigger.peek() ){
                double small = bigger.poll();
                smaller.add(small);
                bigger.add((double)nums[i]);
            } else {
                smaller.add((double)nums[i]);
            }
        }
        if ( k %2 == 0) {
            res[0] =  bigger.peek()/2+smaller.peek()/2 ;
        } else {
            res[0] = smaller.peek();
        }
        for (int i = k;i< nums.length;i++){
            boolean a = bigger.remove((double)nums[i-k]);
            if (!a){
                smaller.remove( (double) nums[i-k]);
            }

            if(bigger.isEmpty()){
                bigger.add(smaller.poll());
            }
            if ( nums[i] > bigger.peek() ){
                double small = bigger.poll();
                smaller.add(small);
                bigger.add( (double)nums[i]);
            } else {
                smaller.add((double) nums[i]);
            }
            while ( bigger.size() > k/2){
                smaller.add(bigger.poll());
            }
            while (bigger.size()<k/2){
                bigger.add(smaller.poll());
            }


            if ( k %2 == 0) {
                res[i-k+1] = bigger.peek()/2+smaller.peek()/2 ;
            } else {
                res[i-k+1] = smaller.peek();
            }
        }
        return res;

    }


    public double[] medianSlidingWindow2(int[] a, int k) {
        int n = a.length;
        List<Integer> w = new ArrayList();
        for(int i = 0; i < k; i++)
            add(w, a[i]);
        double[] ans = new double[n-k+1];
        ans[0] = median(w, k);
        for(int i = k; i < n; i++) {
            remove(w, a[i-k]);
            add(w, a[i]);
            ans[i-k+1] = median(w, k);
        }
        return ans;
    }

    private void add(List<Integer> w, int x) {
        int i = Collections.binarySearch(w, x);
        i = i < 0 ? -i-1 : i;
        w.add(i, x);
    }

    private void remove(List<Integer> w, int x) {
        int i = Collections.binarySearch(w, x);
        w.remove(i);
    }

    private double median(List<Integer> w, int k) {
        if(k % 2 == 0) {
            long a = w.get((k-1) / 2);
            long b = w.get(k / 2);
            return a + (double)(b-a)/2;
        } else {
            return w.get(k / 2);
        }
    }

}
