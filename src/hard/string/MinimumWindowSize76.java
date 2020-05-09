package hard.string;

import medium.dp.MaximumProductSubarray152;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumWindowSize76 {

    public static void main(String[] args) {
        String S = "Aa"; String T = "aa";
        System.out.println(new MinimumWindowSize76().minWindow(S,T));
    }

    public String minWindow(String s, String t) {
        if ( s.length() == 0 || t.length() ==0 || s.length() < t.length() ) return "";
        if (t.length() == 1) {
            if (s.contains(t)){
                return t;
            } else return "";
        }
        int[] tcount = new int[52];
        char[] tchar = t.toCharArray();
        char[] schar = s.toCharArray();
        for (char ch: tchar){
            if ( (int)ch <91)  tcount[ch-'A']++;
            else tcount[ch-'a' + 26 ]++;
        }
        int[] tcount2 = new int[52];
        Queue<Integer> queue = new LinkedList<Integer>();
        int head = 0;
        int tail = 0;
        int minHead = 0;
        int minTail = s.length()-1;

        int size = 0;
        boolean reach = false;
        while (tail <= s.length() -1){
            int index = 0;
            if (schar[tail] < 91) index = schar[tail]-'A';
            else index = schar[tail] -'a' + 26;

            if ( tcount[index] !=0 ) {
                if (queue.isEmpty()) queue.add(tail);
                else if (tail > queue.peek()){
                    queue.add(tail);
                }
                tcount2[index]++;
                if ( tcount2[index] <= tcount[ index ]){
                    size++;
                }
                if(size == t.length()){
                    reach = true;
                    if ( minTail-minHead > tail-head){
                        minTail = tail;
                        minHead = head;
                    }
                    if (queue.isEmpty()) break;
                    head = queue.poll();
                    tail = head;
                    size = 0;
                    tcount2=new int[52];

                } else {
                    tail++;
                }
            }else {
                tail++;
            }
        }

        if (reach) return s.substring(minHead, minTail+1);
        return "";
    }

}
