package medium.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LRUcache146 {



    public static void main(String[] args) {
        String  s ="ate";
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String ss = String.valueOf(c);
        System.out.println(ss);
    }
    int cap = 0;
    class DoubleListNode{
        int key;
        int val;
        DoubleListNode next;
        DoubleListNode pre;

        public DoubleListNode(int k, int v){
            this.val = v;
            this.key = k;
        }
    }

    //     key:doublelistnode's key  value:doublelistnode
    HashMap<Integer, DoubleListNode> map = new HashMap<>();
    DoubleListNode head;
    DoubleListNode tail;
    public LRUcache146(int capacity) {
        this.cap =  capacity;
        this.head = new DoubleListNode(-1,-1);
        this.tail = new DoubleListNode(-1,-1);
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        DoubleListNode node = map.get(key);
        if (node != null) {
            DoubleListNode previous = node.pre;
            previous.next = node.next;
            node.next.pre = previous;

            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            return map.get(key).val;
        } else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() == 0){
            DoubleListNode node = new DoubleListNode(key, value);
            head.next = node;
            node.pre = head;
            node.next = tail;
            tail.pre = node;
            map.put(key, node);
            return;
        }

//         先判断 是否已经存在
        if(  map.keySet().contains(key)){
            DoubleListNode node = map.get(key);
            node.val = value;
            if (node.next.val == -1) return;

            DoubleListNode previous = node.pre;
            previous.next = node.next;
            node.next.pre = previous;

            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            return;
        } else {
//         再判断是否要删除头部的元素（capacity达到上限）
            DoubleListNode n = head.next.next;
            if (this.cap == map.size()){
                int k = head.next.key;
                map.remove(k);
                head.next = n;
                n.pre = head;

            }
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            n = tail.pre;
            node.next = tail;
            node.pre = n;
            n.next = node;
            tail.pre = node;
        }


    }
}
