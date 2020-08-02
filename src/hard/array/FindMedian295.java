package hard.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FindMedian295 {

    public static void main(String[] args) {
        FindMedian295 f = new FindMedian295();
        f.addNum(5);
        f.addNum(6);
        f.addNum(7);
        f.addNum(8);
        f.addNum(4);
        f.addNum(3);
    }
//    LinkedList<Integer> left;LinkedList<Integer> right ;
//    /** initialize your data structure here. */
//    public FindMedian295() {
//        left = new LinkedList<>();
//        right = new LinkedList<>();
//    }
//
//    public void addNum(int num) {
//        if (left.size() == 0 && right.size() == 0) {
//            right.add(num);
//            return;
//        }
//        if (left.size()+right.size() == 1){
//            if (num <= right.getFirst() ) left.add(num);
//            else{
//                left.add(right.removeFirst());
//                right.add(num);
//            }
//            return;
//        }
//        int leftMax = left.getLast();
//        int rightMin = right.getFirst();
//        if (num <= leftMax){
//            int index = getIndex(left, num);
//            left.add(index, num);
//        }else {
//            int index = getIndex(right, num);
//            right.add(index,num);
//        }
//
//        int size =( left.size()+right.size() )/2;
//        if (left.size() ==size || size== right.size() ) return;
//        while( left.size() != size){
//            if(left.size()>size){
//                int cur = left.removeLast();
//                int index = getIndex(right, cur);
//                right.add(index, cur);
//            }else{
//                int cur = right.removeFirst();
//                int index = getIndex(left, cur);
//                left.add(index, cur);
//            }
//        }
//
//
//    }
//    public int getIndex(LinkedList<Integer> list, int target){
//        Integer[] array =(Integer[]) list.toArray(new Integer[list.size()]);
//        int index = Arrays.binarySearch(array, target);
//        if (index < 0) index = -(index +1);
//        return index;
//    }
//
//    public double findMedian() {
//        if (left.size() == right.size()){
//            double mid = (double) left.getLast();
//            mid = (mid + right.getFirst() )/2;
//            return mid;
//        }else {
//            if (left.size() > right.size()){
//                return left.getLast();
//            }else {
//                return right.getFirst();
//            }
//        }
//    }



    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    /** initialize your data structure here. */
    public FindMedian295() {
        left = new PriorityQueue<Integer>(Collections.reverseOrder());
        right = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(left.isEmpty() || num > left.peek()) {
            right.offer(num);
        } else {
            left.offer(num);
        }
        if(left.size() - right.size() > 1) {
            int l = left.poll();
            right.offer(l);
        } else if (right.size() - left.size() > 1) {
            int r = right.poll();
            left.offer(r);
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) {
            int l = left.peek();
            int r = right.peek();
            return ((double)l + r) / 2.0;
        } else if(right.size() > left.size()){
            return right.peek() / 1.0;
        } else {
            return left.peek() / 1.0;
        }
    }
}
