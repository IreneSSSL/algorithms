package medium.string;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.*;

public class LargestNumber179 {
    public static void main(String[] args) {
//[9051,5526,2264,5041,1630,5906,6787,8382,4662,4532,6804,4710,4542,2116,7219,8701,8308,957,8775,4822,396,8995,8597,2304,8902,830,8591,5828,9642,7100,3976,5565,5490,1613,5731,8052,8985,2623,6325,3723,5224,8274,4787,6310,3393,78,3288,7584,7440,5752,351,4555,7265,9959,3866,9854,2709,5817,7272,43,1014,7527,3946,4289,1272,5213,710,1603,2436,8823,5228,2581,771,3700,2109,5638,3402,3910,871,5441,6861,9556,1089,4088,2788,9632,6822,6145,5137,236,683,2869,9525,8161,8374,2439,6028,7813,6406,7519]
        String a = "830 8308";
        String e = "8308 830";

        new LargestNumber179().largestNumber( new int[]{830,8308});
    }
    public String largestNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] list = new List[10];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        StringBuilder str = new StringBuilder("");
        for (int i=0;i< nums.length;i++){
            int left = nums[i];
            while ( left > 9) left/=10;
            if (list[left] == null) list[left] = new LinkedList<Integer>();
            list[left].add(nums[i]);
        }

        for (int i=9;i>=0;i--){
            List<Integer> current = list[i];
            if (current == null) continue;
            long[][] longs = new long[current.size()][2];
            for ( int count=0;count <current.size();count++){
                longs[count][0] =(long) current.get(count);
                longs[count][1] = count;
            }
            Arrays.sort(longs, new Comparator<long[]>(){
                public int compare(long[] a, long[] b){
                    int multiplierA = 10;
                    int multiplierB = 10;
                    long aa = a[0];
                    long bb = b[0];
                    while (aa >9) { multiplierA *=10; aa=aa/10;}
                    while (bb >9) { multiplierB *=10; bb=bb/10;}

                    if (b[0]* multiplierA + a[0] > a[0]* multiplierB + b[0]) return 1;
                    if (b[0]* multiplierA + a[0] == a[0]* multiplierB + b[0]) return 0;
                    return -1;
                }
            });
            for (int count = 0;count< current.size();count++){
                str.append(current.get((int) longs[count][1]) ) ;
            }
        }
        System.out.println(str.toString());
        if (str.toString().startsWith("0")) return "0";
        return str.toString();
    }






    public String largestNumber2(int[] nums) {
        Arrays.sort(nums);
        List<Integer>[] list = new List[10];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        StringBuilder str = new StringBuilder("");
        for (int i=0;i< nums.length;i++){
            int left = nums[i];
            while ( left > 9) left/=10;
            if (list[left] == null) list[left] = new LinkedList<Integer>();
            list[left].add(nums[i]);
        }

        for (int i=9;i>=0;i--){
            List<Integer> current = list[i];
            if (current == null) continue;
            char[][] array = new char[current.size()][10];
            long[][] longs = new long[current.size()][2];
            for ( int count=0;count <current.size();count++){
                Arrays.fill(array[count], (char)('0'+i));
                char[] chars = String.valueOf(current.get(count)).toCharArray();
                for (int index = 0;index< chars.length;index++){
                    array[count][index] = chars[index];
                }
                longs[count][0] = Long.parseLong(new String(array[count]));
                longs[count][1] = count;
            }
            Arrays.sort(longs, new Comparator<long[]>(){
                public int compare(long[] a, long[] b){
                    if (b[0] <a[0]) return -1;
                    if (b[0] == a[0]) return 0;
                    return 1;
                }
            });
            for (int count = 0;count< current.size();count++){
                str.append(current.get((int) longs[count][1]) ) ;
            }
        }
        System.out.println(str.toString());
        if (str.toString().startsWith("0")) return "0";
        return str.toString();
    }
}
