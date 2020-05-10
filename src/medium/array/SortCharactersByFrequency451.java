package medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortCharactersByFrequency451 {


//    和347题的思想是一样的，先对string里的字符排序，
//    然后新建一个list数组，这个数组和map的本质是一样的，但是好处是有序的
//    frequencies[i]是一个list，代表出现i次的所有char集合
//    出现相同次数的字符被放在同一个frequencies[i]中，然后只要从frequencies数组开始倒序查找即可
    public String frequencySort(String s) {
        List<Character>[] frequencies = new LinkedList[s.length()+1];
        char[] array =s.toCharArray();
        Arrays.sort(array);
        int count=1;
        for(int i=0;i<array.length;i++){
            if ( i== array.length-1 || array[i] != array[i+1] ) {
                if (frequencies[count] == null) { frequencies[count] = new LinkedList<Character>();}
                frequencies[count].add(array[i]);
                count=1;
            }else {
                count++;
            }
        }


        int step =0;
        for (int i=frequencies.length-1;i>=0;i--){
            if( frequencies[i] == null) continue;
            List<Character> chars = frequencies[i];
            for (Character ch : chars){
                for (int j =0;j<i;j++){
                    array[step++] = ch;
                }
            }

        }
        return String.valueOf(array);
    }
}
